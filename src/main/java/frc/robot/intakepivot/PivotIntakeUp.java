package frc.robot.intakepivot;

import frc.robot.api.motor.SimpleMotorCommand;

public class PivotIntakeUp extends SimpleMotorCommand<IntakePivot> {
  public PivotIntakeUp(IntakePivot intakePivot) {
    super(intakePivot, false);
  }

  @Override public void initCommand() {
    subsystem.resetEncoder();
  }

  @Override public boolean isFinished() {
    return Math.abs(subsystem.encoder.getPosition()) >= 183;
  }
}