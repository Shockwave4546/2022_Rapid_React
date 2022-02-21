package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
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

  public Drivetrain() {
    rightMotorGroup.setInverted(true);
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed , rightSpeed * 0.8);
  }

  public void arcadeDrive(double speed, double rotation) {
    diffDrive.arcadeDrive(speed, rotation);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void stop() {
    diffDrive.stopMotor();
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