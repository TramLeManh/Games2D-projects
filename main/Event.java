package main;

import java.awt.*;

public class Event {
    GamePanel gp;
    Rectangle eventRectangle;
    int defultX, defultY;
    private boolean run = true;

    public Event(GamePanel gp) {
        this.gp = gp;
        eventRectangle = new Rectangle();
        eventRectangle.x = 23;
        eventRectangle.y = 23;
        eventRectangle.width = 2;
        eventRectangle.height = 2;
        defultX = eventRectangle.x;
        defultY = eventRectangle.y;
    }
    public void randomEvent(){

    }

    public void teleport(int x, int y) {
        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
    }
    public void ModeSpeed(int number){
        gp.player.speed += number;
    }



    public void checkEvent() {
        musicEvent(23, 20, "sea", "road");
    }

    private void musicEvent(int x, int y, String music_up, String music_down) {
        if (hit(x, y, "up") && run) {
            gp.stopMusic();
            gp.playMusic(music_up);
            run = false;
        } else if (hit(x, y, "down") && !run) {
            gp.stopMusic();
            gp.playMusic(music_down);
            run = true;
        }
    }
  
    private boolean hit(int eventCol, int eventRow, String direction) {
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRectangle.x = eventCol * gp.tileSize + eventRectangle.x;
        eventRectangle.y = eventRow * gp.tileSize + eventRectangle.y;
        if (gp.player.solidArea.intersects(eventRectangle)) {
            if (gp.player.direction.contentEquals(direction)) {
                hit = true;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRectangle.x = defultX;
        eventRectangle.y = defultY;
        return hit;
    }

    private boolean checkPlace(int index) {
        switch (index) {
            case 1:
                if (hit(38, 18, "up")) {
                    return true;
                }
                break;
            case 2:

                if (hit(23, 12, "up") ||
                        hit(21, 12, "up") ||
                        hit(22, 12, "up") ||
                        hit(24, 12, "up") ||
                        hit(25, 12, "up")) {
                    return true;
                }
                break;
        }
        return false;

    }

    public void setAnnouncement() {
        if (gp.eventH.checkPlace(1)) {
            if (gp.player.keyBoard.upPress == true && gp.player.transfer == true) {
                gp.ui.text = "You can not pass lava. Please change character";
                gp.gamestate = gp.dialogueState;
            } else if (gp.player.keyBoard.downPress || gp.player.keyBoard.rightPress || gp.player.keyBoard.leftPress
                    || !gp.player.transfer || gp.player.keyBoard.isOne) {
                gp.gamestate = gp.playState;
            }
        }
        if (gp.eventH.checkPlace(2)) {
            if (gp.player.keyBoard.upPress == true && gp.player.transfer == false) {
                gp.ui.text = "You can not pass river. Please change character";
                gp.gamestate = gp.dialogueState;
            } else if (gp.player.keyBoard.downPress || gp.player.keyBoard.rightPress || gp.player.keyBoard.leftPress
                    || gp.player.transfer || gp.player.keyBoard.isTwo) {
                gp.gamestate = gp.playState;
            }
        }

    }

}
