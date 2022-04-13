//imports and whatnot
import java.util.Random;

public class Roulette {
    Random rng = new Random();
    String startVal;
    String endVal;
    int rotations;
    double wager;
    float odds;

    //use JButtons to select tiles to wager on


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
