package nz.ac.auckland.se281;

public class EasyLevel implements Level {

  public EasyLevel() {}

  public FingersAndSum action() {
    Strategy strategy = new RandomStrategy();
    return strategy.selectFingersAndSum();
  }
}
