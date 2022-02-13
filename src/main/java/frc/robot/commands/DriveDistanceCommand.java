package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends CommandBase {
  private final double distance; // inches
  private final double speed; 
  private final DriveSubsystem drive;

  public DriveDistanceCommand(double distance, double speed, DriveSubsystem drive) {
    this.distance = distance;
    this.speed = speed;
    this.drive = drive;
  }

  @Override public void initialize() {
    drive.tankDrive(0, 0);
    drive.resetEncoders();
  }

  @Override public void execute() {
    drive.tankDrive(speed, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.tankDrive(0, 0);
  }

  @Override public boolean isFinished() {
    return Math.abs(drive.getAverageDistance()) >= distance;
  }
}