package frc.robot.api.motor;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.api.shuffleboard.AdjustableSpeed;

public abstract class SimpleMotorSubsystem extends SubsystemBase {
  protected final MotorConfig[] configs;

  public SimpleMotorSubsystem(ShuffleboardTab tab, MotorConfig... configs) {
    this.configs = configs;
    
    for (var config : configs) {
      if (tab == null || config.name == null) return;
      config.speedEntry = (config.position == null ? new AdjustableSpeed(config.name, config.defaultSpeed) : new AdjustableSpeed(config.name, config.defaultSpeed, config.position)).getRaw();
    }
  }

  public SimpleMotorSubsystem(MotorConfig... configs) {
    this(null, configs);
  }
  
  public void runMotors(boolean inverted) {
    for (final var config : configs) {
      final var speed = config.speedEntry == null ? config.defaultSpeed : config.speedEntry.getDouble(0.0);
      config.controller.set(inverted ? -1 * speed : speed);
    } 
  }

  public void stopMotors() {
    for (final var config : configs) {
      config.controller.stopMotor();
    }
  }
}