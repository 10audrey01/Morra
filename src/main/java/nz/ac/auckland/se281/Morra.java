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

    String input; // initialised variables used in while loop
    String[] inputArray;
    boolean isInteger;
    int fingers = 0;
    int sum = 0;
    boolean inputValid = false;

    MessageCli.START_ROUND.printMessage(String.valueOf(numberOfRounds));

    while (!inputValid) {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      inputArray = input.split(" ");
      isInteger = Utils.isInteger(inputArray[0]) && Utils.isInteger(inputArray[1]);
      if (isInteger) { // convert to integers if valid
        fingers = Integer.parseInt(inputArray[0]);
        sum = Integer.parseInt(inputArray[1]);
      }
      if ((inputArray.length == 2)
          && (isInteger)
          && (fingers >= 1
              && fingers <= 5
              && sum >= 1
              && sum
                  <= 10)) { // check if input is valid for all requirements, otherwise loop through
        // while loop again
        inputValid = true;
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, inputArray[0], inputArray[1]);
        numberOfRounds++;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    Level level = LevelFactory.getLevel(difficulty);
    FingersAndSum jarvisFingersAndSum = level.action();
    int jarvisFingers = jarvisFingersAndSum.getFingers();
    int jarvisSum = jarvisFingersAndSum.getSum();
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(jarvisFingers), String.valueOf(jarvisSum));
    if ((sum == fingers + jarvisFingers) && (jarvisSum != fingers + jarvisFingers)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (jarvisSum == fingers + jarvisFingers && (sum != fingers + jarvisFingers)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void showStats() {}
}
