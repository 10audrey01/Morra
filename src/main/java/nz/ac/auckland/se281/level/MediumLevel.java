package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.strategy.AverageStrategy;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.Strategy;

public class MediumLevel implements Level {
  private int numberOfRounds;
  private HumanPlayer humanPlayer;
  private Strategy strategy;

  public MediumLevel(int numberOfRounds, HumanPlayer humanPlayer) {
    this.numberOfRounds = numberOfRounds;
    this.humanPlayer = humanPlayer;
  }

  @Override
  // set strategy to Random for first 3 rounds, then set strategy to Average
  public FingersAndSum action() {
    if (numberOfRounds <= 3) {
      setStrategy(new RandomStrategy());
      return strategy.selectFingersAndSum();
    } else {
      setStrategy(new AverageStrategy());
      return strategy.selectFingersAndSum(humanPlayer);
    }
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
