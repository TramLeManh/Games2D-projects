package main;
import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Sound {
    Clip clip;
    URL music[] = new URL[20];
    public Sound(){
        music[0] = getClass().getResource("/sound/background.wav");
        music[1] = getClass().getResource("/sound/coin.wav");
        music[2] = getClass().getResource("/sound/fanfare.wav");
        music[3] = getClass().getResource("/sound/unlock.wav");
    }
    public void setFile(int number) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(music[number]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}
