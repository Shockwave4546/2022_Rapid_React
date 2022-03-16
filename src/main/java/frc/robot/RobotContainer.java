package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.XboxController.Button;
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

public class RobotContainer {
  protected final TelemetryManager telemetry = new TelemetryManager();
  private final ShockwaveController driveController = new ShockwaveController(DRIVE_CONTROLLER_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(OPERATOR_CONTROLLER_PORT);
  private final Drivetrain drive = new Drivetrain(driveController);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();
  private final Shooter shooter = new Shooter();

  public RobotContainer() {
    initButtonBindings();
    initControllerBindings();
  }

  private void initButtonBindings() {
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
    driveController.toggleWhenPressed(Button.kA, new RunMotorCommand(elevator));
  }
}