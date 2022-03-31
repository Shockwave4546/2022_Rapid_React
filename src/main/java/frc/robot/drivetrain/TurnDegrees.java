package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnDegrees extends CommandBase {
  private final Drivetrain drive;
  private final double speed;
  private final double degrees;
  private final boolean clockwise;

  public TurnDegrees(Drivetrain drive, double speed, double degrees, boolean clockwise) {
    this.drive = drive;
    this.speed = speed;
    this.degrees = degrees;
    this.clockwise = clockwise;
    addRequirements(drive);
  }

  @Override public void initialize() {
    drive.stop();
    drive.gyro.reset();
  }

  @Override public void execute() {
    drive.arcadeDrive(0.0, clockwise ? speed : speed * -1);
  } 


  @Override public void end(boolean interrupted) {
    drive.stop();
  }

  @Override public boolean isFinished() {
    return Math.abs(drive.gyro.getAngle()) >= degrees;
  }
}