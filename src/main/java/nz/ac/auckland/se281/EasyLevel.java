package nz.ac.auckland.se281;

public class EasyLevel implements Level {

  public EasyLevel() {} 

  public FingersAndSum action() {
    Strategy strategy = new RandomStrategy(); // easy level implements the random strategy the whole time
    return strategy.selectFingersAndSum();
  }
}
