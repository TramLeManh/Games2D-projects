package Events;

import KeyBoard.playState;
import entity.Player;
import main.GamePanel;

public class pickObjects extends SuperEvent{
  
    // private String objectName;
    private String announcements[];
    public String[] text = new String[10];
    private int index = 0;
    private int next_state; 
    private String name;
    public  boolean chest_temp = false;

    public pickObjects ()  {
    }  
    public void set(String objectName,int index){ 
        this.index = index;
            if (objectName == "key") {
                if(index == 23){
                    gp.playSE("coin");
                    announce("This is a fake key :))");
                    clear();
                }
                else{
                announce("You got a key");
                gp.playSE("coin");
                // gp.playSE(1);
                player.setKey_count(player.getKey_count()+1);
                clear();}
            }
            if (objectName == "door") {
                if(index == 26||index ==27)
                if (player.getKey_count() > 0) {
                    gp.playSE(3);
                    // gp.object[index] = null;
                    player.setKey_count(player.getKey_count()-1);     
                    clear();          
                } else{
                    announce("You do not have enough keys to enter the door ");
                    nextState(gp.playState);
                }
            }
            
            if (index == 0||index == 1||index == 2) {
                teleport(18, 37);
                clear();
            }
            if(index == 3){
                teleport(49, 16);
                clear();
            }
            if(index == 4){
                teleport(59, 8);
                clear();
            }
            if(objectName == "prince"){
                if(index ==5){
                announce("Victory");
                gp.stopMusic();
                gp.playMusic("endgame");
                gp.gameThread = null;
                // System.out.println("2");
                // gp.gamestate = gp.quizzState; 
            }
                if(index ==24){
                    announce("This a fake princess. She is somewhere in the world.");
                        addObject("portal", 77, 6,35);
                        clear();
              
            }

        }
                if(index ==25){
                    announce("You got a chess prince. Here is your prize.");
                    chest_temp = true;
                }
            if(objectName == "question"){
                gp.gamestate = gp.quizzState;
           }
            if(objectName == "portal"){
                if(index == 15){//29 79
                    teleport(44, 62,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 16){//29 79
                    teleport(44, 71,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 17){//29 79
                    teleport(44,80,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 18){//29 79
                    teleport(70,74,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 19){//29 79
                    teleport(56,64,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 20){//29 79
                    teleport(65,74,"right");
                    System.out.println(getObjectIndex());
                }
                if(index == 35){
                    teleport(14,62,"down");
                }
            
            }
            if(objectName=="oldman"){
                if(Keys()==0&&gp.object[27]!=null){
                announce("Hello, there is something in the lava");
                Key2();
            }
                if(Keys()==0&&gp.object[27]==null){
                    announce("It's a lovely day");

                }
            if((gp.object[31]==null)&&(gp.object[30]==null)&&Keys()==1){
                announce("You again. Here is a key and speed up. Go find princess");
                addKey();
                ModeSpeed(2);
            }
            if(Keys()==1&&(gp.object[30]==null)){
                announce("find your princess");
            }
            if(Keys()==1&&isDoll==false){
               announce("Here is some power"); 
               ModeSpeed(2);
        }}
        if(objectName=="doll"){
            if(isDoll==true){
                gp.gamestate = gp.quizzState;
            }
            else if(isDoll==false){
                announce("I can not help you anymore.");
            }
        }
        if(objectName=="monster"){
            gp.gamestate = gp.quizzState;
        }
        }


        /**
         * remove the object
        */
        
        public void set(){
            text[0] = "0";
            text[1] = "1";
            text[2] = "2";
        }
        public  void clear(){
            gp.object[index] = null;
        }
       public int getIndex() {
           return index;
       }
       public String getName() {
           return name;
       }
       
       public void add_portal(){

       }    
    }
 
  

