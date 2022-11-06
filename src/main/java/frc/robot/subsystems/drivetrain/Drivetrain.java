package frc.robot.subsystems.drivetrain;

import static frc.robot.Constants.Drivetrain.BACK_LEFT_MOTOR_ID;
import static frc.robot.Constants.Drivetrain.BACK_RIGHT_MOTOR_ID;
import static frc.robot.Constants.Drivetrain.COUNTS_PER_REVOLUTION;
import static frc.robot.Constants.Drivetrain.FRONT_LEFT_MOTOR_ID;
import static frc.robot.Constants.Drivetrain.FRONT_RIGHT_MOTOR_ID;
import static frc.robot.Constants.Drivetrain.LEFT_ENCODER_A;
import static frc.robot.Constants.Drivetrain.LEFT_ENCODER_B;
import static frc.robot.Constants.Drivetrain.RIGHT_ENCODER_A;
import static frc.robot.Constants.Drivetrain.RIGHT_ENCODER_B;
import static frc.robot.Constants.Drivetrain.WHEEL_DIAMETER_INCH;
import static frc.robot.Tabs.DEBUG;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.api.shuffleboard.AdjustableSpeed;

/* 
  frontLeft     frontRight
  backLeft      backRight
*/
public class Drivetrain extends SubsystemBase {
  private final AdjustableSpeed rightSpeedMultiplier = new AdjustableSpeed("Right Speed Multiplier", DEBUG, DefaultSpeeds.DRIVE_LEFT_MULTIPLIER);
  private final AdjustableSpeed leftSpeedMultiplier = new AdjustableSpeed("Left Speed Multiplier", DEBUG, DefaultSpeeds.DRIVE_RIGHT_MULTIPLIER);

  protected final AHRS gyro = new AHRS();
  private final Encoder leftEncoder = new Encoder(LEFT_ENCODER_A, LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(RIGHT_ENCODER_A, RIGHT_ENCODER_B);
  private final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(FRONT_LEFT_MOTOR_ID);
  private final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(FRONT_RIGHT_MOTOR_ID);
  private final WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(BACK_LEFT_MOTOR_ID);
  private final WPI_VictorSPX backRightMotor = new WPI_VictorSPX(BACK_RIGHT_MOTOR_ID);
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

  public void arcadeDrive(double speed, double rotation) {
    diffDrive.arcadeDrive(speed, rotation);
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