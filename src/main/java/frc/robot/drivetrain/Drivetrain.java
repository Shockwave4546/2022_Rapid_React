package frc.robot.drivetrain;

import static frc.robot.Constants.*;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /* 
  frontLeft     frontRight
  backLeft      backRight
  */

  private final NetworkTableEntry rightSpeedMultipler = MAIN_TAB.add("Right Speed Multipler ", 0.75)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("min", -1.0, "max", 1.0))
    .getEntry();
  private final NetworkTableEntry leftSpeedMultipler = MAIN_TAB.add("Left Speed Multipler ", 0.75)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("min", -1.0, "max", 1.0))
    .getEntry();
  private final Encoder leftEncoder = new Encoder(DRIVETRAIN_LEFT_ENCODER_A, DRIVETRAIN_LEFT_ENCODER_B);
  private final Encoder rightEncoder = new Encoder(DRIVETRAIN_RIGHT_ENCODER_A, DRIVETRAIN_RIGHT_ENCODER_B);
  private final MotorController frontLeftMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_LEFT_MOTOR_ID);
  private final MotorController frontRightMotor = new WPI_VictorSPX(DRIVETRAIN_FRONT_RIGHT_MOTOR_ID);
  private final MotorController backLeftMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_LEFT_MOTOR_ID);
  private final MotorController backRightMotor = new WPI_VictorSPX(DRIVETRAIN_BACK_RIGHT_MOTOR_ID);
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  private final XboxController controller;

  public Drivetrain(XboxController controller) {
    this.controller = controller;
    leftMotorGroup.setInverted(true); 
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed * leftSpeedMultipler.getDouble(0.75), rightSpeed * rightSpeedMultipler.getDouble(0.75));
  }

  public void setDefaultCommand() {
    setDefaultCommand(new ControllerDrive(controller, this));
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