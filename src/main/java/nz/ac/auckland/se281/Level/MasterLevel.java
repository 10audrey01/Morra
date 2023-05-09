package nz.ac.auckland.se281.Level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Strategy.AverageStrategy;
import nz.ac.auckland.se281.Strategy.RandomStrategy;
import nz.ac.auckland.se281.Strategy.TopStrategy;

public class MasterLevel extends Level {
    
    @Override
    public FingersAndSum action(int roundNumber, HumanPlayer humanPlayer) {
        if (roundNumber <= 3) {
          return new RandomStrategy().selectFingersAndSum();
        } else {
            if (roundNumber % 2 == 0) {
                return new AverageStrategy().selectFingersAndSum(humanPlayer);
            } else {
                return new TopStrategy().selectFingersAndSum(humanPlayer);
            }
        }
      }
}
