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

public class DiagonalAsteroid extends FallingObject{
    public DiagonalAsteroid(FallingBehaviour fallingBehaviour) {
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
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_diagonal_1.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_diagonal_2.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_diagonal_3.png")));
            flyingImages.add(ImageIO.read(new File("res/asteroid/asteroid_diagonal_4.png")));

            explodedImages.add(ImageIO.read(new File("res/asteroid/explosion.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void respawn() {
        setX(Random.from(new Random()).nextInt(screenWidth / 2, screenWidth + 40));
        setY(-50);
        if(getRespawnCounter() == getRespawnCounterTarget()){
            setRespawnCounter(0);
            setSpeed(getSpeed()+1);
        }
        getSolidArea().setLocation(getX() + getTextureShiftX(), getY() + getTextureShiftX());
    }

    @Override
    public void setDefaultValues(){
        setTextureShiftX(12);
        setTextureShiftY(30);
        setX(Random.from(new Random()).nextInt(screenWidth / 2, screenWidth));
        setY(-50);
        setSpeed(2);
        setRespawnCounter(0);
        setRespawnCounterTarget(6);
        setSpriteCounter(0);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftY(), 30, 29));
    }


}
