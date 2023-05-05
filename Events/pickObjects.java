package Events;

import entity.Player;
import main.GamePanel;

public class pickObjects {
    private GamePanel gp;
    private Player player;
    private String objectName;
    private String announcements[];
    public pickObjects(GamePanel gp,Player player) {
        this.gp = gp;
        // SetAnnouncements();
        this.player = player;

    }
    public void set() {
        int index = gp.cCheck.checkObject(player, true);
        if (index != -1) {
            objectName = gp.object[index].name;
            if (objectName == "key") {
                player.announce("You got a key",true);
                gp.playSE("coin");
                // gp.playSE(1);
                player.setKey_count(player.getKey_count()+1);;
                gp.object[index] = null;

            }
            if (objectName == "door") {
                if (player.getKey_count() > 0) {
                    gp.playSE(3);
                    gp.object[index] = null;
                    player.setKey_count(player.getKey_count()-1);               
                } else {
                    player.announce("You do not have enough keys to enter the door",true);
                }
            }
            if (objectName == "chest") {
                player.announce("Victory", false);
                gp.gamestate = gp.dialogueState;
                gp.stopMusic();
                gp.playSE("endgame");
                gp.object[index] = null;
                gp.gameThread = null;
            }
            if (objectName == "speedUp") {
            //    gp.eventH.teleport(23, 23);
                // announce(2,true);
                // gp.playSE(2);
                gp.object[index] = null;
                gp.gamestate =gp.quizzState;
            }

        }
    }
 
  
}
