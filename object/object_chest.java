package object;
import javax.imageio.ImageIO;
public class object_chest extends SuperObject {
    public object_chest(){
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/chest.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
