package entity;

import behaviours.fallingBahaviour.FallingBehaviour;
import objectStates.Exploded;
import objectStates.Flying;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static main.GamePanel.screenHeight;
import static main.GamePanel.screenWidth;

public class AlienShip extends FallingObject{

    public AlienShip(FallingBehaviour fallingBehaviour) {
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
            flyingImages.add(ImageIO.read(new File("res/asteroid/alienship_1.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/alienship_2.png")));

            explodedImages.add(ImageIO.read(new File("res/asteroid/explosion.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void respawn() {
        setSide(Random.from(new Random()).nextInt(1,3));
        if(getSide() == 1){
            setX(screenWidth + 40);
        } else {
            setX(-40);
        }
        setY(Random.from(new Random()).nextInt(10, screenHeight - 20));
        if(getRespawnCounter() == getRespawnCounterTarget()){
            setRespawnCounter(0);
            setSpeed(getSpeed()+1);
        }
        getSolidArea().setLocation(getX() + getTextureShiftX(), getY() + getTextureShiftX());
    }

    @Override
    public void setDefaultValues() {
        setTextureShiftX(8);
        setTextureShiftY(23);
        setSide(Random.from(new Random()).nextInt(1,3));
        if(getSide() == 1){
            setX(screenWidth + 40);
        } else {
            setX(-40);
        }
        setY(Random.from(new Random()).nextInt(10, screenHeight - 20));
        setSpeed(1);
        setRespawnCounter(0);
        setRespawnCounterTarget(6);
        setSpriteCounter(0);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftY(), 50, 29));
    }

}
