package Events;

import entity.Player;
import main.GamePanel;

public class pickObjects extends SuperEvent{
  
    // private String objectName;
    private String announcements[];

    private int index = 0;
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
                    announce("Next");
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
                gp.gamestate = gp.quizzState;
                announce("2");
                announce("3");
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
    }
 
  

