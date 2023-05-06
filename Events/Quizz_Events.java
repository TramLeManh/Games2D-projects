package Events;

import entity.Player;
import main.GamePanel;

public class Quizz_Events extends SuperEvent {
    public Quizz_Events() {
    }
   
    public void ModeSpeed(int i){
        announce("Speed up", true);
        super.ModeSpeed(5);
    }
    public void setObject(){
        announce("There is something on the water may help you....", true);
        addObject("key",26,45);
    }
}
 