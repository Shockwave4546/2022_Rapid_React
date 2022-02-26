package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class RunElevatorCommand extends CommandBase {
  private static final double ELEVATOR_SPEED = 1.0;
  private final Elevator elevator;

  public RunElevatorCommand(Elevator elevator) {
    this.elevator = elevator;
    addRequirements(elevator);
  }

  @Override public void initialize() {
    elevator.stopBelt();
  }

  @Override public void execute() {
    elevator.setBeltSpeed(ELEVATOR_SPEED);
  }

  @Override public void end(boolean interrupted) {
    elevator.stopBelt();
  }
}