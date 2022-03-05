package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.controller.ShockwaveController;
import frc.robot.drivetrain.ControllerDrive;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  protected final TelemetryManager telemetry = new TelemetryManager();
  private final ShockwaveController driveController = new ShockwaveController(DRIVE_CONTROLLER_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(OPERATOR_CONTROLLER_PORT);
  private final Drivetrain drive = new Drivetrain(driveController);
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();
  private final IntakePivot intakePivot = new IntakePivot();

  public RobotContainer() {
    initControllerButtons();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }

  private void initControllerButtons() {
    // driveControler.whenPressed(Button.kA, command);
  }
  
  public void initCameras() {
    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture();
  }
}