package frc.robot.intakepivot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ResetEncoderCount extends CommandBase {
  private final IntakePivot intakePivot;

  public ResetEncoderCount(IntakePivot intakePivot) {
    this.intakePivot = intakePivot;
  }
  
  @Override public void initialize() {
    intakePivot.resetEncoder();
  }

  @Override public boolean isFinished() {
    return true;
  }
}