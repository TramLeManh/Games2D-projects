package Events ;

import main.GamePanel;

public class switchPlayer extends SuperEvent{
    public switchPlayer() {
    }
    private boolean checkPlace(int index) {
        switch (index) {
            case 1:
                if (hit(32, 27, "right")) {
                    return true;
                }
                break;
            case 2:

                if (hit(40, 34, "down") ||
                hit(39, 34, "down") ||
                hit(22, 12, "up") ||
                hit(24, 12, "up") ||
                hit(25, 35, "right")) {
                    return true;
                }
                break;
        }
        return false;

    }
/* need update code */
    public void setAnnouncement() {
        if (checkPlace(1)) {
            if (gp.player.keyBoard.rightPress == true && gp.player.getTransfer() == true) {
        
                announce("You can not pass lava. Please change character");
            } else if ( gp.player.keyBoard.rightPress || gp.player.keyBoard.leftPress
                    || !gp.player.getTransfer() || gp.player.keyBoard.isOne) {
                gp.gamestate = gp.playState;
            }
        }
        if (checkPlace(2)) {
            if (gp.player.keyBoard.rightPress == true && gp.player.getTransfer() == false) {
            
                announce("You can not pass river. Please change character");

                gp.gamestate = gp.announceState;
            } else if (gp.player.keyBoard.rightPress || gp.player.keyBoard.leftPress
                    || gp.player.getTransfer() || gp.player.keyBoard.isTwo) {
                gp.gamestate = gp.playState;
            }
        }

    }
    public void set(int worldX,int worldY){
        setAnnouncement();
        if (gp.keyBoard.isOne == true) {
            gp.player.setTransfer(false);
            System.out.println("x" + (gp.player.worldX + gp.player.solidArea.x) + " y"
                    + (gp.player.worldY + gp.player.solidArea.y));
            gp.tilesM.tile[6].collision = true;
            gp.tilesM.tile[5].collision = false;
            //pruser to transfer when in lava
            // if (worldY > 319 && worldY < 560) {
            //     gp.player.setTransfer(true);
            //     gp.tilesM.tile[2].collision = false;
            // }
        }
        if (gp.keyBoard.isTwo == true) {
            gp.player.setTransfer(true);
            gp.tilesM.tile[6].collision = false;
            gp.tilesM.tile[5].collision = true;
                        //pruser to transfer when in pool
            // if (worldY > 560 && worldY < 848 && worldX > 1720) {
            //     gp.player.setTransfer(false);
            //     gp.tilesM.tile[6].collision = false;
            // }
        }
    }
}