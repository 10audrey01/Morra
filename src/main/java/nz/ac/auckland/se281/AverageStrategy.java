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

        double avg = (sumOfPlayerFingersInputHistory / playerFingersInputHistory.size());
        int roundedAvg = (int) Math.round(avg);
        System.out.println(avg);
        return new FingersAndSum(fingers, (fingers + roundedAvg));
    }
    
}
