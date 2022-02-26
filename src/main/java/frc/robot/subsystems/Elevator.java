package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  private final MotorController belt = new WPI_VictorSPX(ELEVATOR_BELT_MOTOR_ID);
  private final MotorController kickout = new WPI_VictorSPX(ELEVATOR_KICKOUT_MOTOR_ID);
  
  public void setBeltSpeed(double speed) {
    belt.set(speed);
  }

  public void stopBelt() {
    belt.stopMotor();
  }

  public void setKickoutSpeed(double speed) {
    kickout.set(speed);
  }

  public void stopKickout() {
    kickout.stopMotor();
  }
}