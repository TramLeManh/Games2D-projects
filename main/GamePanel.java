package main;
import object.SuperObject;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import tiles.TilesMangaer;

import entity.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.EventHandler;

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
    //gamestate
    public int gamestate = 3;
    public final int playState = 1;
    public final int dialogueState = 2;
    public final int startState = 3;
    public final int quizzState = 3;

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
    public Event eventH  = new Event(this);
    //Superobject Gamepannel 
    public SuperObject object[] = new SuperObject[20];//create ten block objects
    public object_set  aSetter = new object_set(this);
    public boolean playMusic = true;
    public questions quizz = new questions(this,keyBoard);

    // Player start positions
    int playerX     = 100;
    int playerY     = 100;
    int playerSpeed = 4;

    public GamePanel() {
        // set Background
        this.setPreferredSize(new Dimension(16*48, 12*48));
        this.setBackground(new Color(70,120,80));/* getHSBColor() */ /* decode hex code */ /*Color.decode("#000000") */
        this.setDoubleBuffered(true);
        // Insert Keyboard:
        this.addKeyListener(keyBoard);
        this.setFocusable(true);
    
    }
    public void setupGame(){
        aSetter.set_object();
        playMusic("road");
        gamestate = 3;
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
     quizz.update();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gamestate == startState){
            ui.draw(g2);
        }
        else{
           
            //draw map
    
            tilesM.draw(g2);
    
            //draw object
            for(int i = 0; i < object.length; i++){
               if(object[i] != null){
                object[i].draw(g2,this);
               }
            }
    
            //draw player
            player.draw(g2);
            //draw UI
            ui.draw(g2);
            quizz.draw(g2);
            g2.dispose();
        }
       
       
    }
    public void playMusic(int number){
        music.setFile(number);
        music.play();
        music.loop();
    }
    public void playMusic(String name){
        music.setFile(name);
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
    public void playSE(String name){
        SoundEffect.setFile(name);
        SoundEffect.play();
    }
}
