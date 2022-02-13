package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ControllerDriveCommand extends CommandBase {
  private final XboxController controller;
  private final DriveSubsystem drive;

  public ControllerDriveCommand(XboxController controller, DriveSubsystem drive) {
    this.controller = controller;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
  }

  // TODO: Account for controller drift somehow
  @Override public void execute() {
    drive.tankDrive(controller.getLeftY(), controller.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
}