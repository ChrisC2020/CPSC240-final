//imports and whatnot
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * */

public class Roulette implements  ActionListener {
    Random rng = new Random();
    int startValIndex;
    int endValIndex;
    int rotations;
    int tileTurns;
    double degreeTurn;
    double wager;
    String bet;
    WINTYPE wintype = WINTYPE.NUMBER;

    //store winning values somehow
    int[] allTiles;
    int[] redTiles;
    int[] blackTiles;

    //GUI variable & objects
    JPanel jPanel;
    JTextField betField;
    JButton spinButton;
    Ball ball;



    //use JButtons to select tiles to wager on
    //JButton as parameter

    //create game panel???
    //user bet as parameter
    public Roulette(double betAmount){
        jPanel = new JPanel();
        JLabel label = new JLabel("A string of letters");
        jPanel.add(label);
        allTiles = new int[] {0, 32, 15, 19, 4, 21, 2, 25,17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
        redTiles = new int[] {32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3};
        blackTiles = new int[] {15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26};
        wager = betAmount;

        spinButton = new JButton();
        spinButton.addActionListener(this);
    }

    //create starting GUI screen here
    public JPanel getJPanel(){
        FlowLayout layout = new FlowLayout();
        jPanel.setLayout(layout);
        try{
            ball  = new Ball();

        }catch (Exception e){

        }
        return jPanel;
    }

    /**
     * get a bet from a JTextField
     * @return a String the specifies a bet
     * */
    //create if statements
    //rerun method and re-prompt or print "invalid message"
    public String setBet(){
        bet = "";

        bet = betField.getText();

        if(bet.strip().equalsIgnoreCase("black")){
            wintype = WINTYPE.COLOR;
        } else if (bet.strip().equalsIgnoreCase("red")){
            wintype = WINTYPE.COLOR;
        } else if (Integer.parseInt(bet) >= 0 && Integer.parseInt(bet) <= 37){
            wintype = WINTYPE.NUMBER;
        } else {
            //print invalid message statement
            return setBet();
        }

        return bet;
    }


    //stagnant wheel, ball moves in circular motion
    //start position is between two tiles, offset by (360/37)/2
    /**
     * calculate ending value of spin and determine degrees of rotation for ball path
     * */
    public void spin(){
        startValIndex = 0;
        rotations = rng.nextInt(3,7);
        tileTurns = rng.nextInt(0, 37);
        degreeTurn = tileTurns * (360/37);
        endValIndex = startValIndex + tileTurns;

    }


    //print game and winning results
    public double payout(){
        double winnings = 0;

        if (wintype == WINTYPE.COLOR){
            if(Arrays.asList(redTiles).contains(Integer.parseInt(bet))) {
                //print red wins?
                winnings = wager * 2;
            }

            else if (Arrays.asList(blackTiles).contains(Integer.parseInt(bet))){
                //print black wins
                winnings = wager * 2;
            }
        }


        else if (wintype == WINTYPE.NUMBER){
            if (Integer.parseInt(bet) == allTiles[endValIndex]) {
                winnings = wager * 37;
            }
        }

        if (winnings == 0){
            // you lose fuckboi
        }

        return winnings;
    }



    //Figure this one out
    public void setWager(double amount){
        wager = amount;
    }


    //GUI
    //attach to spin button
    //make play block???
    @Override
    public void actionPerformed(ActionEvent e) {

        //gotta figure something out here
        //setWager(wager);

        setBet();

        spin();

        //spin ball here
        //method or write here???

        payout();
    }

    public enum WINTYPE{COLOR, NUMBER};
}
