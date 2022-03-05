package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public final class Constants {
  // Default speeds
  public static final double DEFAULT_INTAKE_SPEED = 0.75;
  public static final double DEFAULT_SHOOTER_SPEED = 0.75;
  public static final double DEFAULT_ELEVATOR_BELT_SPEED = 0.6;
  public static final double DEFAULT_ELEVATOR_TRAP_SPEED = 0.75;

  // Shuffleboard
  public static final ShuffleboardTab MAIN_TAB = Shuffleboard.getTab("Main");

  // Drivetrain
  public static final int COUNTS_PER_REVOLUTION = 8192;
  public static final int WHEEL_DIAMETER_INCH = 6;
  
  public static final int DRIVETRAIN_LEFT_ENCODER_A = 0;
  public static final int DRIVETRAIN_LEFT_ENCODER_B = 1;
  public static final int DRIVETRAIN_RIGHT_ENCODER_A = 2;
  public static final int DRIVETRAIN_RIGHT_ENCODER_B = 3;

  public static final int DRIVETRAIN_FRONT_LEFT_MOTOR_ID = 1;
  public static final int DRIVETRAIN_FRONT_RIGHT_MOTOR_ID = 2;
  public static final int DRIVETRAIN_BACK_LEFT_MOTOR_ID = 3;
  public static final int DRIVETRAIN_BACK_RIGHT_MOTOR_ID = 4;

  // Intake
  public static final int INTAKE_ROLLER_MOTOR_ID = 5;

  // Intake Pivot
  public static final int INTAKE_PIVOT_MOTOR_ID = 6;
  public static final int TOP_LIMIT_SWITCH = 4;
  public static final int BOTTOM_LIMIT_SWITCH = 5;

  // Elevator
  public static final int ELEVATOR_BELT_MOTOR_ID = 7;
  public static final int ELEVATOR_TRAP_MOTOR_ID = 8;

  // Shooter
  public static final int SHOOTER_KICKOUT_ROLLER_ID = 9;

  // Controller Ports
  public static final int DRIVE_CONTROLLER_PORT = 0;
  public static final int OPERATOR_CONTROLLER_PORT = 1;
}