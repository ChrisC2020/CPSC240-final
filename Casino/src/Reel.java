import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class Reel {
    private int currentFaceInt=0;
    private HashMap<Integer, ReelFaces> faces = new HashMap<Integer, ReelFaces>();
    private HashMap<Integer, ImageIcon> facePictures = new HashMap<Integer, ImageIcon>();

    public void Populate() throws IOException { //puts values into the hashmaps so they're not all NULLs
        //faces maps integers to ReelFaces enumerations
        //facePictures maps integers to pngs for the reel GUI
        //their ordering matches
        faces.put(0, ReelFaces.barBlue);
        BufferedImage wPic = ImageIO.read(this.getClass().getResource("Images/0_BAR_BLUE.png"));
        facePictures.put(0, new ImageIcon(wPic));
        faces.put(1,ReelFaces.sevenWhite);
        wPic = ImageIO.read(this.getClass().getResource("Images/1_SEVEN_WHITE.png"));
        facePictures.put(1, new ImageIcon(wPic));
        faces.put(2,ReelFaces.cherry);
        wPic = ImageIO.read(this.getClass().getResource("Images/2_CHERRY.png"));
        facePictures.put(2, new ImageIcon(wPic));
        faces.put(3,ReelFaces.barRed);
        wPic = ImageIO.read(this.getClass().getResource("Images/3_BAR_RED.png"));
        facePictures.put(3, new ImageIcon(wPic));
        faces.put(4,ReelFaces.sevenBlue);
        wPic = ImageIO.read(this.getClass().getResource("Images/4_SEVEN_BLUE.png"));
        facePictures.put(4, new ImageIcon(wPic));
        faces.put(5,ReelFaces.barWhite);
        wPic = ImageIO.read(this.getClass().getResource("Images/5_BAR_WHITE.png"));
        facePictures.put(5, new ImageIcon(wPic));
        faces.put(6,ReelFaces.sevenRed);
        wPic = ImageIO.read(this.getClass().getResource("Images/6_SEVEN_RED.png"));
        facePictures.put(6, new ImageIcon(wPic));
        //System.out.println("successfully populated");
    }

    public void Spin(JLabel foo){ //advances the currentFace of the Reel a random number of times
        int randomNumber = ThreadLocalRandom.current().nextInt(14, 28); //gives a number between 14 & 28

        for(; randomNumber>0;randomNumber--){ //counts down the randomNumber, advancing one face at a time till 0
            //do an "Advance" method in here that updates the image to show it spinning
            currentFaceInt++;
            if(currentFaceInt>6){
                currentFaceInt=0;
            }
            //put the advance method down here
            Advance(foo, currentFaceInt);
            //put something to delay it right here, so there's a moment to observe the "animation"
            //don't use sleep. Either figure out a better way or leave it as is.
        }
        //prototype for the advance method.
        /*
        try {
            BufferedImage wPic = ImageIO.read(this.getClass().getResource("leverUpTemp.png"));
            foo.setIcon(new ImageIcon(wPic));
        } catch (IOException e) {
            System.out.println("Reel.Spin() broke.");
            e.printStackTrace();
        }*/
    }
    public void Advance(JLabel foo, int currentFaceInt) {
        //consider removing the  try/catch and just handling it elsewhere.
        //make 1 icon for each state, dependant upon currentFaceInt
        //hashmap?
        //change the icon  to be whatever it's supposed to be according to that
        switch (currentFaceInt){
            case 0:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(0));

            case 1:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(1));
                break;
            case 2:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(2));
                break;
            case 3:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(3));
                break;
            case 4:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(4));
                break;
            case 5:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(5));
                break;
            case 6:
                //System.out.println("currentFaceInt = " + currentFaceInt);
                foo.setIcon(facePictures.get(6));
                break;
            default:
                System.out.println("Something went wrong with the Reel.Advance() method.");
                break;
        }
        //foo.setIcon(facePictures.get(0));



        /*
        try {
            BufferedImage wPic = ImageIO.read(this.getClass().getResource("Images/leverDownTemp.png"));
            foo.setIcon(new ImageIcon(wPic));
        } catch (IOException e) {
            System.out.println("Reel.Advance() broke.");
            e.printStackTrace();
        }*/
    }

    public ReelFaces getCurrentFace(){ //returns the currentFace
        return faces.get(currentFaceInt);
    }

    //these two are used for determining if diagonals were made
    public ReelFaces getUpFace(){ //returns the face directly above currentFace
        int i = currentFaceInt-1;
        if (i== -1){
            i=6;
        }
        return faces.get(i);
    }
    public ReelFaces getDownFace(){ //returns the face directly below currentFace
        int i = currentFaceInt+1;
        if (i== 7){
            i=0;
        }
        return faces.get(i);
    }
}
