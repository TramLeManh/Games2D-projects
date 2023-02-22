package entity;

import main.GamePanel;
import main.keyControl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Player extends Entity{
    public final int screenX;
    public final int screenY;
    private boolean run;
    GamePanel gp;
    keyControl keyBoard;
    private BufferedImage up1;
    private BufferedImage up2;
    private BufferedImage down1;
    private BufferedImage left2;
    private BufferedImage left1;
    private BufferedImage down2;
    private BufferedImage right1;
    private BufferedImage right2;
    private BufferedImage tri;
    private BufferedImage door;
    public Player(GamePanel gp,keyControl keyBoard){
        this.gp = gp;
        this.keyBoard = keyBoard;
        setDefultValues();
        getplayerImage();
        screenX = gp.screenWidth/2-(gp.tileSize/2);
         screenY = gp.screenHeight/2-(gp.tileSize/2);
    }
    public void setDefultValues() {
        worldX   = gp.tileSize*23;
        worldY   = gp.tileSize*23;
        speed = 4;
        direction = "down";
    }
    public void update() {
        if(keyBoard.downPress==true||keyBoard.upPress== true||keyBoard.rightPress||keyBoard.leftPress==true){
            if(keyBoard.upPress==true&&worldY>0){
                direction = "up";
                worldY -= speed;
            }
            else if(keyBoard.downPress==true&&worldY<gp.screenHeight-gp.tileSize){
                worldY += speed;
                direction = "down";
            }
            else if (keyBoard.rightPress==true&&worldX<gp.screenWidth-gp.tileSize) {
                worldX += speed;
                direction = "right";
            }
            else if (keyBoard.leftPress==true&&worldX>0) {
                worldX -= speed;
                direction = "left";
    
            }
            else if(keyBoard.spacePress ==true){
                System.out.println("worldX: "+worldX+"worldY: " +worldY);
            }
          
            spriteCounter++;
            if(spriteCounter>5){
                if(spriteNum ==1){
                    spriteNum = 2;
                }
                else if(spriteNum ==2){
                    spriteNum =1;
                }
                spriteCounter = 0;
            }
        }
      

        
    }
    public void getplayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResource("/picture/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResource("/picture/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResource("/picture/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResource("/picture/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResource("/picture/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResource("/picture/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResource("/picture/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResource("/picture/boy_right_2.png"));
            tri    = ImageIO.read(getClass().getResource("/picture/tri.png"));
            door    = ImageIO.read(getClass().getResource("/picture/door.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public void draw(Graphics2D g) {
        BufferedImage image = null;
        if(direction == "up"){
            if(spriteNum==1){
                image = up1;
            }
            if(spriteNum==2){
                image = up2;
            }
        }
        else if(direction == "down"){
            if(spriteNum==1){
                image = down1;
            }
            if(spriteNum==2){
                image = down2;
            }
        }
        else if(direction == "right"){
            if(spriteNum ==1){
                image = right1;
            }
            if(spriteNum ==2){
                image = right2;
            }
        }
        else if(direction=="left"){
            if(spriteNum==1){
                image = left1;
            }
            if(spriteNum==2){
                image = left2;
            }             
        }

        g.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);

       
    }
}
