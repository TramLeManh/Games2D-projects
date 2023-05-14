package Events;

import entity.Player;
import main.GamePanel;

public class Quizz_Events extends SuperEvent {
    private int x;
    private int y;
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
                clear_object();

            }
        }
        if(objectName=="doll"){
            if(Keys()>-1){
                announce("Correct. There is something may help you in the North pool");
                Key1();
                isDoll = false;
            }
        }
        

    }
    public void wrong(){
        if(objectName=="question"){
            announce("Wrong, you can not pass");
        }
        if(objectName=="doll"){
            if(Keys()== 0){
                announce("Wrong. Here is suprised for you");
                setTeleport(52, 29);
            }
            if(Keys()==1){
                announce("Wrong and go away. I will take your key as punnish");
                loseKey();
                setTeleport(52, 29);


            }
        }
    }
    public void teleport() {
        super.teleport(x, y,"right");
    }
    public void setTeleport(int x, int y){
        this.x = x;
        this.y = y;
        teleport = true;
    }
}
 