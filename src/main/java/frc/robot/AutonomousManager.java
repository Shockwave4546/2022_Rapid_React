package frc.robot;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.commands.PPRamseteCommand;
import com.pathplanner.lib.server.PathPlannerServer;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drivetrain.Drivetrain;

/**
 * 
 */
public class AutonomousManager {
  private final SendableChooser<Command> chooser = new SendableChooser<>();
  private final Drivetrain drive;

  /**
   * @param drive
   */
  public AutonomousManager(Drivetrain drive, boolean debug) {
    this.drive = drive;
    if (debug) PathPlannerServer.startServer(5811);
    Tabs.MATCH.add("Autonomous Chooser", chooser).withSize(3, 2);
    chooser.setDefaultOption("Do Nothing", new InstantCommand());
  }

  /**
   * @param pathName
   */
  public void addPath(String pathName, PathConstraints constraints) {
    chooser.addOption(pathName, loadPathPlannerTrajectoryToRamseteCommand(pathName, true, constraints));
  }

   /**
   * 
   */
  public void executeRoutine() {
    chooser.getSelected().schedule();
  }

  // TODO: Implement with RamseteAutoBuilder
  /**
   * @param fileName
   * @param resetOdometry
   * @param constraints
   * @return
   */
  private Command loadPathPlannerTrajectoryToRamseteCommand(String fileName, boolean resetOdometry, PathConstraints constraints) {
    final var path = PathPlanner.loadPath(fileName, constraints);
    final var ramseteCommand = new PPRamseteCommand(
      path, 
      drive::getPose, 
      new RamseteController(Constants.Drivetrain.RAMSETE_B, Constants.Drivetrain.RAMSETE_ZETA), 
      new SimpleMotorFeedforward(Constants.Drivetrain.KS_VOLTS, Constants.Drivetrain.KV_VOLT_SECONDS_PER_METER, Constants.Drivetrain.KA_VOLT_SECONDS_SQUARED_PER_METER), 
      drive.getKinematics(), 
      drive::getWheelSpeeds, 
      new PIDController(Constants.Drivetrain.P_DRIVE_VELOCITY, 0, 0), 
      new PIDController(Constants.Drivetrain.P_DRIVE_VELOCITY, 0, 0), 
      drive::tankDriveVolts,
      true,
      drive
    );

    final var stopCommand = new InstantCommand(() -> drive.stop());
    return resetOdometry ? new SequentialCommandGroup(new InstantCommand(() -> drive.resetOdometry(path.getInitialPose())), ramseteCommand, stopCommand) : ramseteCommand.andThen(stopCommand);
  }
}