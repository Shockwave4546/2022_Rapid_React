package frc.robot.motor;

public class RunMotorInvertedCommand extends SimpleMotorCommand<SimpleMotorSubsystem> {
  public RunMotorInvertedCommand(SimpleMotorSubsystem subsystem) {
    super(subsystem, true);
  }
}