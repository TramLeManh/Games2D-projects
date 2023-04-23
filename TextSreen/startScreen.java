package TextSreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entity.choosePlayer;
import main.GamePanel;

public class startScreen {

    GamePanel gp;
    Graphics2D g2;
    public choosePlayer playerImage = new choosePlayer();
    public int command;
  
    public startScreen(GamePanel gp) {
        this.gp = gp;
        
    }

 
    private void setArrow(int x, int y) {
     
    
                g2.drawString(">", x - gp.tileSize, y);
           
         
        }

    public void display(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "My first game";
        int x = LocateCenterText(text);
        int y = gp.tileSize * 3;
        g2.setColor(new Color(69, 69, 69));
        g2.drawString(text, x + 4, y + 4);// draw shadow
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        // draw image
        // g2.drawLine(gp.screenWidth / 2, 0, gp.screenWidth / 2, gp.screenHeight);
        x = (gp.screenWidth / 2) - 2 * gp.tileSize;
        y += gp.tileSize;
        //
        g2.drawImage(playerImage.get_image(true, "down", 1), x, y, gp.tileSize * 2, gp.tileSize * 2, null);
        x += 2 * gp.tileSize + 5;
        //
        g2.drawImage(playerImage.get_image(false, "down", 2), x, y, gp.tileSize * 2, gp.tileSize * 2, null);
        menu(g2, x, y);
    }
    private int LocateCenterText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }

    private void menu(Graphics2D g2, int x, int y) {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        String text = "START GAME";
        x = LocateCenterText(text);
        y += gp.tileSize * 3.5;
        g2.drawString(text, x, y);
        if(command == 0){
                   g2.drawString(">", x - gp.tileSize, y);
        }

        text = "INSTRUCTIONS";
        x = LocateCenterText(text);
        y += gp.tileSize;
        if(command == 1){
                   g2.drawString(">", x - gp.tileSize, y);
        }


        g2.drawString(text, x, y);

        text = "ABOUT";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 2){
                   g2.drawString(">", x - gp.tileSize, y);
        }
        text = "QUIT";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 3){
                   g2.drawString(">", x - gp.tileSize, y);
        }

    }
   
}
