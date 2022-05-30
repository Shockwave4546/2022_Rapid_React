package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.api.motor.RunMotor;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.drivetrain.DriveStraightTimed;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.intakepivot.IntakePivot;
import frc.robot.subsystems.intakepivot.PivotIntakeDown;

public class OneBallAuto extends ParallelCommandGroup {
  public OneBallAuto(Shooter shooter, Elevator elevator, Drivetrain drive, IntakePivot intakePivot) {
    addCommands(
      new PivotIntakeDown(intakePivot),
      new RunMotor(shooter, 15000), // dump
      new RunMotor(elevator, 15000), // elevator
      new DriveStraightTimed(drive, -0.65, 5500) // drive back for 4 seconds--CHECK THIS
    );
  }
}
