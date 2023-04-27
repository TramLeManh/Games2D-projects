package TextSreen.quizz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import KeyBoard.keyControl;
import TextSreen.UI_interface;
import main.GamePanel;

public class questions implements UI_interface {
    GamePanel gp;
    Graphics2D g2;
    public int i = 0;
    private int width, height;
    private keyControl keyBoard;
    private Events events;
    public setQuestions questions[] = new setQuestions[10];

    public questions(GamePanel gp, keyControl keyBoard) {
        this.gp = gp;
        this.keyBoard = keyBoard;
        events = new Events(gp);
        setQuestions question[] = new setQuestions[10];
        setup();
        //set up i random questions, or default
    }

    private String text = " ";

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        if (gp.gamestate == gp.quizzState) {
            drawScreen(questions[i].text);
        }
    }

    public void update() {
        if (gp.gamestate == gp.quizzState) {
            gp.player.isMove = false;
            if (keyBoard.tPress == true) {
                // do something
                if (questions[i].answer) {
                    gp.player.announce("correct", true);
                    

                } else if(!questions[i].answer){
                    gp.player.announce("wrong", true);

                }
                i++;//reset i to  zero in order out of array
            }
            if (keyBoard.fPress == true) {
                // do something
                if (questions[i].answer = true) {
                    gp.player.announce("correct", true);

                }  else if(!questions[i].answer) {
                    gp.player.announce("wrong", true);

                }
                i++;

            }
        }

    }

    // edit questions
    public void drawSubScreen(int x, int y, int width, int height) {
        Color color = new Color(0, 0, 100, 100);
        g2.setColor(color);// nền trong
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setColor(Color.white);// viền
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawScreen(String text) {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        width = gp.screenWidth - (4 * gp.tileSize);
        height = (4 * gp.tileSize);
        drawSubScreen(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        g2.drawString("press T or F", width - 150, height);

    }

    public void setup() {
        //questions
        questions[0] = new setQuestions();
        questions[0].text = "We can acess private variables anywhere";
        questions[0].answer = false ;//fanswer
        questions[0].action = 0;//by default 0 is random evert or khác 0 chọn event cụ thể

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
                events.speedUp(3);
        }
    }
}
