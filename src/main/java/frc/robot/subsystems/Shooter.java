package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.motor.MotorConfig;
import frc.robot.motor.SimpleMotorSubsystem;

public class Shooter extends SimpleMotorSubsystem {
  public Shooter() {
    super(
      MAIN_TAB,
      new MotorConfig(
        new WPI_VictorSPX(SHOOTER_KICKOUT_ROLLER_ID),
        "Shooter Speed",
        DEFAULT_SHOOTER_SPEED
      )
    );
  }
}