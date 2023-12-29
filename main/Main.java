package main;
import javax.swing.JFrame;

import picture.picture;
/*w window */
public class Main {
    public static void main(String[] args){
      JFrame w = new JFrame();
      picture p = new picture();

      w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      w.setIconImage(p.get("icon"));
      w.setResizable(false);
      w.setTitle("My adventure");/*Set tittle */
      GamePanel gamePanel = new GamePanel();
      gamePanel.addFrame(w);
      w.add(gamePanel);
      w.pack();
      w.setLocationRelativeTo(null);
      w.setVisible(false);
      login l  = new login(gamePanel,w);
      l.setVisible(true);
      
      gamePanel.startGameThread();
      gamePanel.setupGame();
        
    }
    
    
}