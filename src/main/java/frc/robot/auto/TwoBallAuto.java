package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.api.motor.RunMotor;
import frc.robot.drivetrain.DriveStraightTimed;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class TwoBallAuto extends SequentialCommandGroup {
  public TwoBallAuto(Shooter shooter, Elevator elevator, Drivetrain drive, IntakePivot intakePivot, Intake intake) {
    addCommands(
      new ParallelCommandGroup(
        new PivotIntakeDown(intakePivot),
        new RunMotor(shooter, 2000),
        new RunMotor(elevator, 2000)
      ),
      new ParallelCommandGroup(
        new DriveStraightTimed(drive, -0.65, 5000),
        new RunMotor(intake, 6500),
        new RunMotor(elevator, 4500)
      ),
      new ParallelCommandGroup(
        new DriveStraightTimed(drive, 0.75, 5000),
        new RunMotor(elevator, 4000)
      ),

      new RunMotor(shooter, 4500)
    );
  }
}