//imports and whatnot
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * */

public class Roulette implements  ActionListener {
    Random rng = new Random();
    int endValIndex;
    int tileTurns;
    double wager;
    String bet;
    WINTYPE wintype = WINTYPE.NUMBER;
    UserPane userPane;

    //store winning values somehow
    int[] allTiles;
    int[] redTiles;
    int[] blackTiles;
    HashMap<Integer, ImageIcon> endings;

    //GUI variable & objects
    JPanel jPanel;
    JPanel roulettePanel;
    JPanel dataPanel;
    JLabel instructionLabel;
    JLabel redLabel;
    JLabel blackLabel;
    JLabel numberLabel;
    JLabel wheelPic;
    JLabel betLabel;
    JTextField betField;
    JButton spinButton;

    //something about print and remove JLabels


    //create game panel???
    //user bet as parameter
    public Roulette(UserPane up) {
        userPane = up;
        allTiles = new int[] {0, 32, 15, 19, 4, 21, 2, 25,17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
        redTiles = new int[] {32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3};
        blackTiles = new int[] {15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26};

        RouletteWheel rouletteWheel = new RouletteWheel();
        endings = rouletteWheel.getEndings();
    }

    //create starting GUI screen here
    public JPanel getJPanel(){
        jPanel = new JPanel();
        roulettePanel = new JPanel();

        dataPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(dataPanel, BoxLayout.PAGE_AXIS);
        dataPanel.setLayout(boxLayout);

        instructionLabel = new JLabel("Valid bets include:");
        redLabel = new JLabel("'red' (2:1 odds)");
        blackLabel = new JLabel("'black' (2:1 odds)");
        numberLabel = new JLabel("A number 0-36 (37:1 odds)");


        //add label for valid entries???
        betLabel = new JLabel("Place a bet:");
        betField = new JTextField();

        spinButton = new JButton("Spin");
        spinButton.addActionListener(this);


        dataPanel.add(instructionLabel);
        dataPanel.add(redLabel);
        dataPanel.add(blackLabel);
        dataPanel.add(numberLabel);
        dataPanel.add(betLabel);
        dataPanel.add(betField);
        dataPanel.add(spinButton);

        FlowLayout layout = new FlowLayout();
        jPanel.setLayout(layout);

        wheelPic = new JLabel(endings.get(37));

        jPanel.add(wheelPic);
        jPanel.add(dataPanel);


        jPanel.setVisible(true);
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
        tileTurns = rng.nextInt(0, 37);
        endValIndex = tileTurns;

        wheelPic.setIcon(endings.get(allTiles[endValIndex]));

    }


    //print game and winning results
    public double payout(){
        double winnings = 0;

        if (wintype == WINTYPE.COLOR){
            if(Arrays.asList(redTiles).contains(allTiles[endValIndex])) {
                //print red wins?
                winnings = wager * 2;
                userPane.setBalance(userPane.getBalance()+winnings);
            }

            else if (Arrays.asList(blackTiles).contains(allTiles[endValIndex])){
                //print black wins
                winnings = wager * 2;
                userPane.setBalance(userPane.getBalance()+winnings);
            }
        }


        else if (wintype == WINTYPE.NUMBER){
            if (Integer.parseInt(bet) == allTiles[endValIndex]) {
                winnings = wager * 37;
                userPane.setBalance(userPane.getBalance()+winnings);
            }
        }

        if (winnings == 0){
            userPane.setBalance(userPane.getBalance()-wager);
        }

        return winnings;
    }


    public void setWager(){
        wager = userPane.getCurrentBet();
    }


    //GUI
    //attach to spin button
    //make play block???
    @Override
    public void actionPerformed(ActionEvent e) {

        setWager();

        setBet();

        spin();

        payout();
    }

    public enum WINTYPE{COLOR, NUMBER};
}
