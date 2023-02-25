package entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Player;
public class choosePlayer {
    public choosePlayer(){
        getplayerImage();
    }
    private BufferedImage up11;
    private BufferedImage up12;
    private BufferedImage down11;
    private BufferedImage left12;
    private BufferedImage left11;
    private BufferedImage down12;
    private BufferedImage right11;
    private BufferedImage right12;
    private BufferedImage up21;
    private BufferedImage up22;
    private BufferedImage down21;
    private BufferedImage left22;
    private BufferedImage left21;
    private BufferedImage down22;
    private BufferedImage right21;
    private BufferedImage right22;

    private void  getplayerImage() {
        try {
                //player1
                up11 = ImageIO.read(getClass().getResource("/picture/boy_up_1.png"));
                up12 = ImageIO.read(getClass().getResource("/picture/boy_up_2.png"));
                down11 = ImageIO.read(getClass().getResource("/picture/boy_down_1.png"));
                down12 = ImageIO.read(getClass().getResource("/picture/boy_down_2.png"));
                left11 = ImageIO.read(getClass().getResource("/picture/boy_left_1.png"));
                left12 = ImageIO.read(getClass().getResource("/picture/boy_left_2.png"));
                right11 = ImageIO.read(getClass().getResource("/picture/boy_right_1.png"));
                right12 = ImageIO.read(getClass().getResource("/picture/boy_right_2.png"));
                //player2
                up21 = ImageIO.read(getClass().getResource("/picture1/boy_up_1.png"));
                up22 = ImageIO.read(getClass().getResource("/picture1/boy_up_2.png"));
                down21 = ImageIO.read(getClass().getResource("/picture1/boy_down_1.png"));
                down22 = ImageIO.read(getClass().getResource("/picture1/boy_down_2.png"));
                left21 = ImageIO.read(getClass().getResource("/picture1/boy_left_1.png"));
                left22 = ImageIO.read(getClass().getResource("/picture1/boy_left_2.png"));
                right21 = ImageIO.read(getClass().getResource("/picture1/boy_right_1.png"));
                right22 = ImageIO.read(getClass().getResource("/picture1/boy_right_2.png"));
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage get_image(boolean transfer,String direction,int spritenumber){
        if(transfer){
            if(direction == "up"){
                if(spritenumber==1){
                   return up11;
                }
                if(spritenumber==2){
                   return up12;
                }
            }
            else if(direction == "down"){
                if(spritenumber==1){
                   return down11;
                }
                if(spritenumber==2){
                   return down12;
                }
            }
            else if(direction == "right"){
                if(spritenumber ==1){
                   return right11;
                }
                if(spritenumber ==2){
                   return right12;
                }
            }
            else if(direction=="left"){
                if(spritenumber==1){
                   return left11;
                }
                if(spritenumber==2){
                   return left12;
                }             
            }
        }
        else{
            if(direction == "up"){
                if(spritenumber==1){
                   return up21;
                }
                if(spritenumber==2){
                   return up22;
                }
            }
            else if(direction == "down"){
                if(spritenumber==1){
                   return down21;
                }
                if(spritenumber==2){
                   return down22;
                }
            }
            else if(direction == "right"){
                if(spritenumber ==1){
                   return right21;
                }
                if(spritenumber ==2){
                   return right22;
                }
            }
            else if(direction=="left"){
                if(spritenumber==1){
                   return left21;
                }
                if(spritenumber==2){
                   return left22;
                }             
            }            
        }
        return null;
    }
}


