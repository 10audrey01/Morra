package nz.ac.auckland.se281.strategy;

import java.util.List;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Utils;

public class AverageStrategy extends Strategy {
  @Override
  public FingersAndSum selectFingersAndSum(HumanPlayer humanPlayer) {
    double sumOfPlayerFingersInputHistory = 0;
    int fingers = Utils.getRandomNumber(1, 5);
    // get player's input history
    List<Integer> playerFingersInputHistory = humanPlayer.getPlayerFingersInputHistory();

    // find the sum of all the fingers the player has inputted
    for (int finger : playerFingersInputHistory) {
      sumOfPlayerFingersInputHistory += finger;
    }

    // round avg up to nearest integer
    int avg = (int) Math.round((sumOfPlayerFingersInputHistory / playerFingersInputHistory.size()));
    return new FingersAndSum(fingers, (fingers + avg));
  }
}