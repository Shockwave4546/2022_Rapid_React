package frc.robot.subsystems;

import static frc.robot.Constants.SCORE_ROLLER_MOTOR_ID;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Scorer extends SubsystemBase {
  private final MotorController roller = new WPI_VictorSPX(SCORE_ROLLER_MOTOR_ID);

  public void setRollerSpeed(double speed) {
    roller.set(speed);
  }

  public void stopRoller() {
    roller.stopMotor();
  }
}