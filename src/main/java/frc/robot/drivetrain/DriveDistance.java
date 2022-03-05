package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistance extends CommandBase {
  private final double distance; // inches
  private final double speed; 
  private final Drivetrain drive;

  public DriveDistance(double distance, double speed, Drivetrain drive) {
    this.distance = distance;
    this.speed = speed;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
    drive.resetEncoders();
  }

  @Override public void execute() {
    drive.tankDrive(speed, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.stop();
  }

  @Override public boolean isFinished() {
    return Math.abs(drive.getAverageDistance()) >= distance;
  }
}