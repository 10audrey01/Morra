package nz.ac.auckland.se281;

public class RandomStrategy extends Strategy {

  @Override
  public FingersAndSum selectFingersAndSum() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    return new FingersAndSum(fingers, sum);
  }
}