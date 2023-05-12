package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.strategy.Strategy;

public interface Level {
  public FingersAndSum action();

  public void setStrategy(Strategy strategy);
}