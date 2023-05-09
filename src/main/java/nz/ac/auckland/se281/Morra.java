package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.level.Level;
import nz.ac.auckland.se281.level.LevelFactory;

public class Morra {
  private Difficulty difficulty;
  private int pointsToWin;
  private String playerName;
  private int numberOfRounds;
  private HumanPlayer humanPlayer;
  private int humanPlayerScore;
  private int aiScore;

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.difficulty = difficulty;
    this.pointsToWin = pointsToWin;
    playerName = options[0];
    numberOfRounds = 1;
    humanPlayer = new HumanPlayer();
  }

  public void play() {
    if (playerName == null) { // check if game has been started
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(numberOfRounds));

    FingersAndSum playerInput = humanPlayer.findUserInput(); // get user input
    int playerFingers = playerInput.getFingers();
    int playerSum = playerInput.getSum();
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(playerFingers), String.valueOf(playerSum));

    FingersAndSum jarvisInput = getJarvisInput(); // get jarvis input
    int jarvisFingers = jarvisInput.getFingers();
    int jarvisSum = jarvisInput.getSum();
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(jarvisFingers), String.valueOf(jarvisSum));

    if ((playerSum == playerFingers + jarvisFingers) && (jarvisSum != playerFingers + jarvisFingers)) { // check if
                                                                                                        // human sum is
                                                                                                        // correct and
                                                                                                        // jarvis sum is
                                                                                                        // incorrect
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanPlayerScore++;
    } else if (jarvisSum == playerFingers + jarvisFingers && (playerSum != playerFingers + jarvisFingers)) { // check if
                                                                                                             // jarvis
                                                                                                             // sum is
                                                                                                             // correct
                                                                                                             // and
                                                                                                             // human
                                                                                                             // sum is
                                                                                                             // incorrect
      aiScore++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    if (humanPlayerScore == pointsToWin) { // check if human player has won
      MessageCli.END_GAME.printMessage(playerName, String.valueOf(numberOfRounds));
      playerName = null;
      return;
    } else if (aiScore == pointsToWin) { // check if jarvis has won
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(numberOfRounds));
      playerName = null;
      return;
    } else {
      humanPlayer.addPlayerFingersInputHistory(playerFingers);
      numberOfRounds++;
    }
  }

  public FingersAndSum getJarvisInput() {
    Level level = LevelFactory.getLevel(difficulty, numberOfRounds, humanPlayer);
    return level.action();
  }

  public void showStats() {
    if (playerName == null) { // check if game has been started
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, String.valueOf(humanPlayerScore),
          String.valueOf(pointsToWin - humanPlayerScore));
      MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", String.valueOf(aiScore),
          String.valueOf(pointsToWin - aiScore));
    }
  }
}
