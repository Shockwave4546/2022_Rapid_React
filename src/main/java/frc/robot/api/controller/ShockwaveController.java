package frc.robot.api.controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ShockwaveController extends XboxController {
  public ShockwaveController(int port) {
    super(port);
  }

  public final LeftTriggerButton leftTrigger = new LeftTriggerButton(this);
  public final RightTriggerButton rightTrigger = new RightTriggerButton(this);
  public final JoystickButton leftBumper = new JoystickButton(this, Button.kLeftBumper.value);
  public final JoystickButton rightBumper = new JoystickButton(this, Button.kRightBumper.value);
  public final JoystickButton leftStick = new JoystickButton(this, Button.kLeftStick.value);
  public final JoystickButton rightStick = new JoystickButton(this, Button.kRightStick.value);
  public final JoystickButton aButton = new JoystickButton(this, Button.kA.value);
  public final JoystickButton bButton = new JoystickButton(this, Button.kB.value);
  public final JoystickButton xButton = new JoystickButton(this, Button.kX.value);
  public final JoystickButton yButton = new JoystickButton(this, Button.kY.value);
  public final JoystickButton backButton = new JoystickButton(this, Button.kBack.value);
  public final JoystickButton startButton = new JoystickButton(this, Button.kStart.value);
}