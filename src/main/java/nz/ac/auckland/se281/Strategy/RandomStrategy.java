package nz.ac.auckland.se281.strategy;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.Utils;

public class RandomStrategy extends Strategy {

  @Override
  public FingersAndSum selectFingersAndSum() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    return new FingersAndSum(fingers, sum);
  }
}