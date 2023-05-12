package TextSreen.Screens;
import java.awt.Graphics2D;
import main.GamePanel;

public class Screens {
    private GamePanel gp;
    private Graphics2D g2;
    public Screens(GamePanel gp) {
        this.gp = gp;
    }
    public int LocateCenterText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
    
}
