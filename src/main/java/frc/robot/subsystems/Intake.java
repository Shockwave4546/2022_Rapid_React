package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.motor.MotorConfig;
import frc.robot.motor.SimpleMotorSubsystem;

public class Intake extends SimpleMotorSubsystem {
  public Intake() {
    super(
      SPEEDS_TAB,
      new MotorConfig(
        new CANSparkMax(INTAKE_ROLLER_MOTOR_ID, MotorType.kBrushless), 
        "Intake Speed",
        DEFAULT_INTAKE_SPEED
      )
    );
  }
};