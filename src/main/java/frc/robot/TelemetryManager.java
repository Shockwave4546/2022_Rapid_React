package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class TelemetryManager {
  private final ShuffleboardTab telemetryTab = Shuffleboard.getTab("Telemetry");
  private final PowerDistribution pdp = new PowerDistribution();
  private final NetworkTableEntry totalEnergy = addData("Total Energy", pdp.getTotalEnergy(), 2, 0);
  private final NetworkTableEntry totalCurrent = addData("Total Current", pdp.getTotalCurrent(), 3, 0);
  private final NetworkTableEntry totalPower = addData("Total Power", pdp.getTotalPower(), 2, 1);
  private final NetworkTableEntry voltage = addData("Voltage", pdp.getVoltage(), 3, 1);
  private final NetworkTableEntry temperature = addData("Temperature", pdp.getTemperature(), 2, 2);

  public TelemetryManager() {
    telemetryTab.add("Voltage & Current (0-15)", pdp).withPosition(0, 0).withSize(2, 5);
  }

  public void updateData() {
    totalEnergy.setValue(pdp.getTotalEnergy());
    totalCurrent.setValue(pdp.getTotalCurrent());
    totalPower.setValue(pdp.getTotalPower());
    voltage.setValue(pdp.getVoltage());
    temperature.setValue(pdp.getTemperature());
  }

  private NetworkTableEntry addData(String name, double value, int x, int y) {
    return telemetryTab.add(name, value).withPosition(x, y).getEntry();
  }
}