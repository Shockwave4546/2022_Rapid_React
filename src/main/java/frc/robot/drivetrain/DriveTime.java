package frc.robot.drivetrain;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTime extends CommandBase {
  private final Instant timeComplete;
  private final double speed;
  private final Drivetrain drive;

  public DriveTime(long seconds, double speed, Drivetrain drive) {
    this.timeComplete = Instant.now().plus(Duration.ofSeconds(seconds));
    this.speed = speed;
    this.drive = drive;
  }

  @Override public void initialize() {
    drive.stop();
  }

  @Override public void execute() {
    drive.tankDrive(speed, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.stop();
  }

  @Override public boolean isFinished() {
    return Instant.now().isAfter(timeComplete);
  }
}