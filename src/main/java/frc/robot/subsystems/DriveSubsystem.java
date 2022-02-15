package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  // A 0 B 1
  public final Encoder leftEncoder = new Encoder(0, 1);
  // A 2 B 3
  public final Encoder rightEncoder = new Encoder(2, 3);
  /* 
  frontLeft     frontRight
  backLeft      backRight
  */
  
  // private final Encoder leftEncoder = new Encoder(DRIVE_LEFT_ENCODER_A, DRIVE_LEFT_ENCODER_B);
  // private final Encoder rightEncoder = new Encoder(DRIVE_RIGHT_ENCODER_A, DRIVE_RIGHT_ENCODER_B);
  private final MotorController leftMotor = new WPI_TalonSRX(0);
  private final MotorController rightMotor = new WPI_VictorSPX(1);
  // private final MotorController frontLeftMotor = null;
  // private final MotorController backLeftMotor = null;
  // private final MotorController frontRightMotor = null;
  // private final MotorController backRightMotor = null;
  // private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  // private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

  public DriveSubsystem() {
    rightMotor.setInverted(true);
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    // if (leftSpeed < -1.0 || leftSpeed > 1.0) throw new IllegalArgumentException("Left speed can't be greater than 1.0 or less than -1.0.");
    // if (rightSpeed < -1.0 || rightSpeed > 1.0) throw new IllegalArgumentException("Right speed can't be greater than 1.0 or less than -1.0.");
    diffDrive.tankDrive(leftSpeed , rightSpeed * 0.8);
  }

  public void arcadeDrive(double speed, double rotation) {
    if (speed < -1.0 || speed > 1.0) throw new IllegalArgumentException("Speed can't be greater than 1.0 or less than -1.0.");
    if (rotation < -1.0 || rotation > 1.0) throw new IllegalArgumentException("Rotation can't be greater than 1.0 or less than -1.0.");
    diffDrive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    leftMotor.set(0);
    rightMotor.set(0);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistance() {
    System.out.println("Left " + leftEncoder.getDistance() + " " + leftEncoder.getRaw());
    return leftEncoder.getDistance();
  }

  public double getRightDistance() {
    System.out.println("Right " + rightEncoder.getDistance() + " " + rightEncoder.getRaw());
    return rightEncoder.getDistance();
  }

  public double getAverageDistance() {
    return (getLeftDistance() + getRightDistance()) / 2;
  }
}