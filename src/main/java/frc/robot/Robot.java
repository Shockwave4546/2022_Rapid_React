package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ControllerDriveCommand;

public class Robot extends TimedRobot {
  private final RobotContainer robotContainer = new RobotContainer();

  @Override public void robotInit() {

  }

  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    robotContainer.telemetryManager.updateData();
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
    CommandScheduler.getInstance()
      .setDefaultCommand(
        robotContainer.drive, 
        new ControllerDriveCommand(robotContainer.driveController, robotContainer.drive).perpetually()
      );
  }

  @Override public void teleopPeriodic() {

  }

  @Override public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override public void testPeriodic() {

  }
}