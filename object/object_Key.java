package object;
import javax.imageio.ImageIO;

import main.GamePanel;
public class object_Key extends SuperObject{
    public object_Key(){
        name = "key";    
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/key.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        text = "You got a key";
        detection = true;
    }
 
   
}
