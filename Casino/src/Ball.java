import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ball extends JComponent {

    private BufferedImage ball;
    private int width;
    private int height;

    public Ball(){
        try{
            ball = ImageIO.read(new File("Images/RouletteBall.png"));
            width = 20;
            height = 20;
        } catch (Exception e) {
            ball = null;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(ball, width, height, null);
    }

}
