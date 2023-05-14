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

        //
        gp.object[13] = new object_question();
        gp.object[13].worldX = 30*gp.tileSize;
        gp.object[13].worldY = 84*gp.tileSize;

        gp.object[14] = new object_question();
        gp.object[14].worldX = 32*gp.tileSize;
        gp.object[14].worldY = 84*gp.tileSize;
        

        //79
        gp.object[15] = new object_door();
        gp.object[15].worldX = 29*gp.tileSize;
        gp.object[15].worldY = 79*gp.tileSize;

        
        gp.object[16] = new object_door();
        gp.object[16].worldX = 31*gp.tileSize;
        gp.object[16].worldY = 79*gp.tileSize;

        
        gp.object[17] = new object_door();
        gp.object[17].worldX = 33*gp.tileSize;
        gp.object[17].worldY = 79*gp.tileSize;

        gp.object[18] = new object_door();
        gp.object[18].worldX = 57*gp.tileSize;
        gp.object[18].worldY = 82*gp.tileSize;

        gp.object[19] = new object_door();
        gp.object[19].worldX = 62*gp.tileSize;
        gp.object[19].worldY = 82*gp.tileSize;

        gp.object[20] = new object_door();
        gp.object[20].worldX = 67*gp.tileSize;
        gp.object[20].worldY = 82*gp.tileSize;

        gp.object[21] = new object_doll();//witch
        gp.object[21].worldX = 35*gp.tileSize;
        gp.object[21].worldY = 51*gp.tileSize;

        gp.object[22] = new oldman();//witch
        gp.object[22].worldX = 83*gp.tileSize;
        gp.object[22].worldY = 44*gp.tileSize;

        gp.object[23] = new object_Key();
        gp.object[23].worldX = 63*gp.tileSize;
        gp.object[23].worldY = 16*gp.tileSize;//fake key

        










     
    }    
}