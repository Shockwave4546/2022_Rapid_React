package frc.robot;

import frc.robot.Constants.ControllerIO;
import frc.robot.Constants.Tabs;
import frc.robot.api.controller.ShockwaveController;
import frc.robot.api.motor.RunMotor;
import frc.robot.api.motor.RunMotorInverted;
import frc.robot.api.shuffleboard.AdjustableSpeed;
import frc.robot.auto.AutonomousManager;
import frc.robot.auto.NewTwoBallAuto;
import frc.robot.auto.OneBallAuto;
import frc.robot.auto.TaxiAuto;
import frc.robot.auto.ThreeBallAuto;
import frc.robot.auto.TwoBallAuto;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.drivetrain.DriveStraight;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.TurnDegrees;
import frc.robot.subsystems.intakepivot.IntakePivot;
import frc.robot.subsystems.intakepivot.PivotIntakeDown;

public class RobotContainer {
  private final ShockwaveController driveController = new ShockwaveController(ControllerIO.DRIVE_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(ControllerIO.OPERATOR_PORT);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();
  protected final Drivetrain drive = new Drivetrain(driveController);
  protected final AutonomousManager auto = new AutonomousManager(Tabs.MATCH);

  public RobotContainer() {
    initAuto();
    initTestTab();
    initControllerBindings();
  }

  private void initAuto() {
    auto.setDefault("3 Ball Auto", new ThreeBallAuto(shooter, elevator, drive, intakePivot, intake));
    auto.addOption("New 2 Ball Auto", new NewTwoBallAuto(shooter, elevator, drive, intakePivot, intake));
    auto.addOption("2 Ball Auto", new TwoBallAuto(shooter, elevator, drive, intakePivot, intake));
    auto.addOption("1 Ball Auto", new OneBallAuto(shooter, elevator, drive, intakePivot));
    auto.addOption("Taxi", new TaxiAuto(drive, intakePivot));
  }

  private void initTestTab() {
    final var test = Tabs.TEST;
    test.add("Run intake", new RunMotor(intake));
    test.add("Run elevator", new RunMotor(elevator));
    test.add("Run elevator backward", new RunMotorInverted(elevator));
    test.add("Run shooter", new RunMotor(shooter));
    test.add("Run Intake pivot", new RunMotor(intakePivot));
    test.add("Run Intake pivot inverted", new RunMotorInverted(intakePivot));
    test.add(new PivotIntakeDown(intakePivot));
    test.add("Clockwise 90 degrees", new TurnDegrees(drive, 0.65, 90 * 0.68, true));
  }

  private void initControllerBindings() {
    final var speed = new AdjustableSpeed("Constant Speed Value", Tabs.SPEEDS, -1.0);
    driveController.rightTrigger.get().whileActiveContinuous(new DriveStraight(drive, speed.get()));
    operatorController.leftTrigger.get().whileActiveContinuous(new RunMotorInverted(intakePivot));
    operatorController.rightTrigger.get().whileActiveContinuous(new RunMotor(intakePivot));
    operatorController.rightBumper.get().whileHeld(new RunMotor(intake));
    operatorController.leftBumper.get().whileHeld(new RunMotor(elevator));
    operatorController.aButton.get().whileHeld(new RunMotor(shooter));
    operatorController.bButton.get().whileHeld(new RunMotorInverted(elevator));
    operatorController.xButton.get().whileHeld(new RunMotorInverted(intake));
  }
}