package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.strategy.AverageStrategy;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.Strategy;
import nz.ac.auckland.se281.strategy.TopStrategy;

public class MasterLevel implements Level {
  private int numberOfRounds;
  private HumanPlayer humanPlayer;
  private Strategy strategy;

  public MasterLevel(int numberOfRounds, HumanPlayer humanPlayer) {
    this.numberOfRounds = numberOfRounds;
    this.humanPlayer = humanPlayer;
  }

  @Override
  public FingersAndSum action() {
    if (numberOfRounds <= 3) {
      setStrategy(new RandomStrategy());
      return strategy.selectFingersAndSum();
    } else {
      if (numberOfRounds % 2 == 0) {
        setStrategy(new AverageStrategy());
        return strategy.selectFingersAndSum(humanPlayer);
      } else {
        setStrategy(new TopStrategy());
        return strategy.selectFingersAndSum(humanPlayer);
      }
    }
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

}
