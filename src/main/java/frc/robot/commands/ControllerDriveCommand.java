package frc.robot.commands;

import edu.wpi.first.wpilibj.SynchronousInterrupt;
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
    System.out.println(controller.getLeftY() + " " + controller.getRightY());
    // if (controller.getLeftY() > -0.01 && controller.getLeftY() < 0.01) return;
    // if (controller.getRightY() > -0.01 && controller.getRightY() < 0.01) return;

    drive.tankDrive(controller.getLeftY(), controller.getRightY());
  }

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
}