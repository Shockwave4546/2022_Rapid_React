package frc.robot;

import static frc.robot.Tabs.DEBUG;

import java.io.File;
import java.io.IOException;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerIO;
import frc.robot.api.motor.RunMotor;
import frc.robot.api.motor.RunMotorInverted;
import frc.robot.auto.OneBallAuto;
import frc.robot.auto.TaxiAuto;
import frc.robot.auto.ThreeBallAuto;
import frc.robot.auto.TwoBallAuto;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.TurnDegrees;
import frc.robot.subsystems.intakepivot.IntakePivot;
import frc.robot.subsystems.intakepivot.PivotIntakeDown;

/**
 * Contains the encapsulated functionality for the {@link Robot} class.
 */
public class RobotContainer {
  /**
   * Initialize controllers
   */
  protected final CommandXboxController driveController = new CommandXboxController(ControllerIO.DRIVE_PORT);
  private final CommandXboxController operatorController = new CommandXboxController(ControllerIO.OPERATOR_PORT);

  /**
   * Initalize all subsystems alongside autonomous chooser
   */
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();
  protected final Drivetrain drive = new Drivetrain();
  protected final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public RobotContainer() {
    initAuto();
    initDebugTab();
    initControllerBindings();
  }

  public Command loadPathPlannerTrajectoryToRamseteCommand(String fileName, boolean resetOdometry) {
    try {
      final var trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(fileName);
      final var trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
      final var ramseteCommand = new RamseteCommand(
        trajectory, 
        drive::getPose, 
        new RamseteController(Constants.Drivetrain.RAMSETE_B, Constants.Drivetrain.RAMSETE_ZETA), 
        new SimpleMotorFeedforward(Constants.Drivetrain.KS_VOLTS, Constants.Drivetrain.KV_VOLT_SECONDS_PER_METER, Constants.Drivetrain.KA_VOLT_SECONDS_SQUARED_PER_METER), 
        drive.getKinematics(), 
        drive::getWheelSpeeds, 
        new PIDController(Constants.Drivetrain.P_DRIVE_VELOCITY, 0, 0), 
        new PIDController(Constants.Drivetrain.P_DRIVE_VELOCITY, 0, 0), 
        drive::tankDriveVolts, 
        drive
      );

      return resetOdometry ? new SequentialCommandGroup(new InstantCommand(() -> drive.resetOdometry(trajectory.getInitialPose())), ramseteCommand) : ramseteCommand;
    } catch (IOException e) {
      DriverStation.reportError("Unable to open trajectory: '" + fileName + "'", e.getStackTrace());
      return new InstantCommand();
    }
  }

  /**
   * Adds the autonomous commands to the chooser.
   */
  private void initAuto() {
    Tabs.MATCH.add(autoChooser);
    autoChooser.setDefaultOption("Do Nothing", new InstantCommand());
    autoChooser.addOption("3 Ball Auto", new ThreeBallAuto(shooter, elevator, drive, intakePivot, intake));
    autoChooser.addOption("2 Ball Auto", new TwoBallAuto(shooter, elevator, drive, intakePivot, intake));
    autoChooser.addOption("1 Ball Auto", new OneBallAuto(shooter, elevator, drive, intakePivot));
    autoChooser.addOption("Taxi", new TaxiAuto(drive, intakePivot));
    autoChooser.addOption("Curvy Line", loadPathPlannerTrajectoryToRamseteCommand("pathplanner" + File.separatorChar + "generatedJSON" + File.separatorChar + "Curvy Line.wpilib.json", true));
    autoChooser.addOption("Straight Line", loadPathPlannerTrajectoryToRamseteCommand("pathplanner" + File.separatorChar + "generatedJSON" + File.separatorChar + "Straight Line.wpilib.json", true));
    autoChooser.addOption("1 One Ball Auto (Trajectory)", loadPathPlannerTrajectoryToRamseteCommand("pathplanner" + File.separatorChar + "generatedJSON" + File.separatorChar + "One Ball Auto.wpilib.json", true));
  }

  /**
   * To test functionalities during runtime, we can assign seperate buttons to
   * each commands to debug individual components
   * of the program as a whole.
   */
  private void initDebugTab() {
    DEBUG.add("Run intake", new RunMotor(intake));
    DEBUG.add("Run elevator", new RunMotor(elevator));
    DEBUG.add("Run elevator backward", new RunMotorInverted(elevator));
    DEBUG.add("Run shooter", new RunMotor(shooter));
    DEBUG.add("Run Intake pivot", new RunMotor(intakePivot));
    DEBUG.add("Run Intake pivot inverted", new RunMotorInverted(intakePivot));
    DEBUG.add("Pivot intake down", new PivotIntakeDown(intakePivot));
    DEBUG.add("Clockwise 90 degrees", new TurnDegrees(drive, 0.65, 90 * 0.68, true));
  }

  /**
   * Assigns button bindings on the driver and operator controllers to functions
   * on the robot.
   * Driver controller:
   * Left Joystick -> Controls speed of left drivetrain motors.
   * Right Joystick -> Controls speeds of right drivetrain motors.
   * Right Trigger -> Drives at a constant speed forward.
   * 
   * Operator Controller:
   * Left Trigger -> Runs intake pivot reversed.
   * Right Trigger -> Runs intake pivot.
   * Right Bumper -> Runs intake.
   * Left Bumper -> Runs elevator.
   * A Button -> Runs shooter.
   * B Button -> Runs elevator inverted.
   * X Button -> Runs intake
   */
  private void initControllerBindings() {
    operatorController.leftTrigger().whileTrue(new RunMotorInverted(intakePivot));
    operatorController.rightTrigger().whileTrue(new RunMotor(intakePivot));
    operatorController.rightBumper().whileTrue(new RunMotor(intake));
    operatorController.leftBumper().whileTrue(new RunMotor(elevator));
    operatorController.a().whileTrue(new RunMotor(shooter));
    operatorController.b().whileTrue(new RunMotorInverted(elevator));
    operatorController.x().whileTrue(new RunMotorInverted(intake));
  }
}