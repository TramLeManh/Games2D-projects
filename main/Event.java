package main;
import java.awt.*;

public class Event {
    GamePanel gp;
    Rectangle eventRectangle;
    int defultX,defultY;

   
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
    public void checkEvent() {
        
    }
    public boolean hit(int eventCol, int eventRow,String direction){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRectangle.x = eventCol*gp.tileSize + eventRectangle.x;
        eventRectangle.y = eventRow*gp.tileSize + eventRectangle.y;
        if(gp.player.solidArea.intersects(eventRectangle)){
            if(gp.player.direction.contentEquals(direction)){
                hit = true;
            }
        }
        eventRectangle.x  = defultX;
        eventRectangle.y = defultY;
        return hit;
    }
}
