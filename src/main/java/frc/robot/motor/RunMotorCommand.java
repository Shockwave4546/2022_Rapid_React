package frc.robot.motor;

import java.time.Duration;
import java.time.Instant;

public class RunMotorCommand extends SimpleMotorCommand<SimpleMotorSubsystem> {
  private Instant completeTime;
  private final long ms;

  public RunMotorCommand(SimpleMotorSubsystem subsystem) {
    this(subsystem, -1);
  }

  public RunMotorCommand(SimpleMotorSubsystem subsystem, long ms) {
    super(subsystem, false);
    this.ms = ms;
  }

  @Override public void initCommand() {
    this.completeTime = Instant.now().plus(Duration.ofMillis(ms));
  }

  @Override public boolean isFinished() {
    return ms == -1 ? false : Instant.now().isAfter(completeTime);
  }
}