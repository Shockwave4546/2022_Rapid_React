package frc.robot.motor;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class SimpleMotorCommand<T extends SimpleMotorSubsystem> extends CommandBase {
  public final T subsystem;
  private final boolean inverted;

  public SimpleMotorCommand(T subsystem, boolean inverted) {
    this.subsystem = subsystem;
    this.inverted = inverted;
    addRequirements(subsystem);
  }

  public void initCommand() { }

  @Override public void initialize() {
    subsystem.stopMotors();
    initCommand();
  }

  @Override public void execute() {
    subsystem.runMotors(inverted);
  }

  @Override public void end(boolean interrupted) {
    subsystem.stopMotors();
  }
}