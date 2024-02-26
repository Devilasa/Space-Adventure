package entity;

import behaviours.FallingBehaviour;
import objectStates.Exploded;
import objectStates.Flying;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static main.GamePanel.screenWidth;

public class TopAsteroid extends FallingObject{
    public TopAsteroid(FallingBehaviour fallingBehaviour) {
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
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_1.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_2.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_3.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_4.png")));

            explodedImages.add(ImageIO.read(new File("res/asteroid/explosion.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void respawn(){
        setX(Random.from(new Random()).nextInt(0, screenWidth - 20));
        setY(-50);
        if(getRespawnCounter() == getRespawnCounterTarget()){
            setRespawnCounter(0);
            setSpeed(getSpeed()+1);
        }
        getSolidArea().setLocation(getX() + getTextureShiftX(), getY() + getTextureShiftX());
    }

    @Override
    public void setDefaultValues(){
        setTextureShiftX(18);
        setTextureShiftY(26);
        setX(Random.from(new Random()).nextInt(0, screenWidth - 20));
        setY(-50);
        setSpeed(3);
        setRespawnCounter(0);
        setRespawnCounterTarget(8);
        setSpriteCounter(0);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftY(), 30, 29));
    }


}
