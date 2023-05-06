package KeyBoard;

import java.awt.event.KeyEvent;

public class playState extends keyControl implements KeyBoard {

    @Override
    public void keyPressed(int key_code) {
        if (key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT) {
            leftPress = true;
        }
        if (key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT) {
            rightPress = true;
        }
        if (key_code == KeyEvent.VK_SPACE) {
            isSpace = true;
        }

        if (key_code == KeyEvent.VK_1) {
            isOne = true;
        }
        if (key_code == KeyEvent.VK_P) {
            pPress = true;
        }
        if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
            downPress = true;

        }
        if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = true;
        }
        if (key_code == KeyEvent.VK_2) {
            isTwo = true;
        }
    }

    @Override
    public void keyReleased(int key_code) {
        if (key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT) {
            leftPress = false;
        }
        if (key_code == KeyEvent.VK_P) {
            pPress = false;
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
        if (key_code == KeyEvent.VK_2) {
            isTwo = false;
        }
        if (key_code == KeyEvent.VK_1) {
            isOne = false;
        }
        if (key_code == KeyEvent.VK_SPACE) {
            isSpace = false;
        }
        if (key_code == KeyEvent.VK_F) {
            fPress = false;
        }
        if (key_code == KeyEvent.VK_T) {
            tPress = false;
        }
    }
    
}
