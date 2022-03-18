package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTime;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.motor.RunMotorCommand;
import frc.robot.motor.RunMotorInvertedCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.intakepivot.PivotIntakeDown;

public class DumpBackDumpCommands extends SequentialCommandGroup {
  public DumpBackDumpCommands(Shooter shooter, Elevator elevator, Drivetrain drive, IntakePivot intakePivot, Intake intake) {
    addCommands(
      new ParallelCommandGroup(
        new PivotIntakeDown(intakePivot),
        new RunMotorInvertedCommand(shooter, 2000),
        new RunMotorCommand(elevator, 2000)
      ),
      new ParallelCommandGroup(
        new DriveTime(5500, -0.65, drive),
        new RunMotorCommand(intake, 7500),
        new RunMotorCommand(elevator, 7500)

      ),

      new DriveTime(6000, 0.65, drive),
      new RunMotorInvertedCommand(shooter, 2000)

      // new PivotIntakeDown(intakePivot),
      // new RunMotorInvertedCommand(shooter), // dump
      // new RunMotorCommand(elevator), // elevator
      // new DriveTime(5500, -0.65, drive), // drive back for 4 seconds--CHECK THIS
      // new RunMotorCommand(intake)
    );
  }
}
