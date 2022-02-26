package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ControllerDriveCommand extends CommandBase {
  private final XboxController controller;
  private final Drivetrain drive;

  public ControllerDriveCommand(XboxController controller, Drivetrain drive) {
    this.controller = controller;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
  }

  @Override public void execute() {
    drive.tankDrive(controller.getRightY(), controller.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
}