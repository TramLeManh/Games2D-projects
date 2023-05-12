package object;

import main.GamePanel;

public class object_set {
    GamePanel gp;
    public object_set(GamePanel gp) {
        this.gp = gp;
    }
    public void setup() 
    {
        gp.object[0] = new object_potion1();
        gp.object[0].worldX = 12*gp.tileSize;
        gp.object[0].worldY = 35*gp.tileSize;

        gp.object[1] = new object_potion2();
        gp.object[1].worldX = 10*gp.tileSize;
        gp.object[1].worldY = 37*gp.tileSize;

        gp.object[2] = new object_potion2();
        gp.object[2].worldX = 13*gp.tileSize;
        gp.object[2].worldY = 39*gp.tileSize;

        gp.object[3] = new object_potion2();
        gp.object[3].worldX = 50*gp.tileSize;
        gp.object[3].worldY = 8*gp.tileSize;

        gp.object[4] = new object_potion2();
        gp.object[4].worldX = 71*gp.tileSize;
        gp.object[4].worldY = 8*gp.tileSize;

        gp.object[5] = new prince ();
        gp.object[5].worldX = 81*gp.tileSize;
        gp.object[5].worldY = 67*gp.tileSize;

        gp.object[6] = new object_question();
        gp.object[6].worldX = 53*gp.tileSize;
        gp.object[6].worldY = 71*gp.tileSize;

        gp.object[7] = new object_question();
        gp.object[7].worldX = 58*gp.tileSize;
        gp.object[7].worldY = 71*gp.tileSize;

        gp.object[8] = new object_question();
        gp.object[8].worldX = 63*gp.tileSize;
        gp.object[8].worldY = 71*gp.tileSize;

        gp.object[9] = new object_question();
        gp.object[9].worldX = 59*gp.tileSize;
        gp.object[9].worldY = 74*gp.tileSize;

        gp.object[10] = new object_question();
        gp.object[10].worldX = 62*gp.tileSize;
        gp.object[10].worldY = 74*gp.tileSize;

        
        gp.object[11] = new object_question();
        gp.object[11].worldX = 67*gp.tileSize;
        gp.object[11].worldY = 74*gp.tileSize;

        gp.object[12] = new object_question();
        gp.object[12].worldX = 72*gp.tileSize;
        gp.object[12].worldY = 74*gp.tileSize;







     
    }    
}