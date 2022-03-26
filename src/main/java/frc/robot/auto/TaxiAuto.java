package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.drivetrain.DriveStraightTimed;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;

public class TaxiAuto extends ParallelCommandGroup {
  public TaxiAuto(Drivetrain drive, IntakePivot intakePivot) {
    addCommands(
      new PivotIntakeDown(intakePivot),
      new DriveStraightTimed(drive, -0.65, 5500)
      ); // drive back for 4 seconds--CHECK THIS);
  }
}
