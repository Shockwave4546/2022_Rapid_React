package frc.robot.api.motor;

import java.time.temporal.TemporalAmount;

import frc.robot.api.command.TimedCommand;

public abstract class SimpleMotorCommand<T extends SimpleMotorSubsystem> extends TimedCommand {
  public final T subsystem;
  private final boolean inverted;

  public SimpleMotorCommand(T subsystem, boolean inverted, TemporalAmount duration) {
    super(duration);
    this.subsystem = subsystem;
    this.inverted = inverted;
    addRequirements(subsystem);
  }

  public SimpleMotorCommand(T subsystem, boolean inverted) {
    this(subsystem, inverted, null);
  }

  public void initCommand() {}

  @Override public void init() {
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