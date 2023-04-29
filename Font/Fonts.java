package Font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Fonts {
    private Font f;
    public Fonts() {
        loadFont();
    }
    private void loadFont() {
        try{
            InputStream file = getClass().getResourceAsStream("Font/font.ttf");
            f =  Font.createFont(Font.TRUETYPE_FONT, file);
           

        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }        
    }
    public Font getFont(){
        return f;
    }
}
