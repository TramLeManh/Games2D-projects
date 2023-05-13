package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class object_door extends SuperObject{
    GamePanel gp;
    public object_door(){
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/portal.png"));
        } catch (Exception e) {
            e.printStackTrace(); 
        } 
        collision = true;
        size = 48;


    }
}
