package frc.robot.api.motor;

import java.time.Duration;

public class RunMotorInverted extends SimpleMotorCommand<SimpleMotorSubsystem> {
  public RunMotorInverted(SimpleMotorSubsystem subsystem) {
    super(subsystem, true);
  }

  public RunMotorInverted(SimpleMotorSubsystem subsystem, long ms) {
    super(subsystem, true, Duration.ofMillis(ms));
  }
}