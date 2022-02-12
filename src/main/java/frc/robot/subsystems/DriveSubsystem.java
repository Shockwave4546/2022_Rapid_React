package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /* 
  frontLeft     frontRight
  backLeft      backRight
  */
  
  private final Encoder leftEncoder = new Encoder(DRIVE_LEFT_ENCODER_A, DRIVE_LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(DRIVE_RIGHT_ENCODER_A, DRIVE_RIGHT_ENCODER_B);
  private final MotorController frontLeftMotor = null;
  private final MotorController backLeftMotor = null;
  private final MotorController frontRightMotor = null;
  private final MotorController backRightMotor = null;
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public DriveSubsystem() {
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    if (leftSpeed < -1.0 || leftSpeed > 1.0) throw new IllegalArgumentException("Left speed can't be greater than 1.0 or less than -1.0.");
    if (rightSpeed < -1.0 || rightSpeed > 1.0) throw new IllegalArgumentException("Right speed can't be greater than 1.0 or less than -1.0.");
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public double getRightDistance() {
    return rightEncoder.getDistance();
  }

  public double getAverageDistance() {
    return (getLeftDistance() + getRightDistance()) / 2;
  }
}