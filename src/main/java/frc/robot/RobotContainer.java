package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.controller.ShockwaveController;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;
import frc.robot.intakepivot.PivotIntakeUp;
import frc.robot.motor.RunMotorCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  protected final TelemetryManager telemetry = new TelemetryManager();
  private final ShockwaveController driveController = new ShockwaveController(DRIVE_CONTROLLER_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(OPERATOR_CONTROLLER_PORT);
  private final Drivetrain drive = new Drivetrain(driveController);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  public final IntakePivot intakePivot = new IntakePivot();

  public RobotContainer() {
    initControllerButtons();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    MAIN_TAB.add(new RunMotorCommand(intakePivot));
    MAIN_TAB.add(new PivotIntakeDown(intakePivot));
    MAIN_TAB.add(new PivotIntakeUp(intakePivot));
  }

  private void initControllerButtons() {
    // driveControler.whenPressed(Button.kA, command);
  }
  
  public void initCameras() {
    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture();
  }
}