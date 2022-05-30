package frc.robot.api.controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class LeftTriggerButton extends Button {
  public LeftTriggerButton(XboxController controller) {
    super(() -> controller.getLeftTriggerAxis() > 0.2);
  }
}