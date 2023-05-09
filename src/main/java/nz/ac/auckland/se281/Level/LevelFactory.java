package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
  public static Level getLevel(Difficulty levelType, int numberOfRounds, HumanPlayer humanPlayer) {
    switch (levelType) {
      case EASY:
        return new EasyLevel(); // does not need any parameters as it only uses RandomStrategy
      case MEDIUM:
        return new MediumLevel(numberOfRounds, humanPlayer);
      case HARD:
        return new HardLevel(numberOfRounds, humanPlayer);
      case MASTER:
        return new MasterLevel(numberOfRounds, humanPlayer);
      default:
        return null;
    }
  }
}
