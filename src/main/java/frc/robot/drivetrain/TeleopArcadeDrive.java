package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopArcadeDrive extends CommandBase {
  private final XboxController controller;
  private final Drivetrain drive;

  public TeleopArcadeDrive(XboxController controller, Drivetrain drive) {
    this.controller = controller;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
  }

  @Override public void execute() {
    final var rawLeft = controller.getLeftTriggerAxis();
    final var rawRight = controller.getRightTriggerAxis() * -1;
    final var rotation = controller.getLeftX(); 
    drive.aracadeDrive(rawLeft + rawRight , rotation * -1);
  }

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
}