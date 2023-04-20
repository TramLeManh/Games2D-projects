package entity;

import main.GamePanel;
import main.keyControl;
import object.object_Key;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    choosePlayer chooseSprite = new choosePlayer();
    private boolean transfer = false;
    public final int screenX;
    public final int screenY;
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
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        // solid
        setDefultValues();
        SetAnnouncements();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 10;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
    public boolean getTransfer() {
        return this.transfer;
    }
    public void SetAnnouncements() {
        announcements[0] = "You hit water,please change character";
        announcements[1] = "You got a key";
        announcements[2] = "speed up";

    }

    public void announce(int index,boolean isSpace) {
        gp.ui.setSpace(isSpace);
        gp.ui.text = announcements[index];
        gp.gamestate = gp.dialogueState;
        isMove = false;
        if (objectName == "key") {
            gp.ui.setGetKey(true);
        }

    }

    public void announce(String text, boolean isSpace) {
        gp.ui.setSpace(isSpace);
        gp.ui.text = text;
        gp.gamestate = gp.dialogueState;
        isMove = false;
        if (objectName == "key") {
            gp.ui.setGetKey(true);
        }
    }

    public void setDefultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 3;
        direction = "down";
    }

    public void update() {
        gp.eventH.checkEvent();

        if (keyBoard.isSpace == true) {
            gp.gamestate = gp.playState;
            isMove = true;
            System.out.println("x: " + worldX / 48 + "y: " + worldY / 48);
        }
        gp.eventH.switchPlayer(worldX, worldY);
        // if (keyBoard.isOne == true) {
        //     transfer = false;
        //     System.out.println("x" + (gp.player.worldX + gp.player.solidArea.x) + " y"
        //             + (gp.player.worldY + gp.player.solidArea.y));
        //     gp.tilesM.tile[2].collision = true;
        //     gp.tilesM.tile[6].collision = false;
        //     //prevent user to transfer when in lava
        //     if (worldY > 319 && worldY < 560) {
        //         transfer = true;
        //         gp.tilesM.tile[2].collision = false;
        //     }
        // }
      
        // if (keyBoard.isTwo == true) {
        //     transfer = true;
        //     gp.tilesM.tile[2].collision = false;
        //     gp.tilesM.tile[6].collision = true;
        //                 //prevent user to transfer when in pool

        //     if (worldY > 560 && worldY < 848 && worldX > 1720) {
        //         transfer = false;
        //         gp.tilesM.tile[6].collision = false;

        //     }
        // }
        gp.eventH.setAnnouncement();
        // detect text when collide river

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
                int index = gp.cCheck.checkObject(this, true);

                pickupObject(index);

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

    public void pickupObject(int index) {
        if (index != -1) {
            objectName = gp.object[index].name;
            if (objectName == "key") {
                announce(1,true);
                gp.playSE("coin");
                // gp.playSE(1);
                ++Key_count;
                gp.object[index] = null;

            }
            if (objectName == "door") {
                if (Key_count > 0) {
                    gp.playSE(3);
                    gp.object[index] = null;
                    --Key_count;

                } else {
                    announce("You do not have enough keys to enter the door",true);
                }
            }

            if (objectName == "chest") {
                announce("Victory", false);
                gp.gamestate = gp.dialogueState;
                gp.stopMusic();
                gp.playSE("endgame");
                gp.object[index] = null;
                gp.gameThread = null;

            }
            if (objectName == "speedUp") {
                   
               gp.eventH.teleport(23, 23);
                // announce(2,true);
                // gp.playSE(2);
                gp.object[index] = null;
                // gp.quizz.Quizz("Minh đẹp trai");
            }

        }
    }
    private void addObject(String name,int x,int y){
        object_index++;
        if(name == "key"){
            gp.object[object_index] = new object_Key();
            gp.object[object_index].worldX = x * gp.tileSize;
            gp.object[object_index].worldY = y * gp.tileSize;
        }
    }

    public void draw(Graphics2D g) {
        BufferedImage images = chooseSprite.get_image(transfer, direction, spriteNum);
        g.drawImage(images, screenX, screenY, null);
    }
    public int getKey_count() {
        return Key_count;
    }
    public String getObjectName() {
        return objectName;
    }
}
