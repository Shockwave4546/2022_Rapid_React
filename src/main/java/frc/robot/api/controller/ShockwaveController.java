package frc.robot.api.controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.api.Lazy;

public class ShockwaveController extends XboxController {
  public ShockwaveController(int port) {
    super(port);
  }

  public final Lazy<LeftTriggerButton> leftTrigger = Lazy.of(() -> new LeftTriggerButton(this));
  public final Lazy<RightTriggerButton> rightTrigger = Lazy.of(() -> new RightTriggerButton(this));
  public final Lazy<JoystickButton> leftBumper = Lazy.of(() -> new JoystickButton(this, Button.kLeftBumper.value));
  public final Lazy<JoystickButton> rightBumper = Lazy.of(() -> new JoystickButton(this, Button.kRightBumper.value));
  public final Lazy<JoystickButton> leftStick = Lazy.of(() -> new JoystickButton(this, Button.kLeftStick.value));
  public final Lazy<JoystickButton> rightStick = Lazy.of(() -> new JoystickButton(this, Button.kRightStick.value));
  public final Lazy<JoystickButton> aButton = Lazy.of(() -> new JoystickButton(this, Button.kA.value));
  public final Lazy<JoystickButton> bButton = Lazy.of(() -> new JoystickButton(this, Button.kB.value));
  public final Lazy<JoystickButton> xButton = Lazy.of(() -> new JoystickButton(this, Button.kX.value));
  public final Lazy<JoystickButton> yButton = Lazy.of(() -> new JoystickButton(this, Button.kY.value));
  public final Lazy<JoystickButton> backButton = Lazy.of(() -> new JoystickButton(this, Button.kBack.value));
  public final Lazy<JoystickButton> startButton = Lazy.of(() -> new JoystickButton(this, Button.kStart.value));
}