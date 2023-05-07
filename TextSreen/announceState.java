package TextSreen;

import java.awt.Graphics2D;

import main.GamePanel;

public class announceState extends SuperUI{
    public boolean getKey = false;
    public announceState(GamePanel gp) {
        super(gp,g2);
        sub_text = "Press space to continue";
        word_length = 150;
        
    }
    public void draw(Graphics2D g2) { //
        this.g2 = g2;
        if(gp.gamestate == gp.announceState){
            drawScreen();
            if(gp.eventH.getObjectName()=="key"){
                g2.drawString("+1 key", gp.player.screenX+40, gp.player.screenY);
            }
        }
        
    }
}
