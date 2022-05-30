package frc.robot.subsystems.intakepivot;

import frc.robot.api.motor.SimpleMotorCommand;

public class PivotIntakeDown extends SimpleMotorCommand<IntakePivot> {
  public PivotIntakeDown(IntakePivot intakePivot) {
    super(intakePivot, true);
  }

  @Override public void initialize() {
    super.initialize();
    subsystem.resetEncoder();
  }

  // 1 spin = 20 "positions"
  @Override public boolean isFinished() {
    return Math.abs(subsystem.encoder.getPosition()) >= 187;
  }
}