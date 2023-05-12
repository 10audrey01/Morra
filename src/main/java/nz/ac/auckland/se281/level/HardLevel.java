package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.Strategy;
import nz.ac.auckland.se281.strategy.TopStrategy;

public class HardLevel implements Level {
  private int numberOfRounds;
  private HumanPlayer humanPlayer;
  private Strategy strategy;

  public HardLevel(int numberOfRounds, HumanPlayer humanPlayer) {
    this.numberOfRounds = numberOfRounds;
    this.humanPlayer = humanPlayer;
  }

  @Override
  public FingersAndSum action() { // set strategy to Random for first 3 rounds, then set strategy to Top
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
