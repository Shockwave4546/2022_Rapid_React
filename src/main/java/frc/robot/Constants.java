package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public final class Constants {
  public static final class ControllerIO {
    public static final int DRIVE_PORT = 0;
    public static final int OPERATOR_PORT = 1;
  }

  public static final class DefaultSpeeds {
    public static final double INTAKE = 0.85;
    public static final double SHOOTER = -0.75;
    public static final double ELEVATOR_BELT = 0.6;
    public static final double ELEVATOR_TRAP = 0.75;
    public static final double INTAKE_PIVOT = 0.6;
    public static final double DRIVE_LEFT_MULTIPLIER = 0.8;
    public static final double DRIVE_RIGHT_MULTIPLIER = 0.8;
  }

  public static final class Tabs {
    public static final ShuffleboardTab SPEEDS = Shuffleboard.getTab("Speeds");
    public static final ShuffleboardTab MATCH = Shuffleboard.getTab("Match");
    public static final ShuffleboardTab TEST = Shuffleboard.getTab("Test");
  }

  public static final class Drivetrain {
    public static final int COUNTS_PER_REVOLUTION = 8192;
    public static final int WHEEL_DIAMETER_INCH = 6;
    
    public static final int LEFT_ENCODER_A = 0;
    public static final int LEFT_ENCODER_B = 1;
    public static final int RIGHT_ENCODER_A = 2;
    public static final int RIGHT_ENCODER_B = 3;
  
    public static final int FRONT_LEFT_MOTOR_ID = 7;
    public static final int FRONT_RIGHT_MOTOR_ID = 8;
    public static final int BACK_LEFT_MOTOR_ID = 9;
    public static final int BACK_RIGHT_MOTOR_ID = 10;
  }

  public static final class Intake {
    public static final int MOTOR_ID = 5;
  }

  public static final class IntakePivot {
    public static final int MOTOR_ID = 6;
  }

  public static final class Elevator {
    public static final int BELT_MOTOR_ID = 1;
    public static final int TRAP_MOTOR_ID = 2;
  }

  public static final class Shooter {
    public static final int MOTOR_ID = 3;
  }
}