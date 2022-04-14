//Only one slot machine is made, should it be a Singleton?
//Consists of 3 reels (and a lever (button))
//has 3 "paylines": straight across and both diagonals
//gives a different payout depending on which it is
//may implement checking for specific faces for face-specific payouts

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlotMachine implements ActionListener {
    private Reel reel1 = new Reel();
    private Reel reel2 = new Reel();
    private Reel reel3 = new Reel();

    private ReelFaces face1;
    private ReelFaces face2;
    private ReelFaces face3;

    //these are for the GUI
    JButton lever;
    JLabel reelLabel1;
    JLabel reelLabel2;
    JLabel reelLabel3;


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

    public JPanel displaySlotMachine() {
        SpringLayout layout = new SpringLayout();
        JPanel slotMachinePanel = new JPanel();

        slotMachinePanel.setLayout(layout);


        try{
            BufferedImage wPic = ImageIO.read(this.getClass().getResource("Reel Faces window size.jpg"));
            BufferedImage lPic = ImageIO.read(this.getClass().getResource("leverUpTemp.png"));
            reelLabel1 = new JLabel(new ImageIcon(wPic));
            reelLabel2 = new JLabel(new ImageIcon(wPic));
            reelLabel3 = new JLabel(new ImageIcon(wPic));
            lever = new JButton(new ImageIcon(lPic));


            //constraints to fit the reels
            layout.putConstraint(SpringLayout.WEST, reelLabel1, 5, SpringLayout.WEST, slotMachinePanel);
            layout.putConstraint(SpringLayout.NORTH, reelLabel1, 50, SpringLayout. NORTH, slotMachinePanel);

            layout.putConstraint(SpringLayout.WEST, reelLabel2,174, SpringLayout.WEST, slotMachinePanel);
            layout.putConstraint(SpringLayout.NORTH, reelLabel2,50, SpringLayout.NORTH, slotMachinePanel);

            layout.putConstraint(SpringLayout.WEST, reelLabel3,343, SpringLayout.WEST, slotMachinePanel);
            layout.putConstraint(SpringLayout.NORTH, reelLabel3,50, SpringLayout.NORTH, slotMachinePanel);


            //constraints to fit the lever
            layout.putConstraint(SpringLayout.WEST, lever,512, SpringLayout.WEST, slotMachinePanel);
            layout.putConstraint(SpringLayout.NORTH, lever,150, SpringLayout.NORTH, slotMachinePanel);

            //slotMachinePanel.add(first);
            //slotMachinePanel.add(second);
            slotMachinePanel.add(reelLabel1);
            slotMachinePanel.add(reelLabel2);
            slotMachinePanel.add(reelLabel3);
            slotMachinePanel.add(lever);

            lever.addActionListener(this);

        }catch (Exception e){
            JLabel failure = new JLabel("Panel");
            slotMachinePanel.add(failure);
            System.out.println("Slots panel failed to load");

        }

        return slotMachinePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if(button == lever){
            try{
                BufferedImage lPic = ImageIO.read(this.getClass().getResource("leverDownTemp.png"));
                lever.setIcon(new ImageIcon(lPic));
                //this works, I'm able to change the image on click
                //give it a countdown and then update it back to being upright
            }catch (Exception x){
                System.out.println("Something went wrong with the Lever");
            }
        }
    }
}
