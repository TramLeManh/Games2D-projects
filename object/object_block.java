package object;
import main.GamePanel;
import javax.imageio.ImageIO;
public class object_block  extends SuperObject{
    public object_block(){
        GamePanel gp;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("picture/tiles/block.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
