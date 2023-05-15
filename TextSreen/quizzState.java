package TextSreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

import Events.Quizz_Events;
import KeyBoard.keyControl;
import TextSreen.quizz.setQuestions;
import main.GamePanel;
import object.prince;

public class quizzState extends SuperUI {
    private int width, height;
    private keyControl keyBoard;
    private Quizz_Events events;
    public setQuestions questions[] = new setQuestions[10];
    private static int a = 0;
    private Random random = new Random();
    private int i = random.nextInt(3);


    public quizzState(GamePanel gp, keyControl keyBoard) {
        super(gp, g2);
        this.keyBoard = keyBoard;
        events = new Quizz_Events();
        setQuestions question[] = new setQuestions[10];
        setup();
        sub_text = "press T or F";
        word_length = 20;
        // set up i random questions, or default
    }
    public void setup() {
        // questions
        questions[0] = new setQuestions();
        questions[0].text = "Final varible can not be change";
        questions[0].answer = true;// fanswer

        questions[1] = new setQuestions();
        questions[1].text = "Public can acess anywhere";
        questions[1].answer = true;

        questions[2] = new setQuestions();
        questions[2].text = "1+1=3";
        questions[2].answer = false;//


        questions[3] = new setQuestions();
        questions[3].text = "1+4=5";
        questions[3].answer = true;

        questions[4] = new setQuestions();
        questions[4].text = "Tri dep trai";
        questions[4].answer = false;
        
        questions[5] = new setQuestions();
        questions[5].text = "Oop is easy";
        questions[5].answer = false;

        questions[6] = new setQuestions();
        questions[6].text = "special Quizz";
        questions[6].answer = false;
    }

    private String text = " ";

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        if (gp.gamestate == gp.quizzState) {
            drawScreen(questions[i].text);
        }
    }

    /* */
    public void update() {
        if (gp.gamestate == gp.quizzState) {
            gp.player.isMove = false;
            if (events.getObjectName()=="monster"){
                i = 6;
            }else{
                text=questions[i].text;  
            }
                if(keyBoard.tPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);
                        events.correct();
                        i = random.nextInt(6);

                        System.out.println("clear");
                        // i = random.nextInt(6);


                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);
                        events.wrong();
                        i = random.nextInt(6);

                    }
                    keyBoard.tPress = false;

                }
                if(keyBoard.fPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);

                        events.wrong();
                        i = random.nextInt(6);

                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);

                        events.correct();

                        i = random.nextInt(6);

                    }
                    keyBoard.fPress = false;
                }
                }
                if(events.teleport == true&&keyBoard.isSpace==true) {
                    events.teleport();
                    events.teleport = false;
                }


            }

    // do something
    // reset i to zero in order out of array

    /* Events */
    

}
