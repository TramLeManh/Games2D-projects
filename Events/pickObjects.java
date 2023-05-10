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
    public void set(String objectName, int index) {
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
            if (objectName == "chest") {
                announce1("Victory");
                gp.gamestate = gp.announceState;
                gp.stopMusic();
                gp.playSE("endgame");
                // gp.object[index] = null;
                gp.gameThread = null;
            }
            if (objectName == "speedUp") {
                // gp.gamestate = gp.quizzState;
                // announce("Here is your question");
                // nextState(gp.quizzState);
                set();
                clear();

                
                // teleport(10, 10);
                // clear();
            }
        }


        /**
         * remove the object
        */
        public void clear(){
            gp.object[index] = null;
        }
        public void set(){
            text[0] = "0";
            text[1] = "1";
            text[2] = "2";
        }
        
    }
 
  

