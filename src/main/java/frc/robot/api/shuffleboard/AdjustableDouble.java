package frc.robot.api.shuffleboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class AdjustableDouble extends AdjustableValue<Double> {
	public AdjustableDouble(String name, Double def, Pos2D pos) {
		super(name, def, widget -> widget.withPosition(pos.x, pos.y).withWidget(BuiltInWidgets.kTextView));
	}

	public AdjustableDouble(String name, Double def) {
		super(name, def, widget -> widget.withWidget(BuiltInWidgets.kTextView));
	}

	@Override public Double get() {
		return entry.getDouble(def);
	}

	@Override public void set(Double value) {
		entry.setDouble(value);
	}
}