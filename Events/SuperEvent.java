package Events;

import java.awt.*;

import entity.Player;
import main.GamePanel;
import object.object_Key;

public class SuperEvent {
    public static GamePanel gp;
    public static  Rectangle eventRectangle;
    private boolean isContinue = false;
    int defultX, defultY;
    private boolean run = true;
    public static Player player;
    public static pickObjects getObjects;
    private int object_index = 30;
    public boolean clear = false;
    protected static String objectName;
    public switchPlayer switchPlayer;
    public static int state = 1;
    public static  String text = " ";
    public static int next_state;
    public static int max_announce;
    public static String annouces[];
    public static boolean isDoll = true;
    private int index = 0;
    public static  boolean teleport = false; 
    public SuperEvent(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
        eventRectangle = new Rectangle();
        eventRectangle.x = 23;
        eventRectangle.y = 23;
        eventRectangle.width = 2;
        eventRectangle.height = 2;
        defultX = eventRectangle.x;
        defultY = eventRectangle.y;
        switchPlayer = new switchPlayer();
        getObjects = new pickObjects();
    }
    public static String getObjectName() {
        return objectName;
    }

    public SuperEvent(GamePanel gp) {
    }

    public void randomEvent() {

    }

    public SuperEvent() {
        super();
    }

    // *list of events */
    /**
    Teleport the player to some where in map
    @param x : locate X
    @param y : locate Y
     */
    public void teleport(int x, int y) {
        gp.playSE("teleport");
        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
        gp.player.direction = "up";
    }
     /**
    Teleport the player to some where in map
    @param x : locate X
    @param y : locate Y
    @param  direction : "up","left","right","down"
     */
    public void teleport(int x, int y,String direction) {
        gp.playSE("teleport");
        gp.player.worldX = x * gp.tileSize;
        gp.player.worldY = y * gp.tileSize;
        gp.player.direction = direction;
    }

    public void pickObjects() {
            index = gp.cCheck.checkObject(player, true);
            if (index != -1) {
                objectName = gp.object[index].name;
                getObjects.set(objectName,index);
            }
    }
   /**
    Modify player Sped
    @param number > 0: increase speed
    @param number < 0: decrease speed
     */
    public void ModeSpeed(int number) {
        gp.player.speed += number;
    }

    public void loseKey() {
        gp.player.setKey_count(gp.player.getKey_count() - 1);
    }
    public void addKey(){
        gp.player.setKey_count(gp.player.getKey_count() + 1);

    }

    public void checkEvent(int worldX, int worldY) {
        musicEvent(23, 20, "sea", "road");
        // switchPlayer.set(worldX, worldY);
        switchPlayer.set(player.worldX, player.worldY);
        if (gp.keyBoard.isSpace == true) {
            setState();
         }
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
    /**
     Add a object in the map
    @param name : object name
    @param x : locate X
    @param y: locate Y
  */
    public void addObject(String name, int x, int y) {
        if (name == "key") {
            gp.object[object_index] = new object_Key();
            gp.object[object_index].worldX = x * gp.tileSize;
            gp.object[object_index].worldY = y * gp.tileSize;
        }
    }
    public void announce(String text) {
        gp.announce.text = text;
        gp.gamestate = gp.announceState;
        gp.player.isMove = false;
    }

    public void continue_announce(String text) {
        this.text = text;
    }


    public void announce1(String text) {
        gp.announce.text = text;
        gp.gamestate = gp.announceState;
        gp.announce.sub_text = " ";
    }
    public void nextState(int states){
        state = states;
    }
    protected void setState(){
            gp.gamestate = state;
            player.isMove = true;        
    }
    public void clear_object(){
        getObjects.clear();
    }
    public int getObjectIndex(){
        return getObjects.getIndex();
    }
    public int Keys(){
        return player.getKey_count();
    }
    public void Key1() {
            gp.object[30] = new object_Key();
            gp.object[30].worldX = 60 * gp.tileSize;
            gp.object[30].worldY = 16 * gp.tileSize;
    }
    public void Key2() {
        gp.object[31] = new object_Key();
        gp.object[31].worldX = 62 * gp.tileSize;
        gp.object[31].worldY = 43 * gp.tileSize;
}
   

        }
        


