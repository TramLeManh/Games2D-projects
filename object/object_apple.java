package object;
import javax.imageio.ImageIO;

import main.GamePanel;
public class object_apple extends SuperObject {
    public object_apple(){
        name = "apple";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/question.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 35;


    }
}
