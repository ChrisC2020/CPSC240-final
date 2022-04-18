import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Ball {

    private Image ball;

    public Ball(){
        try{
            ball = ImageIO.read(new File("RouletteBall.png"));
        } catch (Exception e) {
            ball = null;
        }
    }
}
