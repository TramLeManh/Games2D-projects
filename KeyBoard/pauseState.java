package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class pauseState extends keyBoard {

    public pauseState(GamePanel gp) {
        super(gp);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();
        if (!gp.ui.pauseScreen.pause) {
            if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
                gp.ui.pauseScreen.command--;
                if (gp.ui.pauseScreen.command < 0) {
                    gp.ui.pauseScreen.command = 3;
                }
            }
            if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
                gp.ui.pauseScreen.command++;
                if (gp.ui.pauseScreen.command > 3) {
                    gp.ui.pauseScreen.command = 0;
                }
            }
            if (gp.ui.pauseScreen.command == 0 && key_code == KeyEvent.VK_SPACE) {
                gp.gamestate = gp.playState;/* //dk choi nhac lại khi chuyển vùng */
            } else if (key_code == KeyEvent.VK_SPACE) {
                gp.ui.pauseScreen.drawSubScreen = true;
                gp.ui.pauseScreen.pause = true;

            }
        } else if (key_code == KeyEvent.VK_SPACE && gp.ui.pauseScreen.pause) {
            gp.ui.pauseScreen.drawSubScreen = false;
            gp.ui.pauseScreen.pause = false;
        }
        if (gp.ui.pauseScreen.drawSubScreen) {
            if (gp.ui.pauseScreen.command == 3 || gp.ui.pauseScreen.command == 1) {
                if (key_code == KeyEvent.VK_Y) {
                    if (gp.ui.pauseScreen.command == 3) {
                        System.exit(0);
                    } else {
                        gp.map.reset();
                        gp.gamestate = gp.playState;
                        gp.ui.pauseScreen.drawSubScreen = false;
                        gp.ui.pauseScreen.command = 0;
                        gp.ui.pauseScreen.pause = false;
                    }
                }
                if (key_code == KeyEvent.VK_N) {
                    gp.ui.pauseScreen.command = 0;
                    gp.ui.pauseScreen.drawSubScreen = false;
                    gp.ui.pauseScreen.pause = false;
                }
            }

        }
    }
        

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
