package frc.robot.api.shuffleboard;

import java.util.function.Consumer;

import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Tabs;

public class AdjustableValue<T> {
	private final T def;
	private final NetworkTableEntry entry;

	public AdjustableValue(T def, Consumer<NetworkTableEntry> entryBuilder) {
		this.def = def;
		this.entry = Tabs.DEBUG.add(null)
	}
}
