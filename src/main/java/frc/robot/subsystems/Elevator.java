package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.Tabs;
import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class Elevator extends SimpleMotorSubsystem {
  public Elevator() {
    super(
      Tabs.SPEEDS, 
      new MotorConfig(
        new WPI_VictorSPX(Constants.Elevator.BELT_MOTOR_ID),
        "Elevator Belt Speed",
        DefaultSpeeds.ELEVATOR_BELT
      ),
      new MotorConfig(
        new WPI_VictorSPX(Constants.Elevator.TRAP_MOTOR_ID),
        "Elevator Trap Speed",
        DefaultSpeeds.ELEVATOR_TRAP
      )
    );
  }
}