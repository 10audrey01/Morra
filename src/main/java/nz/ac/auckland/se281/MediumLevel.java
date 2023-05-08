package nz.ac.auckland.se281;

public class MediumLevel extends Level {

  @Override
  public FingersAndSum action(int roundNumber, HumanPlayer humanPlayer) {
    if (roundNumber <= 3) {
      return new RandomStrategy().selectFingersAndSum();
    } else {
      return new AverageStrategy().selectFingersAndSum(humanPlayer);
    }
  }
}
