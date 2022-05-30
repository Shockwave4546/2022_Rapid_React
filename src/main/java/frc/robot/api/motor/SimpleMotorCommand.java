package frc.robot.api.motor;

import java.time.Duration;

import frc.robot.api.command.TimedCommand;

public abstract class SimpleMotorCommand<T extends SimpleMotorSubsystem> extends TimedCommand {
  public final T subsystem;
  private final boolean inverted;

  public SimpleMotorCommand(T subsystem, boolean inverted, Duration duration) {
    super(duration);
    this.subsystem = subsystem;
    this.inverted = inverted;
    addRequirements(subsystem);
  }

  public SimpleMotorCommand(T subsystem, boolean inverted) {
    this(subsystem, inverted, null);
  }

  @Override public void initialize() {
    super.initialize();
    subsystem.stopMotors();
  }

  @Override public void execute() {
    subsystem.runMotors(inverted);
  }

  @Override public void end(boolean interrupted) {
    subsystem.stopMotors();
  }
}