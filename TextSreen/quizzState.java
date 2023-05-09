package TextSreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Events.Quizz_Events;
import KeyBoard.keyControl;
import TextSreen.quizz.setQuestions;
import main.GamePanel;

public class quizzState extends SuperUI {
    public int i = 0;
    private int width, height;
    private keyControl keyBoard;
    private Quizz_Events events;
    public setQuestions questions[] = new setQuestions[10];

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
            if (keyBoard.tPress == true) {
                // do something
                if (questions[i].answer) {
                    drawScreen("correct");
                    events.ModeSpeed(5);
                    events.setObject();
                    events.nextState(gp.playState);
                } else if (!questions[i].answer) {
                    gp.eventH.announce("wrong");
                    events.ModeSpeed(5);
                    events.setObject();
                    events.nextState(gp.playState);


                }
                i++;// reset i to zero in order out of array
            }
            if (keyBoard.fPress == true) {
                // do something
                if (questions[i].answer = true) {
                    gp.eventH.announce("correct");
                    events.ModeSpeed(5);
                    events.setObject();
                    events.nextState(gp.playState);


                } else if (!questions[i].answer) {
                    gp.eventH.announce("wrong");
                    events.ModeSpeed(5);
                    events.setObject();
                    events.nextState(gp.playState);


                }
                i++;

            }
        }

    }

    /* Events */
    public void setup() {
        // questions
        questions[0] = new setQuestions();
        questions[0].text = "Duck bệu đỏ bạc ?";
        questions[0].answer = false;// fanswer
        questions[0].action = 0;// by default 0 is random evert or khác 0 chọn event cụ thể

        questions[1] = new setQuestions();
        questions[1].text = "Chào";
        questions[1].answer = true;
        questions[1].action = 0;
    }

    public void events(int i) {
        if (i == 0) {
            // random
        }
        switch (i) {
            case 1:
                events.ModeSpeed(3);
        }
    }
}
