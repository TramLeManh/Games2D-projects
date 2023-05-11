package TextSreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entity.choosePlayer;
import main.GamePanel;

public class startScreen implements UI_interface {
    public boolean pause = false;
    GamePanel gp;
    Graphics2D g2;
    public choosePlayer playerImage = new choosePlayer();
    public int command;
    public boolean drawSubScreen;
  
    public startScreen(GamePanel gp) {
        this.gp = gp;
        
    }
    private String screen_text;

 
    private void setArrow(int x, int y) {
     
    
                g2.drawString(">", x - gp.tileSize, y);

        }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if(drawSubScreen){
            if(command == 3){
                drawScreen1(screen_text);
            }else{
                drawScreen(screen_text);
                pause = true;
            }
        }
        else{
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
                   g2.drawString("<", x + 7*gp.tileSize, y);

        }

        text = "INSTRUCTIONS";
        x = LocateCenterText(text);
        y += gp.tileSize;
        if(command == 1){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x + 8*gp.tileSize, y);
                   screen_text = "Instruction";

                }


        g2.drawString(text, x, y);

        text = "ABOUT";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 2){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x +4*gp.tileSize, y);
                   screen_text = "About";

        }
        text = "QUIT";
        x = LocateCenterText(text);
        y +=gp.tileSize;
        g2.drawString(text, x, y);
        if(command == 3){
                   g2.drawString(">", x - gp.tileSize, y);
                   g2.drawString("<", x +3*gp.tileSize, y);
                   screen_text = "Are you sure want to quit?";
        }
    }
    public void drawScreen(String text){
        int x = gp.tileSize *2;
        int y = gp.tileSize /2;
        int width = gp.screenWidth - (4*gp.tileSize);
        int height = (11*gp.tileSize);//11
        drawSubScreen(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        // x+= gp.tileSize;
        x = LocateCenterText(text);
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        // g2.drawImage(playerImage.get_image(true, "down", 1), width,height,null);
        g2.setColor(Color.black);
        g2.drawRect(48*2+20,y+10,gp.screenWidth - (4*gp.tileSize)-40 , height-110);
        

        g2.drawString("press space to continue", width-150, height);

    }
    public void drawScreen1(String text){
        int x = gp.tileSize *2;
        int y = gp.tileSize *3;
        int width = gp.screenWidth - (4*gp.tileSize);
        int height = (4*gp.tileSize);
        drawSubScreen(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        g2.drawString("(Y/N)", width, height+100);
    }
    
    public void drawSubScreen(int x, int y, int width, int height){
        Color color = new Color(0,0,100,100);
        g2.setColor(color);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);

        g2.setColor(Color.white);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);
}}

   