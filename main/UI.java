package main;
import java.awt.*;
public class UI {
    GamePanel gp;
    Graphics2D g2;
    public String text = " ";

    public UI(GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        if(gp.gamestate == gp.dialogueState){
            drawScreen(text);
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
        g2.drawString(text, x, y);;

    }
    public void drawSubScreen(int x, int y, int width, int height){
        Color color = new Color(0,0,100,100);
        g2.setColor(color);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);

        g2.setColor(Color.white);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);

}
}
