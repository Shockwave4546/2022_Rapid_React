package frc.robot;

import static frc.robot.Tabs.DEBUG;

import frc.robot.Constants.ControllerIO;
import frc.robot.api.controller.ShockwaveController;
import frc.robot.api.motor.RunMotor;
import frc.robot.api.motor.RunMotorInverted;
import frc.robot.auto.AutonomousManager;
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
  private final ShockwaveController driveController = new ShockwaveController(ControllerIO.DRIVE_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(ControllerIO.OPERATOR_PORT);

  /**
   * Initalize all subsystems alongside autonomous chooser
   */
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();
  protected final Drivetrain drive = new Drivetrain(driveController);
  protected final AutonomousManager auto = new AutonomousManager(Tabs.MATCH);

  public RobotContainer() {
    initAuto();
    initDebugTab();
    initControllerBindings();
  }

  /**
   * Adds the autonomous commands to the chooser.
   */
  private void initAuto() {
    auto.setDefault("3 Ball Auto", new ThreeBallAuto(shooter, elevator, drive, intakePivot, intake));
    auto.addOption("2 Ball Auto", new TwoBallAuto(shooter, elevator, drive, intakePivot, intake));
    auto.addOption("1 Ball Auto", new OneBallAuto(shooter, elevator, drive, intakePivot));
    auto.addOption("Taxi", new TaxiAuto(drive, intakePivot));
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
    operatorController.leftTrigger.whileActiveContinuous(new RunMotorInverted(intakePivot));
    operatorController.rightTrigger.whileActiveContinuous(new RunMotor(intakePivot));
    operatorController.rightBumper.whileHeld(new RunMotor(intake));
    operatorController.leftBumper.whileHeld(new RunMotor(elevator));
    operatorController.aButton.whileHeld(new RunMotor(shooter));
    operatorController.bButton.whileHeld(new RunMotorInverted(elevator));
    operatorController.xButton.whileHeld(new RunMotorInverted(intake));
  }
}