package main;
import java.awt.*;
import java.awt.image.BufferedImage;

import entity.choosePlayer;
import object.object_Key;
public class UI {
    GamePanel gp;
    Graphics2D g2;
    private BufferedImage key_picture;
    private boolean isSpace;
    private boolean getKey;
    private choosePlayer playerImage = new choosePlayer();;

    public String text = " ";
    private boolean looseKey = false;
    public UI(GamePanel gp){
        this.gp = gp;
    }
    public void setSpace(boolean isSpace) {
        this.isSpace = isSpace;
    }
    public void setLooseKey(boolean looseKey) {
        this.looseKey = looseKey;
    }
    public void setGetKey(boolean getKey) {
        this.getKey = getKey;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        if(gp.gamestate == gp.dialogueState){
            drawScreen(text);
            getKey();
           
        }
        if(gp.gamestate == gp.playState){
            hasKey();
            getKey = false;
        }
        if(gp.gamestate == gp.startState){
            startScreen();
        }
    }
    public void startScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "My first game";
        int x = LocateCenterText(text);
        int y =gp.tileSize*3;
        g2.setColor(new Color(69, 69, 69));
        g2.drawString(text, x+4, y+4);//draw shadow 
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        //draw image
        x = gp.screenWidth/2-gp.tileSize;
        y += gp.tileSize*2;
         //
        g2.drawImage(playerImage.get_image(true,"down",1),x, y,gp.tileSize*2,gp.tileSize*2,null);
        x = gp.screenWidth/2+gp.tileSize;
         //
        g2.drawImage(playerImage.get_image(false,"down",1),x, y,gp.tileSize*2,gp.tileSize*2,null);
    }
    public void getKey(){
        if(getKey){
            Font font = new Font("Arial", Font.BOLD, 15);
            g2.setFont(font);
            g2.setColor(Color.black);
            g2.drawString("+1 key", gp.player.screenX+40, gp.player.screenY);
        }
    }
    public void drawScreen(String text){
        int x = gp.tileSize *2;
        int y = gp.tileSize /2;
        int width = gp.screenWidth - (4*gp.tileSize);
        int height = (4*gp.tileSize);
        drawSubScreen(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        if(isSpace){
            g2.drawString("press space to continue", width-150, height);

        }

    }
    // g2.drawString("x " +gp.player.getKey_count(), gp.player.screenX+40, gp.player.screenY);// 74 65

    public void hasKey(){
        Font font = new Font("Arial", Font.PLAIN, 40);
        object_Key key  = new object_Key();
        key_picture = key.image;
        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawImage(key_picture, gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("x " +gp.player.getKey_count(),74,65);// 74 65
    }
    public void drawSubScreen(int x, int y, int width, int height){
        Color color = new Color(0,0,100,100);
        g2.setColor(color);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);

        g2.setColor(Color.white);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);
}
    private int LocateCenterText(String text)
    {
        int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2-length/2; 
        return x;
    }
}
