package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTime;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.motor.RunMotorCommand;
import frc.robot.motor.RunMotorInvertedCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;

public class DumpBackCommands extends ParallelCommandGroup {
  public DumpBackCommands(Shooter shooter, Elevator elevator, Drivetrain drive) {
    addCommands(
      new RunMotorInvertedCommand(shooter), // dump
      new RunMotorCommand(elevator), // elevator
      new DriveTime(4, -0.75, drive) // drive back for 4 seconds--CHECK THIS
    );
  }
}
