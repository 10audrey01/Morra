package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public FingersAndSum selectFingersAndSum() {
    int finger = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(finger + 1, finger + 5);
    return new FingersAndSum(finger, sum);
  }
}