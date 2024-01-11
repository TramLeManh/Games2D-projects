package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class portal1 extends SuperObject{
    GamePanel gp;
    public portal1(){
        name = "portal1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/picture/object/portal.png"));
        } catch (Exception e) {
            e.printStackTrace(); 
        } 
        collision = true;
        size = 48;


    }
}
