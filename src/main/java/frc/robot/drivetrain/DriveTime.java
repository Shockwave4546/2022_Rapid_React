package frc.robot.drivetrain;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTime extends CommandBase {
  private Instant timeComplete;
  private final long ms;
  private final double speed;
  private final Drivetrain drive;

  public DriveTime(long ms, double speed, Drivetrain drive) {
    this.ms = ms;
    this.speed = speed;
    this.drive = drive;
  }

  @Override public void initialize() {
    this.timeComplete = Instant.now().plus(Duration.of(ms, ChronoUnit.MILLIS));
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