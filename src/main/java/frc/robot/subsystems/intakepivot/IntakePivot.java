package frc.robot.subsystems.intakepivot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.Constants.Tabs;
import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class IntakePivot extends SimpleMotorSubsystem {
  protected final RelativeEncoder encoder;

  public IntakePivot() {
    super(
      Tabs.SPEEDS,
      new MotorConfig(
        new CANSparkMax(Constants.IntakePivot.MOTOR_ID, MotorType.kBrushless), 
        "Intake Pivot Speed", 
        DefaultSpeeds.INTAKE_PIVOT
      )
    );

    this.encoder = ((CANSparkMax) configs[0].controller).getEncoder();;
  }

  public void resetEncoder() {
    encoder.setPosition(0.0);
  }
}