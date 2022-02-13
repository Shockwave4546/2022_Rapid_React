package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  private final MotorController motor = null;
  
  public void setSpeed(double speed) {
    if (speed < -1.0 || speed > 1.0) throw new IllegalArgumentException("Speed can't be greater than 1.0 or less than -1.0.");
    motor.set(speed);
  }

  public void stop() {
    motor.set(0);
  }
}