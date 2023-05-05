package Events;

import java.awt.*;

import entity.Player;
import main.GamePanel;

public class Event {
    GamePanel gp;
    Rectangle eventRectangle;
    int defultX, defultY;
    private boolean run = true;
    private Player player;
    private pickObjects getObjects;
    private switchPlayer switchPlayer;


    public Event(GamePanel gp,Player player) {
        this.gp = gp;
        eventRectangle = new Rectangle();
        eventRectangle.x = 23;
        eventRectangle.y = 23;
        eventRectangle.width = 2;
        eventRectangle.height = 2;
        defultX = eventRectangle.x;
        defultY = eventRectangle.y;
        getObjects = new pickObjects(gp,player);
        switchPlayer = new switchPlayer(gp,this);
    }
    public void randomEvent(){

    }
    //*list of events */
    public void teleport(int x, int y) {
        gp.playSE("teleport");
        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
        gp.player.direction = "up";
    }
    public void ModeSpeed(int number){
        gp.player.speed += number;
    }
    public void loseKey(){
        gp.player.setKey_count(gp.player.getKey_count()-1);

    }
    public void checkEvent(int worldX, int worldY) {
        musicEvent(23, 20, "sea", "road");
        getObjects.set();
        switchPlayer.set(worldX,worldY);
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
    private void looseKey(){
        if(gp.eventH.hit(14,26, "left")) {
            gp.ui.setLooseKey(false);
        }
    }
    public boolean hit(int eventCol, int eventRow, String direction) {
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

   
}
