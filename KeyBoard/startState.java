package KeyBoard;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;


public class startState implements KeyBoard  {
    private GamePanel gp;
    public startState(GamePanel gp) {
        this.gp = gp;
    }
    

    public void keyPressed(int key_code) {
        if (!gp.ui.startScreen.pause) {
            if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
                gp.ui.startScreen.command--;
                if (gp.ui.startScreen.command < 0) {
                    gp.ui.startScreen.command = 3;
                }
            }
            if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
                gp.ui.startScreen.command++;
                if (gp.ui.startScreen.command > 3) {
                    gp.ui.startScreen.command = 0;
                }
            }
            if (gp.ui.startScreen.command == 0 && key_code == KeyEvent.VK_SPACE) {
                gp.gamestate = gp.playState;
                gp.playMusic("road");
            } else if (key_code == KeyEvent.VK_SPACE) {
                gp.ui.startScreen.drawSubScreen = true;
                gp.ui.startScreen.pause = true;

            }
        } else if (key_code == KeyEvent.VK_SPACE && gp.ui.startScreen.pause) {
            gp.ui.startScreen.drawSubScreen = false;
            gp.ui.startScreen.pause = false;
        }
        if (gp.ui.startScreen.drawSubScreen) {
            if (gp.ui.startScreen.command == 3) {
                if (key_code == KeyEvent.VK_Y) {
                    System.exit(0);
                }
                if (key_code == KeyEvent.VK_N) {
                    gp.ui.startScreen.command = 0;
                    gp.ui.startScreen.drawSubScreen = false;
                }
            }

        }
    
    }


    public void keyReleased(int key_code) {
    }

   
    
}
