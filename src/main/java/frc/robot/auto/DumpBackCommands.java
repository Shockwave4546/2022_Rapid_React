package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.drivetrain.DriveTime;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.motor.RunMotorCommand;
import frc.robot.motor.RunMotorInvertedCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.intakepivot.PivotIntakeDown;

public class DumpBackCommands extends ParallelCommandGroup {
  public DumpBackCommands(Shooter shooter, Elevator elevator, Drivetrain drive, IntakePivot intakePivot) {
    addCommands(
      new PivotIntakeDown(intakePivot),
      new RunMotorInvertedCommand(shooter, 15000), // dump
      new RunMotorCommand(elevator, 15000), // elevator
      new DriveTime(5500, -0.65, drive) // drive back for 4 seconds--CHECK THIS
    );
  }
}
