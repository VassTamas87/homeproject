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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/rooster.wav").getAbsoluteFile());
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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/winmusic.wav").getAbsoluteFile());
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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/losemusic.wav").getAbsoluteFile());
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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/groan.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void zombie2() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/groan2.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void zombie3() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/groan3.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void zombie6() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/groan6.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void zombie7() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/lowgroan.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void select() {
        int i = (int) Math.floor(Math.random() * 5);
        switch (i) {
            case 0:
                zombie();
                break;
            case 1:
                zombie2();
                break;
            case 2:
                zombie3();
                break;
            case 3:
                zombie6();
                break;
            case 4:
                zombie7();
                break;
        }
    }
}
