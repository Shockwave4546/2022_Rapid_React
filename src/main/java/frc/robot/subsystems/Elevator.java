package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  private final MotorController motor = null;
  
  public void setSpeed(double speed) {
    motor.set(speed);
  }

  public void stop() {
    motor.set(0);
  }
}