package frc.robot.auto;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

public class AutonomousManager {
  private final SendableChooser<Command> chooser = new SendableChooser<>();

  public AutonomousManager(ShuffleboardTab tab) {
    tab.add("Autonomous Chooser", chooser);
  }

  public void addOption(String name, Command command) {
    chooser.addOption(name, command);
  }

  public void setDefault(String name, Command command) {
    chooser.setDefaultOption(name, command);
  }

  public void runSelected() {
    chooser.getSelected().schedule();
  }
}