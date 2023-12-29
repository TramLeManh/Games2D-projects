package ScoreBoard;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class key  implements KeyListener {
    private score score;
    public key(score score) {
    this.score = score;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // Close the this when the space key is pressed
                System.out.println(2);
                }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
    
}
