package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyControl implements KeyListener {
    public boolean upPress, downPress, rightPress, leftPress;
    public boolean tPress, fPress;
    public boolean isFall;
    public boolean isOne, isTwo;
    GamePanel gp;
    public boolean isSpace;

    public keyControl(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();
        if (gp.gamestate == gp.startState) {
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
                }
                else if(key_code == KeyEvent.VK_SPACE){
                    gp.ui.startScreen.drawSubScreen = true;
                    gp.ui.startScreen.pause = true;

                }
            }
            else if(key_code == KeyEvent.VK_SPACE&&gp.ui.startScreen.pause){
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

       

        else {
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
            if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
                downPress = true;

            }
            if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
                upPress = true;
            }
            if (key_code == KeyEvent.VK_2) {
                isTwo = true;
            }
            if (key_code == KeyEvent.VK_F) {
                fPress = true;
            }
            if (key_code == KeyEvent.VK_T) {
                tPress = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();
        if (key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT) {
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
