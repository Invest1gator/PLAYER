import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Utility {
    public int count = 0;
    long Position = -1;
    public boolean Started = false;
    float volume=0;

    public Utility() throws LineUnavailableException {
    }

    Clip clip = AudioSystem.getClip();
    public void VolumeUp(){

        if(volume <1) {
            setVolume(volume+5f);
        }
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume);
    }

    public void VolumeDown(){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        setVolume(volume-5f);
        gainControl.setValue(volume);
    }

    public void Play(String s) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Started = true;
        String filePath = s;
        File musicPath = new File(String.valueOf(filePath));
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);

        if (count < 1) {
            clip.open(audioInput);
        }

        clip.start();
        if (count >= 1) {
            clip.setMicrosecondPosition(Position);
            clip.start();
        }
        count++;
    }

    public void Pause() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Position = clip.getMicrosecondPosition();
        clip.stop();
        Started = true;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getVolume() {
        int result = 2*(int) (volume+45);
        return result;
    }
}