//imports and whatnot
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * */

class ButtonListener implements ActionListener {
    private JTextField tf;
    String betSelected;

    //
    public ButtonListener (JTextField textField){
        this.tf = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}

public class Roulette {
    Random rng = new Random();
    int startValIndex;
    int endValIndex;
    int rotations;
    int tileTurns;
    double degreeTurn;
    double wager;
    WINTYPE wintype = WINTYPE.NUMBER;

    //store winning values somehow
    int[] allTiles;
    int[] redTiles;
    int[] blackTiles;

    //GUI variable & objects
    JFrame jFrame;
    JTextField numOrColor;
    JTextField betField;
    JButton spinButton;



    //use JButtons to select tiles to wager on
    //JButton as parameter

    //create game panel???
    public Roulette(){
        jFrame = new JFrame();
        JLabel label = new JLabel("A string of letters");
        jFrame.add(label);
        allTiles = new int[] {0, 32, 15, 19, 4, 21, 2, 25,17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
        redTiles = new int[] {32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3};
        blackTiles = new int[] {15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26};
    }


    public JFrame getjFrame(){
        return jFrame;
    }

    //choose either number or color
    public void setBet(){

    }


    public void createBall(){
        Ball ball = new Ball();
    }

    public void createWheel(){
        Wheel wheel = new Wheel();
    }


    //stagnant wheel, ball moves in circular motion
    //start position is between two tiles, offset
    public double spin(){
        startValIndex = 0;
        rotations = rng.nextInt(3,7);
        tileTurns = rng.nextInt(0, 37);
        degreeTurn = tileTurns * (360/37);
        endValIndex = startValIndex + tileTurns;

        return degreeTurn;
    }

    public double payout(){
        double winnings = 0;

        if (wintype == WINTYPE.COLOR){
            winnings = wager * 2;
        } else if (wintype == WINTYPE.NUMBER){
            winnings = wager * 37;
        }

        return winnings;
    }

    //getters and setters

    public int getRotations() {
        return rotations;
    }

    //treat as a main block
    public void play(double wager){

    }

    public enum WINTYPE{COLOR, NUMBER};
}
