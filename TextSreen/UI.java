package TextSreen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import Font.Fonts;
import entity.choosePlayer;
import main.GamePanel;
import object.object_Key;
public class UI {
    GamePanel gp;
    Graphics2D g2;
    private BufferedImage key_picture;
    private boolean isSpace;
    private boolean getKey;
    public int startCommand = 0;
    public choosePlayer playerImage = new choosePlayer();
    public Fonts font = new Fonts();
    public startScreen startScreen  ;
    public pauseScreen pauseScreen;

    public String text = " ";
    private Font font_text;
    private boolean looseKey = false;
    public UI(GamePanel gp){
        this.gp = gp;
        startScreen  = new startScreen(gp);
        pauseScreen = new pauseScreen(gp);
        font_text = font.getFont();
        //   try{
        //     InputStream file = getClass().getResourceAsStream("/Font/a.ttf");
        //     font_text =  Font.createFont(Font.TRUETYPE_FONT, file);
           
           

        // }catch(FontFormatException e){
        //     e.printStackTrace();
        // }catch(IOException e){
        //     e.printStackTrace();
        // }      
        
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
        g2.setFont(font_text);
       
        if(gp.gamestate == gp.dialogueState){
            drawScreen(text);
            getKey();
        }
        else if(gp.gamestate == gp.playState){
            hasKey();
            getKey = false;
        }

    }
    public void getKey(){
        if(getKey){
            g2.setFont(font_text);
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
        g2.setColor(Color.black);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);

        g2.setColor(Color.white);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);
}
    public int LocateCenterText(String text)
    {
        int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2-length/2; 
        return x;
    }
}
