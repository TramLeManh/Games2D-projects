package main;
import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Sound {
    Clip clip;
    URL music[] = new URL[20];
    public Sound(){
        music[0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
    }
    public void setFile() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(music[0]);
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
