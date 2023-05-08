package object;

import main.GamePanel;

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


        // gp.object[1] = new object_Key();
        // gp.object[1].worldX = 23*gp.tileSize;//23
        // gp.object[1].worldY = 42*gp.tileSize;//42

        gp.object[2] = new object_door();
        gp.object[2].worldX = 22*gp.tileSize;
        gp.object[2].worldY = 32*gp.tileSize;

        gp.object[3] = new object_door();
        gp.object[3].worldX = 10*gp.tileSize;
        gp.object[3].worldY = 16*gp.tileSize;

        gp.object[4] = new object_chest();
        gp.object[4].worldX = 10*gp.tileSize;
        gp.object[4].worldY = 13*gp.tileSize;

      

        gp.object[5] = new object_Key();
        gp.object[5].worldX = 18*gp.tileSize;//38
        gp.object[5].worldY = 19*gp.tileSize;//14

        gp.object[6] = new object_door();
        gp.object[6].worldX = 15*gp.tileSize;//23
        gp.object[6].worldY = 26*gp.tileSize;//42

        gp.object[7] = new object_speedUp();
        gp.object[7].worldX = 37*gp.tileSize;//23
        gp.object[7].worldY = 47*gp.tileSize;//42

        gp.object[8] = new object_speedUp();
        gp.object[8].worldX = 24*gp.tileSize;//23
        gp.object[8].worldY = 42*gp.tileSize;//42

        gp.object[9] = new object_doll();
        gp.object[9].worldX = 20*gp.tileSize;
        gp.object[9].worldY = 36*gp.tileSize;

        gp.object[10] = new object_squid();
        gp.object[10].worldX = 22*gp.tileSize;
        gp.object[10].worldY = 36*gp.tileSize;

        gp.object[11] = new object_potion1();
        gp.object[11].worldX = 23*gp.tileSize;
        gp.object[11].worldY = 36*gp.tileSize;

        gp.object[12] = new object_potion2  ();
        gp.object[12].worldX = 24*gp.tileSize;
        gp.object[12].worldY = 36*gp.tileSize;
       
        /*Make a block object Tao 1 vật cản vô hình 16*16 ghi đè phần cần cản gp.object[i].collision */
    }    
}