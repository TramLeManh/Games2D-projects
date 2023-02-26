package main;

import object.object_Key;
import object.object_door;

public class object_set {
    GamePanel gp;
    public object_set(GamePanel gp) {
        this.gp = gp;
    }
    public void set_object() 
    {
        gp.object[0] = new object_Key();
        gp.object[0].worldX = 25*gp.tileSize;
        gp.object[0].worldY = 9*gp.tileSize;

        gp.object[1] = new object_door();
        gp.object[1].worldX = 8*gp.tileSize;
        gp.object[1].worldY = 289*gp.tileSize;
 
    }    
}
