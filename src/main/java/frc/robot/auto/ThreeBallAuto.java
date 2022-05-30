package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.api.motor.RunMotor;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.drivetrain.DriveStraightTimed;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.TurnDegrees;
import frc.robot.subsystems.intakepivot.IntakePivot;
import frc.robot.subsystems.intakepivot.PivotIntakeDown;

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

        new DriveStraightTimed(drive, -1, 400),
        new WaitCommand(0.5),
        new TurnDegrees(drive, -0.65, 55, true),
        new DriveStraightTimed(drive, -1, 1450),
        new WaitCommand(0.5),
        new DriveStraightTimed(drive, 1, 1250),
        new WaitCommand(0.5),
        new TurnDegrees(drive, 0.65, 40, true),
        new DriveStraightTimed(drive, 1, 400),
        new RunMotor(shooter, 1000)
      )
    );
  }
}