package frc.robot.subsystems;

import static frc.robot.Constants.DEFAULT_ELEVATOR_BELT_SPEED;
import static frc.robot.Constants.DEFAULT_ELEVATOR_TRAP_SPEED;
import static frc.robot.Constants.ELEVATOR_BELT_MOTOR_ID;
import static frc.robot.Constants.ELEVATOR_TRAP_MOTOR_ID;
import static frc.robot.Constants.SPEEDS_TAB;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.api.motor.MotorConfig;
import frc.robot.api.motor.SimpleMotorSubsystem;

public class Elevator extends SimpleMotorSubsystem {
  public Elevator() {
    super(
      SPEEDS_TAB, 
      new MotorConfig(
        new WPI_VictorSPX(ELEVATOR_BELT_MOTOR_ID),
        "Elevator Belt Speed",
        DEFAULT_ELEVATOR_BELT_SPEED
      ),
      new MotorConfig(
        new WPI_VictorSPX(ELEVATOR_TRAP_MOTOR_ID),
        "Elevator Trap Speed",
        DEFAULT_ELEVATOR_TRAP_SPEED
      )
    );
  }
}