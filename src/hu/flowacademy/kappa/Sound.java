package hu.flowacademy.kappa;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    public Sound() {
    }

    public void rooster() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/vasi/Git/homeproject/sounds/rooster9.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void win() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/vasi/Git/homeproject/sounds/winmusic.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void lose() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/vasi/Git/homeproject/sounds/losemusic.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void step() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/vasi/Git/homeproject/sounds/floop.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void zombie() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/vasi/Git/homeproject/sounds/groan.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
