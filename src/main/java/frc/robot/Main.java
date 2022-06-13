package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Encapsulates the main function.
 */
public final class Main {
  /**
   * Entry-point function into the program; first function to get called.
   * This call begins our Robot's exeuction, initilizating the Robot's main thread, and subsequent periodic subsystem calls.
   *
   * @param args the arguments passed into the program (in our case, nothing, "[]").
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}