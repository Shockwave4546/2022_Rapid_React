package frc.robot.api.motor;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.api.shuffleboard.Pos2D;

public class MotorConfig {
  public final MotorController controller;
  public final String name;
  public final double defaultSpeed;
  public final Pos2D position;
  public GenericEntry speedEntry;
  
  public MotorConfig(MotorController controller, String name, double defaultSpeed, Pos2D position) {
    this.name = name;
    this.controller = controller;
    this.defaultSpeed = defaultSpeed;
    this.position = position;
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