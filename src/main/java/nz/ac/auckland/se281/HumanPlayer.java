package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {
    List<Integer> playerFingersInputHistory = new ArrayList<Integer>();
    
    public FingersAndSum findUserInput() {
        String input; // initialised variables used in while loop
        String[] inputArray;
        boolean isInteger;
        int fingers = 0;
        int sum = 0;
        boolean inputValid = false;

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
            } else {
                MessageCli.INVALID_INPUT.printMessage();
            }
        }

        return new FingersAndSum(fingers, sum);
    }

    public List<Integer> getPlayerFingersInputHistory() {
        return playerFingersInputHistory;
    }

    public void addPlayerFingersInputHistory(int fingers) {
        playerFingersInputHistory.add(fingers);
    }


}
