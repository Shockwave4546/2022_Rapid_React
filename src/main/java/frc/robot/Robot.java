package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * Representing the functionality of our Robot, the VM will automatically create an instance of this class upon startup.
 * All "periodic" functions within this class executes every 20ms inside the {@link Robot} main thread.
 */
public class Robot extends TimedRobot {
  /**
   * This acts as an abstract layer between the raw robot functions and our implemented behaviors.
   * For instance, our button bindings, controller inputs, and autonomous chooser will get encapsulated within here.
   */
  private final RobotContainer container = new RobotContainer();

  /**
   * Ran after our Robot is first started, this initializes the two cameras mounted on the front our robot,
   * which allows us to place these onto the Shuffleboard to aid the Drive Team.
   */
  @Override public void robotInit() {
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);
  }

  /**
   * Every 20ms, the CommandScheduler will get ran, which is responsible for polling buttons, adding newly-scheduled commands,
   * running already-schedule commands, removing finished or interrupted commands, and running {@link Subsystem#periodic()} methods.
   * It's vital to run this here in order for the Command-based framework to function correctly.
   */
  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * Ran once autonomous mode is enabled. This operates on a {@link SendableChooser}, where the user can decide which autonomous mode
   * they would like to execute, depending on external circumstances. For instance, within a game, a team could have an autonomous
   * that would interfere with ours, therefore, we could opt to use an autonomous that doesn't coincide with their path. However, by default,
   * this function will execute our 3-ball auto.
   */
  @Override public void autonomousInit() {
    container.auto.runSelected();
  }
  
  /**
   * Ran once teleoperated mode is enabled. Once tele-op is enabled, the default command will be set to controller based driving,
   * allowing for our drive team to begin the round. 
   */
  @Override public void teleopInit() {
    container.drive.initTeleop();
  }
}