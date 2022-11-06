package frc.robot.api.shuffleboard;

import java.util.function.Function;
import java.util.function.Supplier;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import frc.robot.Tabs;

public abstract class AdjustableValue<T> implements Supplier<T> {
	protected final T def;
	protected final NetworkTableEntry entry;

	public AdjustableValue(String name, T def, Function<SimpleWidget, SimpleWidget> widgetBuilder) {
		this.def = def;
		this.entry = widgetBuilder.apply(Tabs.DEBUG.add(name, def)).getEntry();
	}

	public NetworkTableEntry getRaw() {
		return entry;
	}

	public abstract void set(T value);
}