package main;

import TextSreen.playState;

public class map {
    GamePanel gp;
    public map(GamePanel gp) {
        this.gp = gp;
    }
    public void set(){
        gp.playMusic("road");
    }
    public void reset(){
        gp.player.setDefultValues();
        gp.objects.setup();
        gp.player.reset();
        gp.playMusic("road");
        gp.eventH.reset();
        gp.tilesM.getImage();
        gp.play.resetTime();
        gp.gamestate = gp.playState;
    }
      public void reset1(){
        gp.player.setDefultValues();
        gp.objects.setup();
        gp.player.reset();
        gp.stopMusic();

        gp.eventH.reset();
        gp.tilesM.getImage();
        gp.play.resetTime();
        gp.gamestate = gp.startState;
    }
      public void restart(){
        gp.player.setDefultValues();
        gp.objects.setup();
        gp.player.reset();
   
        gp.eventH.reset();
        gp.tilesM.getImage();
        gp.play.resetTime();
      
    }
    
}
