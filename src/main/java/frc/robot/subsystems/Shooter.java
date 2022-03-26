package frc.robot.subsystems;

import static frc.robot.Constants.DEFAULT_SHOOTER_SPEED;
import static frc.robot.Constants.SHOOTER_KICKOUT_MOTOR_ID;
import static frc.robot.Constants.SPEEDS_TAB;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class Shooter extends SimpleMotorSubsystem {
  public Shooter() {
    super(
      SPEEDS_TAB,
      new MotorConfig(
        new WPI_VictorSPX(SHOOTER_KICKOUT_MOTOR_ID),
        "Shooter Speed",
        DEFAULT_SHOOTER_SPEED
      )
    );
  }
}