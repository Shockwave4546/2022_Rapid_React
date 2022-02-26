package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final MotorController roller = new CANSparkMax(INTAKE_ROLLER_MOTOR_ID, MotorType.kBrushless);
  private final MotorController pivot = new WPI_VictorSPX(INTAKE_PIVOT_MOTOR_ID);

  public void setRollerSpeed(double speed) {
    roller.set(speed);
  }

  public void stopRoller() {
    roller.stopMotor();
  }
};