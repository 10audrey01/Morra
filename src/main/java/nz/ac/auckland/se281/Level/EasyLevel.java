package nz.ac.auckland.se281.Level;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.Strategy.RandomStrategy;

public class EasyLevel extends Level {

  public EasyLevel() {} 

  public FingersAndSum action() {
    return new RandomStrategy().selectFingersAndSum();
  }
}
