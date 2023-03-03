package main;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Color;
public class a {
    GamePanel gp;
    public a(GamePanel gp){
        this.gp = gp;
        get_image();
    }
    BufferedImage image;
    public void get_image(){
        try {
            image =  ImageIO.read(getClass().getResourceAsStream("/picture/tri.png"));
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
    public void draw(Graphics2D g) {
        g.drawImage(image,0,0,16*48, 12*48,null);
    }
}
