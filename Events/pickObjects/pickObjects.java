package Events.pickObjects;

import Events.SuperEvent;
import KeyBoard.keyControl;

public class pickObjects extends SuperEvent {

    public String[] text = new String[10];
    private int index = 0;
    private String name;
    public boolean chest_temp = false;
    private int x;
    private int y;
    private boolean haveToothpaste = false;
    private oldman oldman =  new oldman();

    public pickObjects() {
    }

    public void set(String objectName, int index) {
        this.index = index;
        if (objectName == "key") {
            if (index == 23) {
                gp.playSE("coin");
                announce("This is a fake key :))");
                clear();

            } else if (index == 37) {
                gp.playSE("coin");

                announce("This is cures key. Not the real one :))). Here its curse");
                setTeleport(39, 24);
                clear();

            } else {
                announce("You got a key");
                gp.playSE("coin");
                // gp.playSE(1);
                player.setKey_count(player.getKey_count() + 1);
                clear();
            }
        } else if (objectName == "door") {
            if (index == 26 || index == 27)
                if (player.getKey_count() > 0) {
  
                    gp.playSE("unlock");
                    // gp.object[index] = null;
                    player.setKey_count(player.getKey_count() - 1);
                    clear();
                } else {
                    announce("You do not have enough keys to enter the door ");

                    nextState(gp.playState);
                }
            if (index == 34) {
                if (Keys() < 2) {
                    announce("You need two keys to unlock the door");
                }
                if (Keys() == 2) {
                    gp.playSE("unlock");
                    clear();
                    loseKey();
                    loseKey();
                }
            }
        }

        else if (index == 0 || index == 1 || index == 2) {
            teleport(18, 37);
        }
        if (index == 3) {
            teleport(49, 16);
            clear();
        }
        if (index == 4) {
            teleport(59, 8);
            clear();
        } else if (objectName == "prince") {
            if (index == 5) {
                announce("Victory");
                gp.stopMusic();
                gp.playMusic("endgame");
                gp.gameThread = null;
                // System.out.println("2");
            }
            else if (index == 24) {
                announce("This a fake princess. She is somewhere in the world.");
                addObject("portal", 77, 6, 35);
                gp.playSE("clear");
                clear();

            } 

        } else if (objectName == "chest") {
            if (index == 25) {
                announce("You got a princess's chest. Here is your prize.");
                gp.playSE("chest");
                setTeleport(51, 29);
                clear();
            }

            if (index == 33) {
                announce("You got a toothpaste");
                gp.playSE("chest");

                haveToothpaste = true;
                clear();
            }
            if (index == 39) {
                gp.playSE("chest");
                announce("You have got a dark magic that makes you lose speed");
                ModeSpeed(-1);
                clear();
            }
            if (index == 38) {
                if (Keys() == 1||(Keys()==0&&(gp.object[31]==null||gp.object[29]==null))) {
                    if (player.speed == 3) {
                        announce("You got a key and buff up");
                        gp.playSE("powerUp");  
                        ModeSpeed(+1); 
                        addKey();
                        clear();
                    } else if (player.speed == 4) {
                        announce("You got a key");
                        gp.playSE("chest");
                        addKey();
                        clear();
                    }
                } else if (Keys() == 2) {
                    if (player.speed == 3&&gp.object[32]==null) {
                        announce("You got a buff up");
                        ModeSpeed(+1);
                        gp.playSE("powerUp");
                        clear();
                    } else if (player.speed == 4) {
                        gp.playSE("chest");
                        announce("There is nothing inside the chess");
                        clear();
                    }
                }
                else if(Keys()==0&&(gp.object[31]!=null&&gp.object[29]!=null)){
                    if(player.speed ==3&&gp.object[36]==null){
                        announce("You got a buff up");
                        gp.playSE("powerUp");
                        ModeSpeed(+1);
                        clear();
                    }
                    else{
                        announce("There is nothing inside the chess");
                        clear();
                    }
                   
                }
            }
        }

        else if (objectName == "question") {
            gp.setGamestate(gp.quizzState);
        } else if (objectName == "portal") {
            if (index == 15) {// 29 79
                teleport(44, 62, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 16) {// 29 79
                teleport(44, 71, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 17) {// 29 79
                teleport(44, 80, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 18) {// 29 79
                teleport(70, 74, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 19) {// 29 79
                teleport(56, 64, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 20) {// 29 79
                teleport(65, 74, "right");
                System.out.println(getObjectIndex());
            }
            if (index == 35) {
                teleport(14, 62, "down");
            }

        } else if (objectName == "oldman"&&player.direction == "right") {
            // if (index == 32) {
            //     if (!haveToothpaste) {
            //         announce("I lost the toothpaste. Can you please find it ?");
            //     } else {
            //         if (player.speed == 4) {
            //             announce("Thank you. Have a nice day.");
            //             gp.playSE("clear");
            //             clear();
            //         }
            //         else if (player.speed == 3) {
            //             announce("Thank you. Here is spped power as gift");
            //             ModeSpeed(1);
            //             gp.playSE("clear");
            //             clear();
            //         }
            //         else if (player.speed == 2&&gp.object[42]!=null) {
            //             announce("Thank you. Here is spped power as gift");
            //             ModeSpeed(1);
            //             gp.playSE("clear");
            //             clear();
            //         }
            //     }

            // } else {
            //     if (Keys() == 0 && gp.object[27] != null) {
            //         announce("Hello, there is something in the lava");
            //         Key2();
            //     }
            //     if (Keys() == 0 && gp.object[27] == null) {
            //         announce("It's a lovely day");

            //     }
            //     if ((gp.object[41] == null) && (gp.object[42] == null) && Keys() == 1) {
            //         announce("You again. Here is a key and speed up. Go find princess");
            //         addKey();
            //         ModeSpeed(2);
            //     }
            //     if (Keys() == 1 && (gp.object[42] == null)) {
            //         announce("find your princess");
            //     }
            //     if (Keys() == 1 && isDoll == false) {
            //         announce("Here is some power");
            //         ModeSpeed(2);
            //     }
            // }
            oldman.set(this,index);
        } else if (objectName == "doll") {
            if (isDoll == true) {
                gp.setGamestate( gp.quizzState);
            } else if (isDoll == false) {
                announce("I can not help you anymore.");
            }
        } else if (objectName == "monster") {
            announce("Hello,You have to answer my question to pass me");
            nextState(gp.quizzState);
        } else if (objectName == "apple") {
            if (index == 36) {
                if (gp.object[38] != null) {
                    if (player.speed == 4) {
                        announce("Loose speed");
                        gp.playSE("powerDown");
                        ModeSpeed(-1);
                        clear();
                    }
    
                        else if (player.speed == 3) {
                            announce("Here your ehance");
                            ModeSpeed(+1);
                            gp.playSE("powerUp");
                            clear();
                        }             
                       }
                if (gp.object[38] == null) {
                    announce("It is a good apple");
                    gp.playSE("coin");
                    clear();
                }

            } else  {
                announce("Speed up \n abc");
                gp.playSE("powerUp");
                ModeSpeed(+1);
                clear();
            }
        }

    }

    /**
     * remove the object
     */

    public void set() {
        text[0] = "0";
        text[1] = "1";
        text[2] = "2";
    }

    public void clear() {
        gp.object[index] = null;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void add_portal() {

    }

    public void teleport() {
        super.teleport(x, y, "right");
    }

    public void setTeleport(int x, int y) {
        this.x = x;
        this.y = y;
        teleport = true;
    }

    public void nextTeleport() {
        if (keyControl.isSpace && teleport == true) {
            teleport();
            teleport = false;
        }
    }
    public void setHaveToothpaste(boolean haveToothpaste) {
        this.haveToothpaste = haveToothpaste;
    }
    public boolean isHaveToothpaste() {
        return haveToothpaste;
    }
    
}
