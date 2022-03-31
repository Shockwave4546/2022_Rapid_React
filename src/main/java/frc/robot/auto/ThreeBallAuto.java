package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.api.motor.RunMotor;
import frc.robot.drivetrain.DriveStraightTimed;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.drivetrain.TurnDegrees;
import frc.robot.intakepivot.IntakePivot;
import frc.robot.intakepivot.PivotIntakeDown;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ThreeBallAuto extends ParallelCommandGroup {
  public ThreeBallAuto(Shooter shooter, Elevator elevator, Drivetrain drive, IntakePivot intakePivot, Intake intake) {
    addCommands(
      new RunMotor(intake),
      new RunMotor(elevator),

      new SequentialCommandGroup(
        new PivotIntakeDown(intakePivot),
        new DriveStraightTimed(drive, -1, 1000),
        new WaitCommand(0.5),
        new DriveStraightTimed(drive, 1, 1350),
        new RunMotor(shooter, 1000),

        new DriveStraightTimed(drive, -1, 500),
        new WaitCommand(0.5),
        new TurnDegrees(drive, -0.65, 50, true),
        new DriveStraightTimed(drive, -1, 1450),
        new WaitCommand(0.5),
        new DriveStraightTimed(drive, 1, 1250),
        new WaitCommand(0.5),
        new TurnDegrees(drive, 0.65, 45, true),
        new DriveStraightTimed(drive, 1, 500),
        new RunMotor(shooter, 1000)
      )
    );
  }
}