package frc.robot;

import edu.wpi.first.math.util.Units;

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

  public static final class Drivetrain {
    public static final int COUNTS_PER_REVOLUTION = 8192;
    public static final int WHEEL_DIAMETER_INCH = 6;
    
    /**
     * Warning: Encoder#getDistance() is off by 1/4 because WPILib refers to a pulse by a full encoder cycle (four edges).
     * Therefore, we're required to compenstate by multipying the regular distance per pulse by 4.
     * Source: https://docs.wpilib.org/en/stable/docs/software/pathplanning/trajectory-tutorial/creating-drive-subsystem.html#:~:text=The%20distance%20per%20pulse%20is,should%20be%20measured%20in%20meters!
     */
    public static final double DISTANCE_PER_PULSE = 4 * ((Math.PI * Units.inchesToMeters(Constants.Drivetrain.WHEEL_DIAMETER_INCH)) / Constants.Drivetrain.COUNTS_PER_REVOLUTION);

    // TODO: Double check this track width
    // The horizontal distance between 2 wheels on the drivebase.
    public static final double TRACK_WIDTH = Units.inchesToMeters(24.0729167);

    // TODO: SysID these values.
    public static final double KS_VOLTS = 0.7191;
    public static final double KV_VOLT_SECONDS_PER_METER = 12.199;
    public static final double KA_VOLT_SECONDS_SQUARED_PER_METER = 7.3424;
    public static final double P_DRIVE_VELOCITY = 0.39106;

    // Source: https://docs.wpilib.org/en/stable/docs/software/pathplanning/trajectory-tutorial/entering-constants.html#:~:text=public%20static%20final%20double%20kRamseteB,double%20kRamseteZeta%20%3D%200.7%3B
    public static final double RAMSETE_B = 2;
    public static final double RAMSETE_ZETA = 0.7;

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