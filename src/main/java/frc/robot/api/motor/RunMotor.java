package frc.robot.api.motor;

import java.time.Duration;

public class RunMotor extends SimpleMotorCommand<SimpleMotorSubsystem> {
  public RunMotor(SimpleMotorSubsystem subsystem) {
    super(subsystem, false);
  }

  public RunMotor(SimpleMotorSubsystem subsystem, long ms) {
    super(subsystem, false, Duration.ofMillis(ms));
  }
}