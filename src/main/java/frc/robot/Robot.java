package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private final RobotContainer robotContainer = new RobotContainer();

  @Override public void robotInit() {
    robotContainer.initCameras();
  }

  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    robotContainer.telemetry.updateData();
  }

  @Override public void disabledInit() {

  }

  @Override public void disabledPeriodic() {

  }

  @Override public void autonomousInit() {

  }

  @Override public void autonomousPeriodic() {

  }

  @Override public void teleopInit() {

  }

  @Override public void teleopPeriodic() {

  }

  @Override public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override public void testPeriodic() {

  }
}