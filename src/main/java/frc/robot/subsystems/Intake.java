package frc.robot.subsystems;

import static frc.robot.Constants.DEFAULT_INTAKE_SPEED;
import static frc.robot.Constants.INTAKE_ROLLER_MOTOR_ID;
import static frc.robot.Constants.SPEEDS_TAB;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

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