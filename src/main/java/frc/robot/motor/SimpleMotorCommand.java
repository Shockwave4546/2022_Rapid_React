package frc.robot.motor;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class SimpleMotorCommand extends CommandBase {
  public final SimpleMotorSubsystem subsystem;
  private final boolean inverted;

  public SimpleMotorCommand(SimpleMotorSubsystem subsystem, boolean inverted) {
    this.subsystem = subsystem;
    this.inverted = inverted;
    addRequirements(subsystem);
  }

  @Override public void initialize() {
    subsystem.stopMotors();
  }

  @Override public void execute() {
    subsystem.runMotors(inverted);
  }

  @Override public void end(boolean interrupted) {
    subsystem.stopMotors();
  }
}