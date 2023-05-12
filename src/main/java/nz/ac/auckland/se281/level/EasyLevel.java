package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.Strategy;

public class EasyLevel implements Level {
  private Strategy strategy;

  public FingersAndSum action() {
    setStrategy(new RandomStrategy());
    return strategy.selectFingersAndSum();
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
