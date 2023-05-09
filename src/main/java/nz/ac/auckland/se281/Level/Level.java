package nz.ac.auckland.se281.Level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.Strategy.Strategy;

public interface Level {
  public FingersAndSum action();
  public void setStrategy(Strategy strategy);
 }