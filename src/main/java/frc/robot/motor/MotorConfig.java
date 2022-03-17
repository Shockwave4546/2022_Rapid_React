package frc.robot.motor;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class MotorConfig {
  public final MotorController controller;
  public final String name;
  public final double defaultSpeed;
  public final Coords coords;
  public NetworkTableEntry speedEntry;
  
  public MotorConfig(MotorController controller, String name, double defaultSpeed, Coords coords) {
    this.name = name;
    this.controller = controller;
    this.defaultSpeed = defaultSpeed;
    this.coords = coords;
  }

  // In case, you don't feel like specifying the coordinates for the widget
  public MotorConfig(MotorController controller, String name, double defaultSpeed) {
    this(controller, name, defaultSpeed, null);
  }

  // In case, you don't need a adjustable speed--STILL NEEDS A DEFAULT
  public MotorConfig(MotorController controller, double defaultSpeed) {
    this(controller, null, defaultSpeed, null);
  }
}