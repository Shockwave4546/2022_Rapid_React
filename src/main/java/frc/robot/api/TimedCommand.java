package frc.robot.api;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class TimedCommand extends CommandBase {
  private final TemporalAmount duration;
  private Instant complete;
  
  // Null if the command is perpetual
  public TimedCommand(TemporalAmount duration) {
    this.duration = duration;
  }

  public TimedCommand(int seconds) {
    this(Duration.ofSeconds(seconds));
  }

  public abstract void init();

  @Override public final void initialize() {
    this.complete = duration == null ? null : Instant.now().plus(duration);
    init();
  }

  @Override public boolean isFinished() {
    return duration == null ? false : Instant.now().isAfter(complete);
  }
}