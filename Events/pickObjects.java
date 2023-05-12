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
    public pickObjects ()  {
    }  
    public void set(String objectName,int index){ 
        this.index = index;
            if (objectName == "key") {
                announce("You got a key");
                gp.playSE("coin");
                // gp.playSE(1);
                player.setKey_count(player.getKey_count()+1);
                clear();
            }
            if (objectName == "door") {
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
            if(objectName == "prince"&&index ==5){
                // announce("Victory");
                // gp.stopMusic();
                // gp.playMusic("endgame");
                // gp.gameThread = null;
                // gp.gamestate = gp.quizzState;
                System.out.println("2");
                gp.gamestate = gp.quizzState;
            }
            if(objectName == "question"){
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
    
    }
 
  

