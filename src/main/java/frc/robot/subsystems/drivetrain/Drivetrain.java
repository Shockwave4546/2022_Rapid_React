package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.Constants.DefaultSpeeds;
import frc.robot.api.shuffleboard.AdjustableSpeed;

/* 
  frontLeft     frontRight
  backLeft      backRight
*/
public class Drivetrain extends SubsystemBase {
  private final AdjustableSpeed rightSpeedMultiplier = new AdjustableSpeed("Right Speed Multiplier", DefaultSpeeds.DRIVE_LEFT_MULTIPLIER);
  private final AdjustableSpeed leftSpeedMultiplier = new AdjustableSpeed("Left Speed Multiplier", DefaultSpeeds.DRIVE_RIGHT_MULTIPLIER);

  protected final AHRS gyro = new AHRS();
  private final Encoder leftEncoder = new Encoder(Constants.Drivetrain.LEFT_ENCODER_A, Constants.Drivetrain.LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(Constants.Drivetrain.RIGHT_ENCODER_A, Constants.Drivetrain.RIGHT_ENCODER_B);
  private final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(Constants.Drivetrain.FRONT_LEFT_MOTOR_ID);
  private final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(Constants.Drivetrain.FRONT_RIGHT_MOTOR_ID);
  private final WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(Constants.Drivetrain.BACK_LEFT_MOTOR_ID);
  private final WPI_VictorSPX backRightMotor = new WPI_VictorSPX(Constants.Drivetrain.BACK_RIGHT_MOTOR_ID);
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.Drivetrain.TRACK_WIDTH);
  private final DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), 0, 0);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public Drivetrain() {
    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    backLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    backRightMotor.setNeutralMode(NeutralMode.Brake);
    leftMotorGroup.setInverted(true); 
    leftEncoder.setDistancePerPulse(Constants.Drivetrain.DISTANCE_PER_PULSE);
    rightEncoder.setDistancePerPulse(Constants.Drivetrain.DISTANCE_PER_PULSE);

    resetEncoders();
    resetGyro();
    resetOdometry(new Pose2d());

    SmartDashboard.putData("Left Encoder", leftEncoder);
    SmartDashboard.putData("Right Encoder", rightEncoder);
  }

  @Override public void periodic() {
    odometry.update(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  public void arcadeDrive(double speed, double rotation) {
    diffDrive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed * leftSpeedMultiplier.get(), rightSpeed * rightSpeedMultiplier.get());
  }

  public void tankDriveVolts(double leftVolts, double rightVolts) {
    leftMotorGroup.setVoltage(leftVolts);
    rightMotorGroup.setVoltage(rightVolts);
    diffDrive.feed();
  }
  
  public void initTeleop(CommandXboxController controller) {
    setDefaultCommand(new TeleopTankDrive(this, controller));
  }

  public void disableTeleop() {
    setDefaultCommand(null);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void resetGyro() {
    gyro.reset();
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

  public Pose2d getPose() {
    return odometry.getPoseMeters();
  }

  public DifferentialDriveKinematics getKinematics() {
    return kinematics;
  }

  public void resetOdometry(Pose2d pose) {
    resetEncoders();
    odometry.resetPosition(gyro.getRotation2d(), 0, 0, pose);
  }

  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(leftEncoder.getRate(), rightEncoder.getRate());
  }
}