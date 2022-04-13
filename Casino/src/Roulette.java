//imports and whatnot
import javax.swing.*;
import java.util.Random;

public class Roulette {
    Random rng = new Random();
    String startVal;
    String endVal;
    int rotations;
    double wager;
    float odds;
    String colorBet;
    String numberBet;
    JPanel gamePanel;




    //use JButtons to select tiles to wager on
    //JButton as parameter

    //create game panel???
    public Roulette(){
        gamePanel = new JPanel();
        JLabel label = new JLabel("A string of letters");
        gamePanel.add(label);
    }


    public JPanel getPanel(){
        return gamePanel;
    }


    public void chooseBet(){

    }


    public void createBall(){
        Ball ball = new Ball();
    }

    public void createWheel(){
        Wheel wheel = new Wheel();
    }

    public void spin(){
        rotations = rng.nextInt(3,7);
    }

    public void play(double wager){

    }

    public double payout(){
        double winnings = 0;

        //if statements for outcomes

        return winnings;
    }

}
