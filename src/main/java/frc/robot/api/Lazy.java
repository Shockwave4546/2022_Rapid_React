package frc.robot.api;

import java.util.function.Supplier;

public class Lazy<T> implements Supplier<T> {
  private final Supplier<T> initializer;
  private volatile T value;

  private Lazy(Supplier<T> initializer) {
    this.initializer = initializer;
  }

  @Override public T get() {
    if (value == null) {
      synchronized (this) {
        if (value == null) {
          value = initializer.get();
        }
      }
    }
    
    return value;
  }
  
  public static <T> Lazy<T> of(Supplier<T> initializer) {
    return new Lazy<T>(initializer);
  }
}