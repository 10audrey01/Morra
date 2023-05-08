package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy extends Strategy{

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
