package entity;

import behaviours.FallingBehaviour;
import states.Exploded;
import states.Flying;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static main.GamePanel.screenWidth;

public class BlueAsteroid extends FallingObject{
    public BlueAsteroid(FallingBehaviour fallingBehaviour) {
        setFallingBehaviour(fallingBehaviour);
        setDefaultValues();
        getImages();
        setFlyingState(new Flying(this));
        setExplodedState(new Exploded(this));
        setState(getFlyingState());
    }

    @Override
    public void getImages() {
        try {
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_blue_1.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_blue_2.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_blue_3.png")));

            explodedImages.add(ImageIO.read(new File("res/asteroid/explosion.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void respawn() {
        setX(Random.from(new Random()).nextInt(-350, screenWidth / 2 - 50));
        setY(-50);
        if(getRespawnCounter() == getRespawnCounterTarget()){
            setRespawnCounter(0);
            setSpeed(getSpeed()+1);
        }
        getSolidArea().setLocation(getX() + getTextureShiftX(), getY() + getTextureShiftX());
    }

    @Override
    public void setDefaultValues() {
        setTextureShiftX(7);
        setTextureShiftY(16);
        setX(Random.from(new Random()).nextInt(-200, screenWidth / 2 - 50));
        setY(-50);
        setSpeed(2);
        setRespawnCounter(0);
        setRespawnCounterTarget(6);
        setSpriteCounter(0);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftY(), 52, 32));
    }
}
