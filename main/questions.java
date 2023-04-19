package main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.keyControl;
public class questions {
    GamePanel gp;
    Graphics2D g2;
    private int  width,height;
    private keyControl keyBoard;
    public questions(GamePanel gp, keyControl keyBoard) {
        this.gp = gp;
        this.keyBoard = keyBoard;
    }
    private String text;
    public void Quizz(String text){
        this.text = text;
        gp.gamestate =gp.quizzState;
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if(gp.gamestate == gp.quizzState){
            drawScreen(text);
        }
    }
    public void update(){
        if(gp.gamestate == gp.quizzState){
            gp.player.isMove = false;
            if(keyBoard.tPress== true){
                //do something
                System.out.println("t");
                gp.gamestate = gp.playState;
                gp.player.announce("wrong", true);

                gp.player.speed+=1;


            }
            if(keyBoard.fPress== true){
                //do something
                System.out.println("f");
                gp.gamestate = gp.playState;
                gp.player.announce("wrong", true);
                gp.player.announce("Speed up", true);

            }
        }
       
    }
//edit questions
public void drawSubScreen(int x, int y, int width, int height){
        Color color = new Color(0,0,100,100);
        g2.setColor(color);//nền trong
        g2.fillRoundRect(x, y,width ,height,35, 35);
        g2.setColor(Color.white);//viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5,width-10 ,height-10,25, 25);
}
public void drawScreen(String text){
    int x = gp.tileSize *2;
    int y = gp.tileSize /2;
     width = gp.screenWidth - (4*gp.tileSize);
     height = (4*gp.tileSize);
    drawSubScreen(x, y, width, height);

    g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
    x+= gp.tileSize;
    y+= gp.tileSize;
    g2.drawString(text, x, y);
    g2.drawString("press T or F", width-150, height);

}
}
