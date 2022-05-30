package frc.robot.api.controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class RightTriggerButton extends Button {
  public RightTriggerButton(XboxController controller) {
    super(() -> controller.getRightTriggerAxis() > 0.2);
  }
}
