package Events;

import entity.Player;
import main.GamePanel;

public class pickObjects extends SuperEvent{
  
    // private String objectName;
    private String announcements[];
    private GamePanel gp;
    private int index = 0;
    public pickObjects (GamePanel gp)  {
        this.gp = gp;
    }
    public void set(String objectName, int index) {
        this.index = index;
            if (objectName == "key") {
                announce("You got a key",true);
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
                    announce("You do not have enough keys to enter the door ",true);
                }
            }
            if (objectName == "chest") {
                player.announce("Victory", false);
                gp.gamestate = gp.dialogueState;
                gp.stopMusic();
                gp.playSE("endgame");
                // gp.object[index] = null;
                gp.gameThread = null;
            }
            if (objectName == "speedUp") {
                
              
                    gp.gamestate =gp.quizzState;
                    teleport(10, 10);
                    
                    clear();
            }
        }

        public void clear(){
            gp.object[index] = null;

        }
    }
 
  

