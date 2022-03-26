package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private final RobotContainer container = new RobotContainer();

  @Override public void robotInit() {
    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture();
  }

  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override public void autonomousInit() {
    container.autoManager.runSelected();
  }
    
  @Override public void teleopInit() {
    container.drive.initTeleop();
  }

  @Override public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }
}