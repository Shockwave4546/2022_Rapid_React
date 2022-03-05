package frc.robot.intakepivot;

import frc.robot.motor.SimpleMotorCommand;

public class PivotIntakeDown extends SimpleMotorCommand {
  public PivotIntakeDown(IntakePivot intakePivot) {
    super(intakePivot, true);
  }

  // TODO: Ensure that the off condition on this is false, otherwise just negate the boolean
  @Override public boolean isFinished() {
    return ((IntakePivot) subsystem).getBottomLimitSwitch();
  }
}