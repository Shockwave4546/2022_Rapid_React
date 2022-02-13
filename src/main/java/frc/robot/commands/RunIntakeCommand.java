package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeCommand extends CommandBase {
  private static final double INTAKE_SPEED = 0.75;
  private final IntakeSubsystem intake;

  public RunIntakeCommand(IntakeSubsystem intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  @Override public void initialize() {
    intake.stop();
  }

  @Override public void execute() {
    intake.setSpeed(INTAKE_SPEED);
  }

  @Override public void end(boolean interrupted) {
    intake.stop();
  }
}