package object;
import javax.imageio.ImageIO;

import main.GamePanel;
public class object_question extends SuperObject {
    public object_question(){
        name = "question";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/question.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = 16*2;
        collision = true;

    }
}