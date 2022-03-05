package frc.robot.intakepivot;

import static frc.robot.Constants.BOTTOM_LIMIT_SWITCH;
import static frc.robot.Constants.INTAKE_PIVOT_MOTOR_ID;
import static frc.robot.Constants.TOP_LIMIT_SWITCH;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.motor.MotorConfig;
import frc.robot.motor.SimpleMotorSubsystem;

public class IntakePivot extends SimpleMotorSubsystem {
  public IntakePivot() {
    super(
      new MotorConfig(new WPI_VictorSPX(INTAKE_PIVOT_MOTOR_ID))
    );
  }

  private final DigitalInput topLimitSwitch = new DigitalInput(TOP_LIMIT_SWITCH);
  private final DigitalInput bottomLimitSwitch = new DigitalInput(BOTTOM_LIMIT_SWITCH);

  public boolean getTopLimitSwitch() {
    return topLimitSwitch.get();
  }

  public boolean getBottomLimitSwitch() {
    return bottomLimitSwitch.get();
  }
}