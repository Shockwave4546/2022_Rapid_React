package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.api.CheesyDriveHelper;

public class CheesyDriveCommand extends CommandBase {
  private static final double DEADBAND = 0.02;
  private static final double QUICK_TURN_THRESHOLD = 0.2;  
  private final CheesyDriveHelper helper = new CheesyDriveHelper();
  private final Drivetrain drivetrain;
  private final CommandXboxController controller;

  public CheesyDriveCommand(Drivetrain drivetrain, CommandXboxController controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    addRequirements(drivetrain);
  }

  @Override public void initialize() {
    drivetrain.stop(); 
  }

  @Override public void execute() {
    final var rotateValue = CheesyDriveHelper.handleDeadband(controller.getRightX() * 0.5, DEADBAND);
    final var moveValue = CheesyDriveHelper.handleDeadband(controller.getLeftY() * 1.00, DEADBAND);
    final var quickTurn = (moveValue < QUICK_TURN_THRESHOLD && moveValue > -QUICK_TURN_THRESHOLD);
    final var speeds = helper.cheesyDrive(moveValue, rotateValue, quickTurn);
    drivetrain.tankDrive(speeds.getFirst(), speeds.getSecond());
  }
}