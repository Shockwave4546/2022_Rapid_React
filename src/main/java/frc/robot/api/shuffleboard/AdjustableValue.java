package frc.robot.api.shuffleboard;

import java.util.function.Function;
import java.util.function.Supplier;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import frc.robot.Tabs;

public abstract class AdjustableValue<T> implements Supplier<T> {
	protected final T def;
	protected final GenericEntry entry;

	public AdjustableValue(String name, T def, Function<SimpleWidget, SimpleWidget> widgetBuilder) {
		this.def = def;
		this.entry = widgetBuilder.apply(Tabs.DEBUG.add(name, def)).getEntry();
	}

	public GenericEntry getRaw() {
		return entry;
	}

	public abstract void set(T value);
}