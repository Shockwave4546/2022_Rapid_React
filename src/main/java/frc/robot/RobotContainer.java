package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
  protected final TelemetryManager telemetry = new TelemetryManager();
  protected final XboxController driveController = new XboxController(Constants.DRIVE_CONTROLLER_PORT);
  private final XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER_PORT);
  protected final DriveSubsystem drive = new DriveSubsystem();
  private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }
}