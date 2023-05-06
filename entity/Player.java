package entity;

import main.GamePanel;
import object.object_Key;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Events.pickObjects;
import KeyBoard.keyControl;

public class Player extends Entity {
    choosePlayer chooseSprite = new choosePlayer();
    private boolean transfer = false;
    public  int screenX;
    public  int screenY;
    private int Key_count = 0;
    public boolean isMove = true;
    private String objectName;
    private int object_index = 20;

    GamePanel gp;
    public keyControl keyBoard;
    public int global_index = 0;

    public Player(GamePanel gp, keyControl keyBoard) {
        this.gp = gp;
        this.keyBoard = keyBoard;
        DefultValues();
        
        setDefultValues();

    }
    public void DefultValues() {
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 10;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void setDefultValues() {
        worldX = gp.tileSize * 24;
        worldY = gp.tileSize * 41;
        speed = 3;
        direction = "down";
        transfer = false; 
      
    }
    public void update() {
        gp.eventH.checkEvent(worldX, worldY);
        //keyBoard player
        if (keyBoard.isSpace == true) {
            gp.gamestate = gp.playState;
            isMove = true;
            System.out.println("x: " + worldX / 48 + "y: " + worldY / 48);
        }
        if((gp.gamestate==gp.dialogueState||gp.gamestate==gp.playState)){
            if(keyBoard.pPress==true){
                gp.gamestate = gp.pauseState;
                gp.stopMusic();
            }
        }
      


        // movements
        if (isMove) {
            if (keyBoard.downPress == true || keyBoard.upPress == true || keyBoard.rightPress
                    || keyBoard.leftPress == true) {
                if (keyBoard.upPress == true) {
                    direction = "up";
                } else if (keyBoard.downPress == true) {
                    direction = "down";
                } else if (keyBoard.rightPress == true) {
                    direction = "right";
                } else if (keyBoard.leftPress == true) {
                    direction = "left";
                }
                // check collision

                collisionEnabled = false;

                gp.cCheck.checkTile(this);

                // object collision
                spriteCounter++;
                // gp.eventH.checkEvent();
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
    }
    public void draw(Graphics2D g) {
        BufferedImage images = chooseSprite.get_image(transfer, direction, spriteNum);
        g.drawImage(images, screenX, screenY, null);
    }
    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
    public boolean getTransfer() {
        return this.transfer;
    }
    public void setKey_count(int key_count) {
        Key_count = key_count;
    }
    public void reset(){
        gp.tilesM.tile[2].collision = true;//water
        gp.tilesM.tile[6].collision = false;//lava
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 3;
        direction = "down";
        Key_count = 0;
        isMove = true;
        transfer = false;
        gp.gamestate = gp.playState;
    }
    

  
    //set get
    public int getKey_count() {
        return Key_count;
    }
    public String getObjectName() {
        return objectName;
    }
    public void announce(int index,boolean isSpace) {
        gp.ui.setSpace(isSpace);
        gp.ui.text = announcements[index];
        gp.gamestate = gp.dialogueState;
        gp.player.isMove = false;
        if (objectName == "key") {
            gp.ui.setGetKey(true);
        }

    }
    public void announce(String text, boolean isSpace) {
        gp.ui.setSpace(isSpace);
        gp.ui.text = text;
        gp.gamestate = gp.dialogueState;
        gp.player.isMove = false;
        if (objectName == "key") {
            gp.ui.setGetKey(true);
        }
    }
}
