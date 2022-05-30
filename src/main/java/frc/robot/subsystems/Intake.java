package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.Constants.Tabs;
import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class Intake extends SimpleMotorSubsystem {
  public Intake() {
    super(
      Tabs.SPEEDS,
      new MotorConfig(
        new CANSparkMax(Constants.Intake.MOTOR_ID, MotorType.kBrushless), 
        "Intake Speed",
        DefaultSpeeds.INTAKE
      )
    );
  }
};