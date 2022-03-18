package frc.robot;

import static frc.robot.Constants.*;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.auto.DriveBackCommand;
import frc.robot.auto.DumpBackCommands;
import frc.robot.auto.DumpBackDumpCommands;
import frc.robot.controller.ShockwaveController;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;
import frc.robot.intakepivot.PivotIntakeUp;
import frc.robot.motor.RunMotorCommand;
import frc.robot.motor.RunMotorInvertedCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.drivetrain.DriveTime;

public class RobotContainer {
  // protected final TelemetryManager telemetry = new TelemetryManager();
  private final ShockwaveController driveController = new ShockwaveController(DRIVE_CONTROLLER_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(OPERATOR_CONTROLLER_PORT);
  protected final Drivetrain drive = new Drivetrain(driveController);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();

  final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public RobotContainer() {
    initAuto();
    initButtonBindings();
    initControllerBindings();
  }

  private void initAuto() {
    final var dumpDriveback = new DumpBackCommands(shooter, elevator, drive, intakePivot);
    final var driveBack = new DriveBackCommand(drive, intakePivot);
    final var dumpDriveDump = new DumpBackDumpCommands(shooter, elevator, drive, intakePivot, intake);
    autoChooser.addOption("Dump + Drive back", dumpDriveback);
    autoChooser.addOption("Drive back", driveBack);
    autoChooser.addOption("Dump + Drive + Dump", dumpDriveDump);
    MATCH_TAB.add(autoChooser);
  }

  public void runAuto() {
    autoChooser.getSelected().schedule();
  }

  private void initButtonBindings() {
    MAIN_TAB.add("Drive back for 4 seconds", new DriveTime(3, -0.75, drive));
    MAIN_TAB.add("Run intake", new RunMotorCommand(intake));
    MAIN_TAB.add("Run elevator", new RunMotorCommand(elevator));
    MAIN_TAB.add("Run elevator backward", new RunMotorInvertedCommand(elevator));
    MAIN_TAB.add("Run shooter", new RunMotorCommand(shooter));
    MAIN_TAB.add("Run Intake pivot", new RunMotorCommand(intakePivot));
    MAIN_TAB.add("Run Intake pivot inverted", new RunMotorInvertedCommand(intakePivot));
    MAIN_TAB.add(new PivotIntakeDown(intakePivot));
    MAIN_TAB.add(new PivotIntakeUp(intakePivot));
  }

  private void initControllerBindings() {
    new Trigger(() -> operatorController.getLeftTriggerAxis() > 0.2).whileActiveContinuous(new RunMotorInvertedCommand(intakePivot));
    new Trigger(() -> operatorController.getRightTriggerAxis() > 0.2).whileActiveContinuous(new RunMotorCommand(intakePivot));
    operatorController.whileHeld(Button.kRightBumper, new RunMotorCommand(intake));
    operatorController.whileHeld(Button.kLeftBumper, new RunMotorCommand(elevator));
    operatorController.whileHeld(Button.kA, new RunMotorInvertedCommand(shooter));
    operatorController.whileHeld(Button.kB, new RunMotorInvertedCommand(elevator));
    operatorController.whileHeld(Button.kX, new RunMotorInvertedCommand(intake));
  }
}