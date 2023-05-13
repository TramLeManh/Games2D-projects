package Events;

import entity.Player;
import main.GamePanel;

public class Quizz_Events extends SuperEvent {
    public Quizz_Events() {
    }
   
    public void ModeSpeed(int i){
        announce("Speed up");
        super.ModeSpeed(5);
    }
    public void setObject(){
        addObject("key",26,45);
    }
    public void correct(){
        if(objectName=="question"){
            if(getObjectIndex()==13||getObjectIndex()==14){
                announce("correct. Please choose a portal to pass");
            }
            else{
                announce("Correct, you can pass");

            }
        }
        

    }
    public void wrong(){
        if(objectName=="question"){
            announce("Wrong, you can not pass");
        }


    }
}
 