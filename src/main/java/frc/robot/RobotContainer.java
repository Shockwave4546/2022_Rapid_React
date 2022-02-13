package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunElevatorCommand;
import frc.robot.commands.RunIntakeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
  protected final TelemetryManager telemetryManager = new TelemetryManager();
  protected final XboxController driveController = new XboxController(Constants.DRIVE_CONTROLLER_PORT);
  private final XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER_PORT);
  private final JoystickButton joystickA = new JoystickButton(operatorController, XboxController.Button.kA.value);
  private final JoystickButton rightBumper = new JoystickButton(operatorController, XboxController.Button.kRightBumper.value);
  protected final DriveSubsystem drive = new DriveSubsystem();
  private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();

  public RobotContainer() {
    // rightBumper.whenHeld(new RunIntakeCommand(intake));
    // joystickA.toggleWhenPressed(new RunElevatorCommand(elevator));
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }
}