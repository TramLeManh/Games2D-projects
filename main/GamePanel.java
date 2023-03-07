package main;
import object.SuperObject;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import tiles.TilesMangaer;

import entity.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    public boolean detection = false;
    public boolean object_detection = true;
    public boolean end = false;
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; /* 48*48 */
    public final int maxScreenCol = 16;//16
    public final int maxScreenRow = 12;//12
    public final int screenWidth = tileSize * maxScreenCol;//768
    public final int screenHeight = tileSize * maxScreenRow;//576
    // world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 56;
    public final int worldWidth = maxWorldCol*tileSize;
    public final int worldHeight = maxWorldRow*tileSize;

    int FPS = 60;
    keyControl keyBoard = new keyControl();
    Sound music = new Sound();
    Sound SoundEffect = new Sound();
    public UI ui = new UI(this);
    public boolean hit =true;
    public Thread gameThread;
    public Player player = new Player(this,keyBoard);
    public TilesMangaer tilesM = new TilesMangaer(this);
    public collisionCheck cCheck = new collisionCheck(this);
    public SuperObject object[] = new SuperObject[20];//create ten block objects
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
        playMusic(0);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }
    private void FPS(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while(gameThread!= null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
            if(timer>=1000000000){
                timer = 0;
            }
        }
    }

    @Override
    public void run() {
        FPS();
    }
    /**  
    * Update class where update keyboard
    */    
    public void update() {
     player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D playerG = (Graphics2D) g;
        //draw map

        tilesM.draw(playerG);
       
        //draw object
        for(int i = 0; i < object.length; i++){
           if(object[i] != null){
            object[i].draw(playerG,this);
           }
        }
        //draw player
        player.draw(playerG);
        //draw UI
        ui.draw(playerG);
        playerG.dispose();
       
    }
    public void playMusic(int number){
        music.setFile(number);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int number){
        SoundEffect.setFile(number);
        SoundEffect.play();
    }
}
