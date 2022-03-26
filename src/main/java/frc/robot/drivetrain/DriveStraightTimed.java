package frc.robot.drivetrain;

import java.time.Duration;

import frc.robot.api.command.TimedCommand;

public class DriveStraightTimed extends TimedCommand {
  private final Drivetrain drive;
  private final double speed;
  
  public DriveStraightTimed(Drivetrain drive, double speed, long ms) {
    super(Duration.ofMillis(ms));
    this.drive = drive;
    this.speed = speed;
  }

  @Override public void init() {
    drive.stop();
  }

  @Override public void execute() {
    drive.tankDrive(speed, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.stop();
  }
}