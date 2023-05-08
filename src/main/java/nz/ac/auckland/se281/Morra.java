package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  int numberOfRounds;
  String playerName;
  Difficulty difficulty;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    numberOfRounds = 1;
    playerName = options[0];
    this.difficulty = difficulty;
  }

  public void play() {
    if (playerName == null) { // check if game has been started
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(numberOfRounds));

    FingersAndSum playerInput = new HumanPlayer().findUserInput(); // get user input
    int playerFingers = playerInput.getFingers();
    int playerSum = playerInput.getSum();
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(playerFingers), String.valueOf(playerSum));

    FingersAndSum jarvisInput = new AI().generateAIFingersAndSum(LevelFactory.getLevel(difficulty)); // get jarvis input
    int jarvisFingers = jarvisInput.getFingers();
    int jarvisSum = jarvisInput.getSum();
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(jarvisFingers), String.valueOf(jarvisSum));
        
    if ((playerSum == playerFingers + jarvisFingers) && (jarvisSum != playerFingers + jarvisFingers)) { // check if human sum is correct and jarvis sum is incorrect
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (jarvisSum == playerFingers + jarvisFingers && (playerSum != playerFingers + jarvisFingers)) { // check if jarvis sum is correct and human sum is incorrect
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    numberOfRounds++;
  }

  public void showStats() {}
}
