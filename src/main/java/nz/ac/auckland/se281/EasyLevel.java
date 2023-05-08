package nz.ac.auckland.se281;

public class EasyLevel extends Level {

  public EasyLevel() {} 

  public FingersAndSum action() {
    return new RandomStrategy().selectFingersAndSum();
  }
}
