package frc.robot.drivetrain;

import static frc.robot.Constants.COUNTS_PER_REVOLUTION;
import static frc.robot.Constants.DEFAULT_DRIVE_LEFT_MULTIPLIER;
import static frc.robot.Constants.DEFAULT_DRIVE_RIGHT_MULTIPLIER;
import static frc.robot.Constants.DRIVETRAIN_BACK_LEFT_MOTOR_ID;
import static frc.robot.Constants.DRIVETRAIN_BACK_RIGHT_MOTOR_ID;
import static frc.robot.Constants.DRIVETRAIN_FRONT_LEFT_MOTOR_ID;
import static frc.robot.Constants.DRIVETRAIN_FRONT_RIGHT_MOTOR_ID;
import static frc.robot.Constants.DRIVETRAIN_LEFT_ENCODER_A;
import static frc.robot.Constants.DRIVETRAIN_LEFT_ENCODER_B;
import static frc.robot.Constants.DRIVETRAIN_RIGHT_ENCODER_A;
import static frc.robot.Constants.DRIVETRAIN_RIGHT_ENCODER_B;
import static frc.robot.Constants.TEST_TAB;
import static frc.robot.Constants.WHEEL_DIAMETER_INCH;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.api.shuffleboard.AdjustableSpeed;

/* 
  frontLeft     frontRight
  backLeft      backRight
*/
public class Drivetrain extends SubsystemBase {
  private final AdjustableSpeed rightSpeedMultiplier = new AdjustableSpeed("Right Speed Multiplier", TEST_TAB, DEFAULT_DRIVE_LEFT_MULTIPLIER);
  private final AdjustableSpeed leftSpeedMultiplier = new AdjustableSpeed("Left Speed Multiplier", TEST_TAB, DEFAULT_DRIVE_RIGHT_MULTIPLIER);

  protected final AHRS gyro = new AHRS();
  private final Encoder leftEncoder = new Encoder(DRIVETRAIN_LEFT_ENCODER_A, DRIVETRAIN_LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(DRIVETRAIN_RIGHT_ENCODER_A, DRIVETRAIN_RIGHT_ENCODER_B);
  private final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_LEFT_MOTOR_ID);
  private final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_RIGHT_MOTOR_ID);
  private final WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_LEFT_MOTOR_ID);
  private final WPI_VictorSPX backRightMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_RIGHT_MOTOR_ID);
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  private final XboxController controller;

  public Drivetrain(XboxController controller) {
    this.controller = controller;
    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    backLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    backRightMotor.setNeutralMode(NeutralMode.Brake);
    leftMotorGroup.setInverted(true); 
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed * leftSpeedMultiplier.get(), rightSpeed * rightSpeedMultiplier.get());
  }

  public void initTeleop() {
    setDefaultCommand(new TeleopTankDrive(this, controller));
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