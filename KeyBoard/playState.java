package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class playState extends keyBoard{

    public playState(GamePanel gp) {
        super(gp);
        //TODO Auto-generated constructor stub
    }
    public boolean upPress, downPress, rightPress, leftPress;
    public boolean tPress, fPress;
    public boolean isFall;
    public boolean isOne, isTwo;
    public boolean pPress;
    public boolean isSpace;


    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();

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
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();
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
     
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
