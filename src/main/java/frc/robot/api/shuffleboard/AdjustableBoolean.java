package frc.robot.api.shuffleboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class AdjustableBoolean extends AdjustableValue<Boolean> {
  public AdjustableBoolean(String name, Boolean def, Pos2D pos) {
    super(name, def, widget -> widget.withPosition(pos.x, pos.y).withWidget(BuiltInWidgets.kToggleButton));
  }

  public AdjustableBoolean(String name, Boolean def) {
    super(name, def, widget -> widget.withWidget(BuiltInWidgets.kToggleButton));
  }

  @Override public Boolean get() {
    return entry.getBoolean(def);
  }

  @Override public void set(Boolean value) {
    entry.setBoolean(value);
  }
}