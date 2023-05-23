package sound;
import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/*This is a Java class that can be used to play different sounds. It uses the Java Sound API to load and play audio files. 
The class has an array of URLs that point to different sound files. 
When you call the play() method with an index, it loads the corresponding sound file and plays it*/


 /*Ais: Audio Input Stream */
public class Sound {
    Clip clip;
    URL music[] = new URL[20];
    public Sound(){
        music[0] = getClass().getResource("/sound/road.wav");
        music[1] = getClass().getResource("/sound/coin.wav");
        music[2] = getClass().getResource("/sound/powerup.wav");
        music[3] = getClass().getResource("/sound/unlock.wav");
        music[4] = getClass().getResource("/sound/endgame.wav");
        music[5] = getClass().getResource("/sound/teleport.wav");
        music[6] = getClass().getResource("/sound/fanfare.wav");
        music[7] = getClass().getResource("/sound/powerdown.wav");
        music[8] = getClass().getResource("/sound/chest.wav");
        music[9] = getClass().getResource("/sound/clear.wav");
    }
/*These are two methods in a Java class that set the audio file to be played. 
    The first method takes an integer parameter that represents the index of the audio file in an array, 
    while the second method takes a string parameter that represents the file path of the audio file. 
    The methods use the AudioSystem and Clip classes from the Java Sound API to load and play the audio file. 
    If an exception occurs during the loading or playing of the audio file, it is caught and handled in the catch block.*/    
    
    public void setFile(int number) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(music[number]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }public void setFile(String name) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/sound/"+name+".wav"));
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
    
    /*This code appears to be a part of a class that deals with playing audio clips. 
The `play()` method starts playing the audio clip. 
The `loop()` method sets the audio clip to loop continuously. 
The `stop()` method stops the audio clip from playing.*/

}
