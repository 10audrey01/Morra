package nz.ac.auckland.se281.strategy;

import java.util.List;

import nz.ac.auckland.se281.FingersAndSum;
import nz.ac.auckland.se281.HumanPlayer;
import nz.ac.auckland.se281.Utils;

public class AverageStrategy extends Strategy {

    @Override
    public FingersAndSum selectFingersAndSum(HumanPlayer humanPlayer) {
        double sumOfPlayerFingersInputHistory = 0;
        int fingers = Utils.getRandomNumber(1, 5);
        List<Integer> playerFingersInputHistory = humanPlayer.getPlayerFingersInputHistory();

        for (int finger : playerFingersInputHistory) {
            sumOfPlayerFingersInputHistory += finger;
        }

        int avg = (int) Math.round((sumOfPlayerFingersInputHistory / playerFingersInputHistory.size()));
        return new FingersAndSum(fingers, (fingers + avg));
    }

}
