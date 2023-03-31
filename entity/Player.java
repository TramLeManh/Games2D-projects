package entity;

import main.GamePanel;
import main.keyControl;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    choosePlayer chooseSprite = new choosePlayer();
    public boolean transfer = false;
    public final int screenX;
    public final int screenY;
    private int Key_count = 0;
    private boolean isMove = true;

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
    public void SetAnnouncements() {
        announcements[0] = "You hit water,please change character";
        announcements[1] ="You got a key";
        announcements[2] = "speed up";
        
    }
    public void announce(int index) {
        gp.ui.text = announcements[index];
        gp.gamestate =gp.dialogueState;
        isMove = false;
        
    }
    public void announce(String text){
        gp.ui.text = text;
        gp.gamestate =gp.dialogueState;
        isMove = false;
    }

    public void setDefultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 4;
        direction = "down";
    }
    public void update() {
        if(keyBoard.isSpace==true) {
            gp.gamestate =gp.playState;
            isMove = true;
        }
        if (keyBoard.isOne == true) {  
            transfer = false;
            System.out.println("x" + (gp.player.worldX+gp.player.solidArea.x) + " y" +  (gp.player.worldY+gp.player.solidArea.y));
            gp.tilesM.tile[2].collision = true;
            gp.tilesM.tile[6].collision = false;
                   
                        if(worldY>319&&worldY<560 ){
                        transfer = true;
                        gp.tilesM.tile[2].collision = false;
                    }
        }
        // if(keyBoard.upPress == true&&gp.eventH.checkPlace()&&transfer ==  false){
        //     gp.eventH.collisionAnnouce();
        // }
        // else if(keyBoard.downPress||keyBoard.rightPress||keyBoard.leftPress||transfer ==true){
        //     gp.gamestate = gp.playState;
        // }
        if (keyBoard.isTwo == true) {
            transfer = true;
            gp.tilesM.tile[2].collision = false;
            gp.tilesM.tile[6].collision = true;
            
            if(worldY>560&&worldY<848&&worldX>1720){
                transfer = false;
                gp.tilesM.tile[6].collision = false;

            }
        }
        gp.eventH.setAnnouncement();
        //detect text when collide river

       
        gp.eventH.checkEvent();


        //movements
        if(isMove){

        if (keyBoard.downPress == true || keyBoard.upPress == true || keyBoard.rightPress|| keyBoard.leftPress == true) {
            if ( keyBoard.upPress == true) {
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

            //object collision
            int index = gp.cCheck.checkObject(this, true);

            pickupObject(index);

            spriteCounter++;
            gp.eventH.checkEvent();
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
            if (spriteCounter > 4) {
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
       
        if(index != -1){
        String objectName = gp.object[index].name;
        if(objectName == "key"){
           announce(1);
            gp.playSE(1);
            // gp.playSE(1);
            ++Key_count;
            gp.object[index] =  null;

        }
        if(objectName=="door"){
            if(Key_count>0){
                gp.playSE(3);
                gp.object[index] =  null;
                --Key_count;
            }
            else{
                announce("Can not enter door");
            }          
        }
        
        if(objectName == "chest"){
            gp.ui.text ="Victory";
            gp.gamestate =gp.dialogueState;
            gp.stopMusic();
            gp.playSE(4);
            gp.object[index] = null;
           
            gp.gameThread = null; 

        }
        if(objectName == "speedUp"){
            announce(2);
            gp.playSE(2);
            gp.object[index] = null;
            speed+=1;
        }
        }
    }
   

    public void draw(Graphics2D g) {
        BufferedImage images = chooseSprite.get_image(transfer, direction, spriteNum);
        g.drawImage(images,screenX, screenY,null);
    }
}   
