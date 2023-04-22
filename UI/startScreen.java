package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;
import main.UI;

public class startScreen extends UI  {
    GamePanel gp;
    Graphics2D g2;
    public startScreen(GamePanel gp, Graphics2D g2) {
       super(gp);
    }
    public void draw(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "My first game";
        int x = LocateCenterText(text);
        int y =gp.tileSize*3;
        g2.setColor(new Color(69, 69, 69));
        g2.drawString(text, x+4, y+4);//draw shadow 
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        //draw image
        g2.drawLine(gp.screenWidth/2, 0, gp.screenWidth/2, gp.screenHeight);
        x = (gp.screenWidth/2)-2*gp.tileSize;
        y += gp.tileSize;
         //
        g2.drawImage(playerImage.get_image(true,"down",1),x, y,gp.tileSize*2,gp.tileSize*2,null);
        x +=2*gp.tileSize;
         //
        g2.drawImage(playerImage.get_image(false,"down",1),x, y,gp.tileSize*2,gp.tileSize*2,null);
    }    
}
