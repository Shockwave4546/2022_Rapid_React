package frc.robot.api.controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ShockwaveController extends XboxController {
  public ShockwaveController(int port) {
    super(port);
  }

  public void whenPressed(Button button, Command command) {
    new JoystickButton(this, button.value).whenPressed(command);
  }
  
  public void whileHeld(Button button, Command command) {
    new JoystickButton(this, button.value).whileHeld(command);
  }

  public void toggleWhenPressed(Button button, Command command) {
    new JoystickButton(this, button.value).toggleWhenPressed(command);
  }
}