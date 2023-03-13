package object;
import javax.imageio.ImageIO;

import main.GamePanel;
public class object_speedUp extends SuperObject {
    public object_speedUp(){
        name = "speedUp";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/question.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 16*2;

    }
}
