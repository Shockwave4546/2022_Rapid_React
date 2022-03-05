package frc.robot.motor;

public class RunMotorInvertedCommand extends SimpleMotorCommand {
  public RunMotorInvertedCommand(SimpleMotorSubsystem subsystem) {
    super(subsystem, true);
  }
}