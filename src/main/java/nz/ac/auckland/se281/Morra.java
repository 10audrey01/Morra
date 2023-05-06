package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  int numberOfRounds;
  String playerName;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    numberOfRounds = 1;
    playerName = options[0];
  }

  public void play() {
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    String input; // initialised variables used in while loop
    String[] inputArray;
    boolean isInteger;
    int fingers;
    int sum;
    boolean inputValid = false;

    MessageCli.START_ROUND.printMessage(String.valueOf(numberOfRounds));

    while (!inputValid) {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      inputArray = input.split(" ");
      isInteger = Utils.isInteger(inputArray[0]) && Utils.isInteger(inputArray[1]);
      if (isInteger) { // convert to integers if valid, otherwise set to 0 (which will fail the next
        // if statement)
        fingers = Integer.parseInt(inputArray[0]);
        sum = Integer.parseInt(inputArray[1]);
      } else {
        fingers = 0;
        sum = 0;
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
  }

  public void showStats() {}
}
