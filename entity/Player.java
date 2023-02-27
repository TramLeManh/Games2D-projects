package entity;

import main.GamePanel;
import main.keyControl;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Player extends Entity {
    choosePlayer choosePlayer = new choosePlayer();
    private boolean transfer = false;
    public final int screenX;
    public final int screenY;
    private boolean run;
    private int Key_count = 0;
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

    public Player(GamePanel gp, keyControl keyBoard) {
        this.gp = gp;
        this.keyBoard = keyBoard;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        // solid
        setDefultValues();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }

    public void setDefultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 4;
        direction = "down";
    }
    public void update() {
        if (keyBoard.isTwo == true) {
            transfer = true;
            gp.tilesM.tile[2].collision = false;
            gp.tilesM.tile[6].collision = true;

            System.out.println("x: " + worldX + " y: " + worldY);
            if(worldY<800){
                transfer = false;
                gp.tilesM.tile[6].collision = false;

            }
        }
        if (keyBoard.isOne == true) {            
            transfer = false;
            gp.tilesM.tile[2].collision = true;
            gp.tilesM.tile[6].collision = false;
                    if(worldY<320+5*gp.tileSize){
                        transfer = true;
                        gp.tilesM.tile[2].collision = false;
                    }
        }
        if (keyBoard.downPress == true || keyBoard.upPress == true || keyBoard.rightPress|| keyBoard.leftPress == true) {
            if ( keyBoard.upPress == true) {
                direction = "up";
            } else if (keyBoard.downPress == true) {
                direction = "down";
            } else if (keyBoard.rightPress == true) {
                direction = "right";
            } else if (keyBoard.leftPress == true) {
                direction = "left";
            } else if (keyBoard.spacePress == true) {
                System.out.println("worldX: " + worldX + "Y: " + worldY);
            }
            // check collision
            collisionEnabled = false;
            gp.cCheck.checkTile(this);
            //object collision
            int index = gp.cCheck.checkObject(this, true);
            pickupObject(index);
            spriteCounter++;
            // if collision
            if (collisionEnabled == false) {
                if (direction == "up") {
                    worldY -= speed;
                }
                if (direction == "down") {
                    worldY += speed;
                }
                if (direction == "right") {
                    worldX += speed;
                }
                if (direction == "left") {
                    worldX -= speed;
                }
            }
            if (spriteCounter > 5) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void pickupObject(int index) {
        if(index != -1){
        String objectName = gp.object[index].name;
        if(objectName == "key"){
            gp.playSE(1);
            ++Key_count;
            gp.object[index] =  null;

        }
        if(objectName=="door"){
            if(Key_count>0){
                gp.playSE(3);
                gp.object[index] =  null;
                --Key_count;
            }
          
        }
        if(objectName == "chest"){
            gp.object[index] = null;
            gp.gameThread = null;

        }
        }
    }

    // public void getplayerImage() {
    //     try {
    //         up1 = ImageIO.read(getClass().getResource("/picture/boy_up_1.png"));
    //         up2 = ImageIO.read(getClass().getResource("/picture/boy_up_2.png"));
    //         down1 = ImageIO.read(getClass().getResource("/picture/boy_down_1.png"));
    //         down2 = ImageIO.read(getClass().getResource("/picture/boy_down_2.png"));
    //         left1 = ImageIO.read(getClass().getResource("/picture/boy_left_1.png"));
    //         left2 = ImageIO.read(getClass().getResource("/picture/boy_left_2.png"));
    //         right1 = ImageIO.read(getClass().getResource("/picture/boy_right_1.png"));
    //         right2 = ImageIO.read(getClass().getResource("/picture/boy_right_2.png"));
    //         tri = ImageIO.read(getClass().getResource("/picture/tri.png"));
    //         door = ImageIO.read(getClass().getResource("/picture/door.png"));

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    // }

    public void draw(Graphics2D g) {
        BufferedImage image = choosePlayer.get_image(transfer, direction, spriteNum);
        
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                    g.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

                }


    }
}
