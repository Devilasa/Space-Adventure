package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Song {
    private static Song uniqueInstance;
    private String songType;
    private Clip clip;
    private final File gameSong;
    private final File menuSong;
    private AudioInputStream audioInputStream;

    private Song() {
        gameSong = new File("res/sound/GameSong.wav");
        menuSong = new File("res/sound/MenuSong.wav");
    }

    public static Song getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Song();
        }
        return uniqueInstance;
    }

    private void setFile(String songType){
        try {
            switch (songType) {
                case "gameSong" -> audioInputStream = AudioSystem.getAudioInputStream(gameSong);
                case "menuSong" -> audioInputStream = AudioSystem.getAudioInputStream(menuSong);
            }
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchSong(){
        switch (songType){
            case "gameSong" -> songType = "menuSong";
            case "menuSong" -> songType = "gameSong";
        }
        stopMusic();
        playMusic();
    }
    public void playMusic(){
        setFile(songType);
        play();
        loop();
    }

    public void stopMusic(){
        clip.stop();
    }

    private void play(){
        clip.start();
    }

    private void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public File getGameSong() {
        return gameSong;
    }

    public File getMenuSong() {
        return menuSong;
    }

    public AudioInputStream getAudioInputStream() {
        return audioInputStream;
    }

}

