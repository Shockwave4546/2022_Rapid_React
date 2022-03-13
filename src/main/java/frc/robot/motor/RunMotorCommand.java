package frc.robot.motor;

public class RunMotorCommand extends SimpleMotorCommand<SimpleMotorSubsystem> {
  public RunMotorCommand(SimpleMotorSubsystem subsystem) {
    super(subsystem, false);
  }
}