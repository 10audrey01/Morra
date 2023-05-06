package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
  public static Level getLevel(Difficulty levelType) {
    switch (levelType) {
      case EASY:
        return new EasyLevel();
      case MEDIUM:
        return new MediumLevel();
      case HARD:
        return new HardLevel();
      default:
        return null;
    }
  }
}
