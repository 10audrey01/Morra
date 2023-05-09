package nz.ac.auckland.se281.Level;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
  public static Level getLevel(Difficulty levelType, int numberOfRounds, HumanPlayer humanPlayer) {
    switch (levelType) {
      case EASY:
        return new EasyLevel();
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
