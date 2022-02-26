package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntakeCommand extends CommandBase {
  private static final double INTAKE_SPEED = 0.75;
  private final Intake intake;

  public RunIntakeCommand(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  @Override public void initialize() {
    intake.stopRoller();
  }

  @Override public void execute() {
    intake.setRollerSpeed(INTAKE_SPEED);
  }

  @Override public void end(boolean interrupted) {
    intake.stopRoller();
  }
}