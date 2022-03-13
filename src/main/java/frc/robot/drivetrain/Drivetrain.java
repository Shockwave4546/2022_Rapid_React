package frc.robot.drivetrain;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /* 
  frontLeft     frontRight
  backLeft      backRight
  */
  private final Encoder leftEncoder = new Encoder(DRIVETRAIN_LEFT_ENCODER_A, DRIVETRAIN_LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(DRIVETRAIN_RIGHT_ENCODER_A, DRIVETRAIN_RIGHT_ENCODER_B);
  private final MotorController frontLeftMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_LEFT_MOTOR_ID);
  private final MotorController frontRightMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_RIGHT_MOTOR_ID);
  private final MotorController backLeftMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_LEFT_MOTOR_ID);
  private final MotorController backRightMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_RIGHT_MOTOR_ID);
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public Drivetrain(XboxController driveController) {
    rightMotorGroup.setInverted(true);
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    // TODO: God knows if this works how I want it to
    setDefaultCommand(new ControllerDrive(driveController, this));
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
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