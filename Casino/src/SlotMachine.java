//Only one slot machine is made, should it be a Singleton?
//Consists of 3 reels (and a lever (button))
//has 3 "paylines": straight across and both diagonals
//gives a different payout depending on which it is
//may implement checking for specific faces for face-specific payouts

public class SlotMachine {
    private Reel reel1 = new Reel();
    private Reel reel2 = new Reel();
    private Reel reel3 = new Reel();

    private ReelFaces face1;
    private ReelFaces face2;
    private ReelFaces face3;

    public void build(){

        //fills the reels with faces
        reel1.Populate();
        reel2.Populate();
        reel3.Populate();
    }

    public void spin(){
        //I may want to integrate multithreading right here so they can all do their spins at the same time (visually)
        //If only 1 thread is used, they might try to spin 1 at a time.
        reel1.Spin();
        reel2.Spin();
        reel3.Spin();
        payout(getWinner());
    }

    public int getWinner(){
        //ways to win (each gives a different payout)
        //Straight across (jackpot)
        //diagonal up or diagonal down (minor payout)
        face1 = reel1.getCurrentFace();
        face2 = reel2.getCurrentFace();
        face3 = reel3.getCurrentFace();

        if (face1 == face2 && face1 == face3) { //does not need the printlns, those were for testing without GUI
            //System.out.println("Congratulations! You won the jackpot!");
            return 1;
        }else if(reel1.getUpFace()==face2 && reel1.getUpFace()==reel3.getDownFace()) {
            //System.out.println("Congratulations! You won the down diagonal prize!");
            return 2;
        }else if(reel1.getDownFace()==face2 && reel1.getDownFace()==reel3.getUpFace()){
            //System.out.println("Congratulations! You won the up diagonal prize!");
            return 2;
        }else{
            //System.out.println("Better luck next time!");
            return 0;
        }
    }

    public void payout(int winnerResult) {
        //alter the player balance from this method somehow?
        //return the double value of currency gained/lost, then have the top level thing that called it do the change?
        switch (winnerResult) { //prints were for testing without GUI
            case 1:
                //System.out.println("Payed out the jackpot!");
                break;
            case 2:
                //System.out.println("Paid out the minor prize!");
                break;
            case 0:
                //System.out.println("Removed money from your balance!");
                break;
        }
    }

}
