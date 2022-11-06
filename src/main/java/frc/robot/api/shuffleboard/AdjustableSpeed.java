package frc.robot.api.shuffleboard;

import java.util.Map;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class AdjustableSpeed extends AdjustableValue<Double> {
	public AdjustableSpeed(String name, Double def, Pos2D pos) {
		super(name, def, widget -> widget.withPosition(pos.x, pos.y).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", "-1", "max", "1")));
	}

	public AdjustableSpeed(String name, Double def) {
		super(name, def, widget -> widget.withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", "-1", "max", "1")));
	}

	@Override public Double get() {
		return entry.getDouble(def);
	}

	@Override public void set(Double value) {
		entry.setDouble(value);
	}
}