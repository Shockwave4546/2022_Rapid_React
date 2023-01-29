package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class TeleopTankDrive extends CommandBase {
  private final CommandXboxController controller;
  private final Drivetrain drive;

  public TeleopTankDrive(Drivetrain drive, CommandXboxController controller) {
    this.drive = drive;
    this.controller = controller;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
  }

  @Override public void execute() {
    drive.tankDrive(controller.getLeftY(), controller.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
}