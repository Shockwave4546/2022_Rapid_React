package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.drivetrain.DriveTime;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;

public class DriveBackCommand extends ParallelCommandGroup {
  public DriveBackCommand(Drivetrain drivetrain, IntakePivot intakePivot) {
    addCommands(
      new PivotIntakeDown(intakePivot),
      new DriveTime(5500, -0.65, drivetrain)
      ); // drive back for 4 seconds--CHECK THIS);
  }
}
