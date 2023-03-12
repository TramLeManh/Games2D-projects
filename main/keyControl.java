package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class keyControl implements KeyListener {
    public boolean upPress, downPress, rightPress, leftPress;
    public boolean isFall;
    public boolean isOne,isTwo;
    GamePanel gp;
    public boolean isSpace;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();
        if (key_code == KeyEvent.VK_A|| key_code== KeyEvent.VK_LEFT ) {
            leftPress = true;
        }
        if (key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT) {
            rightPress = true;

        }
        if(key_code==KeyEvent.VK_SPACE) {
            isSpace = true;
        }

        if(key_code==KeyEvent.VK_1){
            isOne = true;
        }
        if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
            downPress = true;

        }
        if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = true;
        }
        if(key_code ==KeyEvent.VK_2){
        isTwo =true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();
        if (key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT ) {
            leftPress = false;
        }
        if (key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT) {
            rightPress = false;
        }
        if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
            downPress = false;
        }
        if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = false;
        }
        if(key_code ==KeyEvent.VK_2){
            isTwo = false;
        }
        
        if(key_code==KeyEvent.VK_1){
            isOne = false;
        }
        if(key_code==KeyEvent.VK_SPACE) {
            isSpace = false;
        }

    }

}
