package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopTankDrive extends CommandBase {
  private final XboxController controller;
  private final Drivetrain drive;

  public TeleopTankDrive(Drivetrain drive, XboxController controller) {
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