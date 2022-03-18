package frc.robot.intakepivot;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.motor.MotorConfig;
import frc.robot.motor.SimpleMotorSubsystem;

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