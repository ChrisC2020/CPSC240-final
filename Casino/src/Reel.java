import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class Reel {
    private int currentFaceInt=0;
    private HashMap<Integer, ReelFaces> faces = new HashMap<Integer, ReelFaces>();

    public void Populate(){ //puts values into the hashmap so it's not all NULLs
        faces.put(0, ReelFaces.barBlue);
        faces.put(1,ReelFaces.sevenWhite);
        faces.put(2,ReelFaces.cherry);
        faces.put(3,ReelFaces.barRed);
        faces.put(4,ReelFaces.sevenBlue);
        faces.put(5,ReelFaces.barWhite);
        faces.put(6,ReelFaces.sevenRed);
    }

    public void Spin(){ //advances the currentFace of the Reel a random number of times
        int randomNumber = ThreadLocalRandom.current().nextInt(14, 28); //gives a number between 14 & 28

        for(; randomNumber>0;randomNumber--){ //counts down the randomNumber, advancing one face at a time till 0
            //do an "Advance" method in here that updates the image to show it spinning
            currentFaceInt++;
            if(currentFaceInt>6){
                currentFaceInt=0;
            }
        }
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
