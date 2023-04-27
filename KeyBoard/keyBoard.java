package KeyBoard;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public abstract class keyBoard  implements KeyListener{
    GamePanel gp;

    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public  abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);
    
}
