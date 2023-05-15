package TextSreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import object.object_Key;

public class playState extends SuperUI{
    public playState(GamePanel gp) {
        super(gp,g2);
    }
    public void draw(Graphics2D g2) { //
        SuperUI.g2 = g2;
        if(gp.gamestate == gp.playState){
            hasKey();
        }
    }
    public void hasKey(){
        Font font = new Font("Arial", Font.PLAIN, 40);
        object_Key key  = new object_Key();
        BufferedImage key_picture = key.image;
        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawImage(key_picture, gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("x " +gp.player.getKey_count(),74,65);// 74 65
    }
}
    
