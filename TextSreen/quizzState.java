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
    public setQuestions questions[] = new setQuestions[11];
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
        questions[0].text = "Final varible or final method can not be change";
        questions[0].answer = true;// fanswer

        questions[1] = new setQuestions();
        questions[1].text = "int a = 4%2\n the result  a is 2 ";
        questions[1].answer = true; 

        questions[2] = new setQuestions();
        questions[2].text = " High-level modules should depend on abstractions \n rather than concrete implementations";
        questions[2].answer = true;//


        questions[3] = new setQuestions();
        questions[3].text = "int a = 2 \n int b  = ++a + a; \n The result of b is 4  ";
        questions[3].answer = false;

        questions[4] = new setQuestions();
        questions[4].text = "We can overide the final method ";
        questions[4].answer = false;
        
        questions[5] = new setQuestions();
        questions[5].text = "You can extends abstract class \n without using abstract methods";
        questions[5].answer = false;

        questions[6] = new setQuestions();
        questions[6].text = "You can use overide method without exntending class";
        questions[6].answer = true;

        questions[7] = new setQuestions();
        questions[7].text = "You can use overide method without exntending class";
        questions[7].answer = true;

        questions[8] = new setQuestions();
        questions[8].text = "A software Class or module should be open for \n modification but closed for extension  ";
        questions[8].answer = false;
        
        questions[9] = new setQuestions();
        questions[9].text = "public class Student {\n public void registerStudent() { // some logic } \n public void calculate_Student_Results() { // some logic }} \n This is a good desgin";
        questions[9].answer = false;
        
        questions[10] = new setQuestions();
        questions[10].text = "Client should be forced to depend on methods it does not use";
        questions[10].answer = false;
        
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
            }
            if(keyControl.tPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);
                        events.correct();
                        i = random.nextInt(11);
                        System.out.println("clear");
                        // i = random.nextInt(6);


                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);
                        events.wrong();
                        i = random.nextInt(11);

                    }
                    keyControl.tPress = false;

                }
                if(keyControl.fPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);

                        events.wrong();
                        i = random.nextInt(11);

                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);

                        events.correct();

                        i = random.nextInt(11);

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
