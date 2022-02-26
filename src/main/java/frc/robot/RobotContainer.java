package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  protected final TelemetryManager telemetry = new TelemetryManager();
  protected final XboxController driveController = new XboxController(Constants.DRIVE_CONTROLLER_PORT);
  private final XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER_PORT);
  private final Drivetrain drive = new Drivetrain();
  private final Elevator elevator = new Elevator();
  private final Intake intake = new Intake();

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }
}