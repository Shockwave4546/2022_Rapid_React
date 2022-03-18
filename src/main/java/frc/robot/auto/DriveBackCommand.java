package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.drivetrain.DriveTime;
import frc.robot.drivetrain.Drivetrain;

public class DriveBackCommand extends ParallelCommandGroup {
  public DriveBackCommand(Drivetrain drive) {
    addCommands(new DriveTime(4, -0.75, drive)); // drive back for 4 seconds--CHECK THIS);
  }
}
