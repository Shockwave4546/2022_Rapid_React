package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final MotorController motor = new CANSparkMax(Constants.INTAKE_ROLLER_MOTOR_ID, MotorType.kBrushless);

  public void setSpeed(double speed) {
    motor.set(speed);
  }

  public void stop() {
    motor.set(0);
  }
};