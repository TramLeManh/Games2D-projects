package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class object_apple extends SuperObject {
    public object_apple(){
        name = "apple";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/apple.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
