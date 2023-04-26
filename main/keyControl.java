package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyControl implements KeyListener {
    public boolean upPress, downPress, rightPress, leftPress;
    public boolean tPress, fPress;
    public boolean isFall;
    public boolean isOne, isTwo;
    public boolean pPress;
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
            startState(key_code);
        } else if (gp.gamestate == gp.pauseState) {
            pauseState(key_code);
        } else if (gp.gamestate == gp.playState || gp.gamestate == gp.dialogueState) {
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

        } else if (gp.gamestate == gp.quizzState) {
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

    public void startState(int key_code) {
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

    public void pauseState(int key_code) {
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
}
