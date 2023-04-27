package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class quizzState extends keyBoard {
    public quizzState(GamePanel gp) {
        super(gp);
    }

    public boolean tPress, fPress;


    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();

        if (key_code == KeyEvent.VK_F) {
            fPress = true;
        }
        if (key_code == KeyEvent.VK_T) {
            tPress = true;
        }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();
        // TODO Auto-generated method stub
        if (key_code == KeyEvent.VK_F) {
            fPress = false;
        }
        if (key_code == KeyEvent.VK_T) {
            tPress = false;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
