package TextSreen;

import java.awt.Graphics2D;
import java.util.Random;

import Events.Quizz_Events;
import Events.SuperEvent;
import KeyBoard.keyControl;
import TextSreen.quizz.setQuestions;
import main.GamePanel;

public class quizzState extends SuperUI {
    private Quizz_Events events;
    public setQuestions questions[] = new setQuestions[10];
    private Random random = new Random();
    private int i = random.nextInt(3);


    public quizzState(GamePanel gp, keyControl keyBoard) {
        super(gp, g2);
        events = new Quizz_Events();
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

    public void draw(Graphics2D g2) {
        SuperUI.g2 = g2;

        if (gp.gamestate == gp.quizzState) {
            drawScreen(questions[i].text);
        }
    }

    /* */
    public void update() {
        if (gp.gamestate == gp.quizzState) {
            gp.player.isMove = false;
            if (SuperEvent.getObjectName()=="monster"){
                i = 6;
            }else{  
            }
            if(keyControl.tPress==true){
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
                    keyControl.tPress = false;

                }
                if(keyControl.fPress==true){
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
                    keyControl.fPress = false;
                }
                }
                if(events.teleport == true&&keyControl.isSpace==true) {
                    events.teleport();
                    events.teleport = false;
                }


            }

    // do something
    // reset i to zero in order out of array

    /* Events */
    

}
