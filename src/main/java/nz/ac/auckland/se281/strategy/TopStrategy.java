package nz.ac.auckland.se281.strategy;

import java.util.List;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Utils;

public class TopStrategy extends Strategy {

  @Override
  public FingersAndSum selectFingersAndSum(HumanPlayer humanPlayer) {
    int fingers = Utils.getRandomNumber(1, 5);
    List<Integer> playerFingersInputHistory = humanPlayer.getPlayerFingersInputHistory();
    int top = mostFrequentFinger(playerFingersInputHistory);
    return new FingersAndSum(fingers, (fingers + top));
  }

  int mostFrequentFinger(List<Integer> list) {
    int maxCount = 0;
    int maxFinger = 0;

    // find the most frequent inputted finger by the player
    // if there is a tie, return the first encountered most frequent finger
    for (int finger : list) {
      int count = 0;
      for (int finger2 : list) {
        if (finger == finger2) {
          count++;
        }
      }
      if (count > maxCount) {
        maxCount = count;
        maxFinger = finger;
      }
    }
    return maxFinger;
  }
}
