package frc.robot.intakepivot;

import static frc.robot.Constants.DEFAULT_INTAKE_PIVOT_SPEED;
import static frc.robot.Constants.INTAKE_PIVOT_MOTOR_ID;
import static frc.robot.Constants.SPEEDS_TAB;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class IntakePivot extends SimpleMotorSubsystem {
  protected final RelativeEncoder encoder;

  public IntakePivot() {
    super(
      SPEEDS_TAB,
      new MotorConfig(
        new CANSparkMax(INTAKE_PIVOT_MOTOR_ID, MotorType.kBrushless), 
        "Intake Pivot Speed", 
        DEFAULT_INTAKE_PIVOT_SPEED
      )
    );

    this.encoder = ((CANSparkMax) configs[0].controller).getEncoder();;
  }

  public void resetEncoder() {
    encoder.setPosition(0.0);
  }
}