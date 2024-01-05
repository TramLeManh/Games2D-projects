package object;

import main.GamePanel;

public class object_set {
    GamePanel gp;
    public object_set(GamePanel gp) {
        this.gp = gp;
    }
    public void setup() 
    {
       
        // add(new object_potion2(),"p2",10,37,true);
        // add(new object_potion2(),"p3",13,39,true);
        // add(new object_potion2(),"p4",13,39,true);

        add(new prince(),"prince1",81,67);
        add(new prince(),"decoy",77,8);
        add(new object_Key(),"key123",12,13);
        add(new portal(),"p123",108,2);

        gp.object[0] = new object_door();
        gp.object[0].worldX = 12*gp.tileSize;
        gp.object[0].worldY = 35*gp.tileSize;

         add(new object_door(),"p1",12,35,false);

        gp.object[0].collision = false;

        gp.object[1] = new object_potion2();
        gp.object[1].worldX = 10*gp.tileSize;
        gp.object[1].worldY = 37*gp.tileSize;

        // gp.object[2] = new object_potion2();
        // gp.object[2].worldX = 13*gp.tileSize;
        // gp.object[2].worldY = 39*gp.tileSize;

        // gp.object[3] = new object_potion2();
        // gp.object[3].worldX = 50*gp.tileSize;
        // gp.object[3].worldY = 8*gp.tileSize;

        // gp.object[4] = new object_potion2();
        // gp.object[4].worldX = 71*gp.tileSize;
        // gp.object[4].worldY = 8*gp.tileSize;

        // gp.object[5] = new prince ();
        // gp.object[5].worldX = 81*gp.tileSize;
        // gp.object[5].worldY = 67*gp.tileSize;
        add(new object_question(),53,71);
        add(new object_question(),58,71);
         add(new object_question(),63,71);
         add(new object_question(),59,74);
           add(new object_question(),62,74);
        add(new object_question(),67,74);
        add(new object_question(),72,74);
        add(new object_question(),30,84);
        add(new object_question(),32,84);
        // gp.object[6] = new object_question();
        // gp.object[6].worldX = 53*gp.tileSize;
        // gp.object[6].worldY = 71*gp.tileSize;

        // gp.object[7] = new object_question();
        // gp.object[7].worldX = 58*gp.tileSize;
        // gp.object[7].worldY = 71*gp.tileSize;

        // gp.object[8] = new object_question();
        // gp.object[8].worldX = 63*gp.tileSize;
        // gp.object[8].worldY = 71*gp.tileSize;

        // gp.object[9] = new object_question();
        // gp.object[9].worldX = 59*gp.tileSize;
        // gp.object[9].worldY = 74*gp.tileSize;

        // gp.object[10] = new object_question();
        // gp.object[10].worldX = 62*gp.tileSize;
        // gp.object[10].worldY = 74*gp.tileSize;

        
      

 


        //79
        gp.object[15] = new portal();
        gp.object[15].worldX = 75*gp.tileSize;
        gp.object[15].worldY = 8*gp.tileSize;

        
        gp.object[16] = new portal();
        gp.object[16].worldX = 31*gp.tileSize;
        gp.object[16].worldY = 79*gp.tileSize;

        
        gp.object[17] = new portal();
        gp.object[17].worldX = 33*gp.tileSize;
        gp.object[17].worldY = 79*gp.tileSize;

        gp.object[18] = new portal();
        gp.object[18].worldX = 57*gp.tileSize;
        gp.object[18].worldY = 82*gp.tileSize;

        gp.object[19] = new portal();
        gp.object[19].worldX = 62*gp.tileSize;
        gp.object[19].worldY = 82*gp.tileSize;

        gp.object[20] = new portal();
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
        gp.object[23].worldY = 16*gp.tileSize;

        // gp.object[24] = new prince();
        // gp.object[24].worldX = 77*gp.tileSize;
        // gp.object[24].worldY = 8*gp.tileSize;

        gp.object[25] = new object_chest();
        gp.object[25].worldX = 79*gp.tileSize;
        gp.object[25].worldY = 10*gp.tileSize;

        gp.object[26] = new object_door();
        gp.object[26].worldX = 77*gp.tileSize;
        gp.object[26].worldY = 11*gp.tileSize;

        gp.object[27] = new object_door();
        gp.object[27].worldX = 77*gp.tileSize;
        gp.object[27].worldY = 28*gp.tileSize;

        gp.object[28] = new monster();//66 13
        gp.object[28].worldX = 89*gp.tileSize;
        gp.object[28].worldY = 62*gp.tileSize;

        gp.object[29] = new object_Key();
        gp.object[29].worldX = 12*gp.tileSize;
        gp.object[29].worldY = 37*gp.tileSize;

        gp.object[30] = new apple();//66 13
        gp.object[30].worldX = 9*gp.tileSize;
        gp.object[30].worldY = 37*gp.tileSize;

        gp.object[31] = new object_Key();
        gp.object[31].worldX = 34*gp.tileSize;
        gp.object[31].worldY = 33*gp.tileSize;

        gp.object[32] = new oldman();
        gp.object[32].worldX = 28*gp.tileSize;
        gp.object[32].worldY = 27*gp.tileSize;

        gp.object[33] = new object_chest();
        gp.object[33].worldX = 28*gp.tileSize;
        gp.object[33].worldY = 38*gp.tileSize;

        gp.object[34] = new object_door();
        gp.object[34].worldX = 50*gp.tileSize;
        gp.object[34].worldY = 29*gp.tileSize;

        
        gp.object[35] = new monster();
        gp.object[35].worldX = 44*gp.tileSize;
        gp.object[35].worldY = 31*gp.tileSize;

        gp.object[36] = new apple();
        gp.object[36].worldX = 47*gp.tileSize;
        gp.object[36].worldY = 15*gp.tileSize;

        gp.object[37] = new object_Key();
        gp.object[37].worldX = 49*gp.tileSize;
        gp.object[37].worldY = 15*gp.tileSize;

        gp.object[38] = new object_chest();
        gp.object[38].worldX = 51*gp.tileSize;
        gp.object[38].worldY = 15*gp.tileSize;

        gp.object[39] = new object_chest();
        gp.object[39].worldX = 26*gp.tileSize;
        gp.object[39].worldY = 40*gp.tileSize;

        SuperObject a =new object_chest();
        
        gp.object[39] = a;
        gp.object[39].worldX = 26*gp.tileSize;
        gp.object[39].worldY = 40*gp.tileSize;
        add(new object_Key(),"key1",15,13, true);
    }   

    //SuperObject là các array object inherited superObject
    public  void add(SuperObject object,String name,int x,int y,boolean collision){
        int index = hashFunc(name);
        gp.object[index] = object;
        gp.object[index].worldX = x*gp.tileSize;//location x
        gp.object[index].worldY = y*gp.tileSize; //location x
        gp.object[index].collision = collision; //isCollision ?
    } 

    public  void add(SuperObject object,String name,int x,int y){
        int index = hashFunc(name);
        gp.object[index] = object;
        gp.object[index].worldX = x*gp.tileSize;
        gp.object[index].worldY = y*gp.tileSize;
        
    } 
     public  void add(SuperObject object,int x,int y){
        int index = checkCollision(object.name);
        gp.object[index] = object;
        gp.object[index].worldX = x*gp.tileSize;
        gp.object[index].worldY = y*gp.tileSize;
    } 
    public  int hashFunc(String input){
        int sum = 0;
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           sum += (int) c;
       }
       return (sum % 999);
   }

   public int checkCollision(String input){
    int index  = hashFunc(input);
    while(gp.object[index] != null){
        index +=1;
   }
   return index;
}
}