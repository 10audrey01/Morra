package nz.ac.auckland.se281.Level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Strategy.RandomStrategy;
import nz.ac.auckland.se281.Strategy.Strategy;
import nz.ac.auckland.se281.Strategy.TopStrategy;

public class HardLevel implements Level {
  private int numberOfRounds;
  private HumanPlayer humanPlayer;
  private Strategy strategy;

  public HardLevel(int numberOfRounds, HumanPlayer humanPlayer) {
    this.numberOfRounds = numberOfRounds;
    this.humanPlayer = humanPlayer;
  } 

  @Override
  public FingersAndSum action() {
    if (numberOfRounds <= 3) {
      setStrategy(new RandomStrategy());
      return strategy.selectFingersAndSum();
    } else {
      setStrategy(new TopStrategy());
      return strategy.selectFingersAndSum(humanPlayer);
    }
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
