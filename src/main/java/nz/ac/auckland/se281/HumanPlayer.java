package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {
  private List<Integer> playerFingersInputHistory = new ArrayList<Integer>();

  public FingersAndSum findUserInput() {
    String input; // initialised variables used in while loop
    String[] inputArray;
    boolean isFirstIteration = true;

    do {
      if (!isFirstIteration) {
        MessageCli.INVALID_INPUT.printMessage();
      }
      isFirstIteration = false;
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine().trim();
      inputArray = input.split(" ");
    } while (inputArray.length != 2 || !isFitsFingersAndSumInputRequirements(inputArray[0], inputArray[1]));

    int fingers = Integer.parseInt(inputArray[0]);
    int sum = Integer.parseInt(inputArray[1]);

    return new FingersAndSum(fingers, sum);
  }

  public boolean isFitsFingersAndSumInputRequirements(String fingersString, String sumString) {
    if (!Utils.isInteger(fingersString) || !Utils.isInteger(sumString)) {
      return false;
    }
    int fingers = Integer.parseInt(fingersString);
    int sum = Integer.parseInt(sumString);
    return (fingers >= 1 && fingers <= 5 && sum >= 1 && sum <= 10);
  }

  public List<Integer> getPlayerFingersInputHistory() {
    return playerFingersInputHistory;
  }

  public void addPlayerFingersInputHistory(int fingers) {
    playerFingersInputHistory.add(fingers);
  }
}
