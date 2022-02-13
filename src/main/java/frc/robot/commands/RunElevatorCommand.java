package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class RunElevatorCommand extends CommandBase {
  private static final double ELEVATOR_SPEED = 1.0;
  private final ElevatorSubsystem elevator;

  public RunElevatorCommand(ElevatorSubsystem elevator) {
    this.elevator = elevator;
    addRequirements(elevator);
  }

  @Override public void initialize() {
    elevator.stop();
  }

  @Override public void execute() {
    elevator.setSpeed(ELEVATOR_SPEED);
  }

  @Override public void end(boolean interrupted) {
    elevator.stop();
  }
}