package frc.robot.motor;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class SimpleMotorSubsystem extends SubsystemBase {
  private final MotorConfig[] configs;

  public SimpleMotorSubsystem(ShuffleboardTab tab, MotorConfig... configs) {
    this.configs = configs;

    for (final var config : configs) {
      if (tab == null || config.name == null) return;
      final var speedWidget = tab.addPersistent(config.name, config.defaultSpeed);
      final var coords = config.coords;
      if (coords != null) speedWidget.withPosition(coords.x, coords.y);
      config.speedEntry = speedWidget.getEntry();
    }
  }

  public SimpleMotorSubsystem(MotorConfig... configs) {
    this(null, configs);
  }

  public void runMotors(boolean inverted) {
    for (final var config : configs) {
      final var speed = config.speedEntry.getDouble(0.0);
      config.controller.set(inverted ? -1 * speed : speed);
    }
  }

  public void stopMotors() {
    for (final var config : configs) {
      config.controller.stopMotor();
    }
  }
}