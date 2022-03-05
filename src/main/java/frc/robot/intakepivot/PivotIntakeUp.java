package frc.robot.intakepivot;

import frc.robot.motor.SimpleMotorCommand;

public class PivotIntakeUp extends SimpleMotorCommand {
  public PivotIntakeUp(IntakePivot intakePivot) {
    super(intakePivot, true);
  }

  // TODO: Ensure that the off condition on this is false, otherwise just negate the boolean
  @Override public boolean isFinished() {
    return ((IntakePivot) subsystem).getTopLimitSwitch();
  }
}
