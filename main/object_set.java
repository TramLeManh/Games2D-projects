package main;

import object.object_Key;
import object.object_speedUp;
import object.object_chest;
import object.object_door;

public class object_set {
    GamePanel gp;
    public object_set(GamePanel gp) {
        this.gp = gp;
    }
    public void setup() 
    {
        gp.object[0] = new object_Key();
        gp.object[0].worldX = 25*gp.tileSize;
        gp.object[0].worldY = 10*gp.tileSize;


        gp.object[1] = new object_Key();
        gp.object[1].worldX = 23*gp.tileSize;//23
        gp.object[1].worldY = 42*gp.tileSize;//42

        gp.object[2] = new object_door();
        gp.object[2].worldX = 8*gp.tileSize;
        gp.object[2].worldY = 33*gp.tileSize;

        gp.object[3] = new object_door();
        gp.object[3].worldX = 10*gp.tileSize;
        gp.object[3].worldY = 16*gp.tileSize;

        gp.object[4] = new object_chest();
        gp.object[4].worldX = 10*gp.tileSize;
        gp.object[4].worldY = 13*gp.tileSize;

      

        gp.object[5] = new object_Key();
        gp.object[5].worldX = 38*gp.tileSize;//38
        gp.object[5].worldY = 14*gp.tileSize;//14

        gp.object[6] = new object_door();
        gp.object[6].worldX = 15*gp.tileSize;//23
        gp.object[6].worldY = 26*gp.tileSize;//42

        gp.object[7] = new object_speedUp();
        gp.object[7].worldX = 37*gp.tileSize;//23
        gp.object[7].worldY = 47*gp.tileSize;//42

       
        /*Make a block object Tao 1 vật cản vô hình 16*16 ghi đè phần cần cản gp.object[i].collision */
    }    
}
