package frc.robot.motor;

import java.time.Duration;
import java.time.Instant;

public class RunMotorInvertedCommand extends SimpleMotorCommand<SimpleMotorSubsystem> {
  private Instant completeTime;
  private final long ms;

  public RunMotorInvertedCommand(SimpleMotorSubsystem subsystem) {
    this(subsystem, -1);
  }

  public RunMotorInvertedCommand(SimpleMotorSubsystem subsystem, long ms) {
    super(subsystem, true);
    this.ms = ms;
  }

  @Override public void initCommand() {
    this.completeTime = Instant.now().plus(Duration.ofMillis(ms));
  }

  @Override public boolean isFinished() {
    return ms == -1 ? false : Instant.now().isAfter(completeTime);
  }
}