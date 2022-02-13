package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class RotateCommand extends CommandBase {
  private final double degrees;
  private final double speed;
  private final DriveSubsystem drive;

  public RotateCommand(double degrees, double speed, DriveSubsystem drive) {
    this.degrees = degrees;
    this.speed = speed;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
    // drive.resetEncoders();
  }

  @Override
  public void execute() {
    drive.arcadeDrive(0, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.stop();
  }

  @Override public boolean isFinished() {
    // https://github.com/Bqckword/TestProject3/blob/main/src/main/java/frc/robot/commands/TurnDegrees.java
    return false;
    // wheel diameter = 6 in
    // 
    // final var inchPerDegree = Math.PI * 
  }

  // private double getAverageTurningDistance() {
  //   final var leftDistance = Math.abs(drive.getLeftDistance());
  //   final var rightDistance = Math.abs(drive.getRightDistance());
  //   return (leftDistance + rightDistance) / 2;
  // }
}