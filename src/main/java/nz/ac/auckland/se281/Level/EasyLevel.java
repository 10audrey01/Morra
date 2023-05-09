package nz.ac.auckland.se281.Level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.Strategy.RandomStrategy;
import nz.ac.auckland.se281.Strategy.Strategy;

public class EasyLevel implements Level {
  private Strategy strategy;

  public EasyLevel() {} 

  public FingersAndSum action() {
    setStrategy(new RandomStrategy());
    return strategy.selectFingersAndSum();
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
