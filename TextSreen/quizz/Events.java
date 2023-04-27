package TextSreen.quizz;

import entity.Player;
import main.GamePanel;

public class Events {
    GamePanel gp;
    Player player;
    public Events(GamePanel gp) { 
        this.gp = gp;
    }
    public void speedUp(int i){
        gp.player.announce("Speed up", true);
        gp.player.speed+=i;
    }
}
