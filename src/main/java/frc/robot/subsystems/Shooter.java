package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.Constants.Tabs;
import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class Shooter extends SimpleMotorSubsystem {
  public Shooter() {
    super(
      Tabs.SPEEDS,
      new MotorConfig(
        new WPI_VictorSPX(Constants.Shooter.MOTOR_ID),
        "Shooter Speed",
        DefaultSpeeds.SHOOTER
      )
    );
  }
}