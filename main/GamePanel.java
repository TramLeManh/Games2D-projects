package main;
import object.SuperObject;
import java.awt.Color;
import java.awt.Dimension;

import javax.security.auth.Subject;
import javax.swing.JPanel;
import tiles.TilesMangaer;

import entity.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; /* 48*48 */
    public final int maxScreenCol = 16;//16
    public final int maxScreenRow = 12;//12
    public final int screenWidth = tileSize * maxScreenCol;//768
    public final int screenHeight = tileSize * maxScreenRow;//576
    // world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 55;
    public final int worldWidth = maxWorldCol*tileSize;
    public final int worldHeight = maxWorldRow*tileSize;

    int FPS = 60;
    keyControl keyBoard = new keyControl();
    Sound sound = new Sound();
    public Thread gameThread;
    public Player player = new Player(this,keyBoard);
    public TilesMangaer tilesM = new TilesMangaer(this);
    public collisionCheck cCheck = new collisionCheck(this);
    public SuperObject object[] = new SuperObject[10];//create ten block objects
    public object_set  aSetter = new object_set(this);

    // Player start positions
    int playerX     = 100;
    int playerY     = 100;
    int playerSpeed = 4;

    public GamePanel() {
        // set Background
        this.setPreferredSize(new Dimension(16*48, 12*48));
        this.setBackground(Color.decode("#8F00FF"));/* getHSBColor() */ /* decode hex code */
        this.setDoubleBuffered(true);
        // Insert Keyboard:
        this.addKeyListener(keyBoard);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.set_object();
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void start(){
        playMusic();
    }
    private void FPS(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread!= null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                drawCount = 0;
                timer = 0;
            }
        }
    }

    @Override
    public void run() {
        FPS();
    }

    public void update() {
     player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D playerG = (Graphics2D) g;
        //tile
        tilesM.draw(playerG);
        //object
        for(int i = 0; i < object.length; i++){
           if(object[i] != null){
            object[i].draw(playerG,this);
           }
        }
        //collision
        // cCheck.draw(playerG);
        //player
        player.draw(playerG);
        playerG.dispose();
       
    }
    public void playMusic(){
        sound.setFile();
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }

}
