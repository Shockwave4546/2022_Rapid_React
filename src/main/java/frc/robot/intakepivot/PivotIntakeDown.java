package frc.robot.intakepivot;

import frc.robot.motor.SimpleMotorCommand;

public class PivotIntakeDown extends SimpleMotorCommand<IntakePivot> {
  public PivotIntakeDown(IntakePivot intakePivot) {
    super(intakePivot, true);
  }

  @Override public void initCommand() {
    subsystem.resetEncoder();
  }

  // 1 spin = 20 "positions"
  @Override public boolean isFinished() {
    return Math.abs(subsystem.encoder.getPosition()) >= 5;
  }
}