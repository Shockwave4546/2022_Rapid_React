package frc.robot.api.command;

import java.time.Duration;
import java.time.Instant;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class TimedCommand extends CommandBase {
  private final Duration duration;
  private Instant complete;
  
  // Null if the command is perpetual
  public TimedCommand(Duration duration) {
    this.duration = duration;
  }

  @Override public void initialize() {
    this.complete = duration == null ? null : Instant.now().plus(duration);
  }

  @Override public boolean isFinished() {
    return duration == null ? false : Instant.now().isAfter(complete);
  }
}