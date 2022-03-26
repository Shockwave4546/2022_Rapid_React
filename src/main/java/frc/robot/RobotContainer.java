package frc.robot;

import static frc.robot.Constants.DRIVE_CONTROLLER_PORT;
import static frc.robot.Constants.MATCH_TAB;
import static frc.robot.Constants.OPERATOR_CONTROLLER_PORT;
import static frc.robot.Constants.TEST_TAB;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.api.controller.ShockwaveController;
import frc.robot.api.motor.RunMotor;
import frc.robot.api.motor.RunMotorInverted;
import frc.robot.auto.AutonomousManager;
import frc.robot.auto.OneBallAuto;
import frc.robot.auto.TaxiAuto;
import frc.robot.auto.TwoBallAuto;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;
import frc.robot.intakepivot.PivotIntakeUp;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  private final ShockwaveController driveController = new ShockwaveController(DRIVE_CONTROLLER_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(OPERATOR_CONTROLLER_PORT);
  protected final Drivetrain drive = new Drivetrain(driveController);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();
  protected final AutonomousManager autoManager = new AutonomousManager(MATCH_TAB);

  public RobotContainer() {
    initAuto();
    initButtonBindings();
    initControllerBindings();
  }

  private void initAuto() {
    autoManager.setDefault("2 Ball Auto", new TwoBallAuto(shooter, elevator, drive, intakePivot, intake));
    autoManager.addOption("1 Ball Auto", new OneBallAuto(shooter, elevator, drive, intakePivot));
    autoManager.addOption("Taxi", new TaxiAuto(drive, intakePivot));
  }

  private void initButtonBindings() {
    TEST_TAB.add("Run intake", new RunMotor(intake));
    TEST_TAB.add("Run elevator", new RunMotor(elevator));
    TEST_TAB.add("Run elevator backward", new RunMotorInverted(elevator));
    TEST_TAB.add("Run shooter", new RunMotor(shooter));
    TEST_TAB.add("Run Intake pivot", new RunMotor(intakePivot));
    TEST_TAB.add("Run Intake pivot inverted", new RunMotorInverted(intakePivot));
    TEST_TAB.add(new PivotIntakeDown(intakePivot));
    TEST_TAB.add(new PivotIntakeUp(intakePivot));
  }

  private void initControllerBindings() {
    new Trigger(() -> operatorController.getLeftTriggerAxis() > 0.2).whileActiveContinuous(new RunMotorInverted(intakePivot));
    new Trigger(() -> operatorController.getRightTriggerAxis() > 0.2).whileActiveContinuous(new RunMotor(intakePivot));
    operatorController.whileHeld(Button.kRightBumper, new RunMotor(intake));
    operatorController.whileHeld(Button.kLeftBumper, new RunMotor(elevator));
    operatorController.whileHeld(Button.kA, new RunMotor(shooter));
    operatorController.whileHeld(Button.kB, new RunMotorInverted(elevator));
    operatorController.whileHeld(Button.kX, new RunMotorInverted(intake));
  }
}