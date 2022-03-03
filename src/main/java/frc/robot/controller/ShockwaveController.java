package frc.robot.controller;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ShockwaveController extends GenericHID {
  public enum Button {
    LEFT_BUMPER(5),
    RIGHT_BUMPER(6),
    LEFT_STICK(9),
    RIGHT_STICK(10),
    A(1),
    B(2),
    X(3),
    Y(4),
    BACK(7),
    START(8);

    public final int value;

    Button(int value) {
      this.value = value;
    }
  }

  public enum Axis {
    LEFT_X(0),
    RIGHT_X(4),
    LEFT_Y(1),
    RIGHT_Y(5),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3);

    public final int value;

    Axis(int value) {
      this.value = value;
    }
  }

  public ShockwaveController(int port) {
    super(port);
  }
 
  public void whenPressed(Button button, Command command) {
    new JoystickButton(this, button.value).whenPressed(command);
  }
}