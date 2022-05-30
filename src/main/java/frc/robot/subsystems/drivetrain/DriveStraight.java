package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveStraight extends CommandBase {
  private final Drivetrain drive;
  private final double speed;
  
  public DriveStraight(Drivetrain drive, double speed) {
    this.drive = drive;
    this.speed = speed;
  }

  @Override public void initialize() {
    drive.stop();
  }

  @Override public void execute() {
    drive.tankDrive(speed, speed);
  }

  @Override public void end(boolean interrupted) {
    drive.stop();
  }
}