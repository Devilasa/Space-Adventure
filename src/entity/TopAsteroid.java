package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static main.GamePanel.screenWidth;

public class TopAsteroid extends FallingObject{

    public TopAsteroid(MovementBehaviour movementBehaviour) {
        setMovementBehaviour(movementBehaviour);
        setDefaultValues();
        getImages();
        setState(getAliveState());
    }

    @Override
    public void getImages() {
        ArrayList<BufferedImage> aliveImages = new ArrayList<>();
        try {
            aliveImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_1.png")));
            aliveImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_2.png")));
            aliveImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_3.png")));
            aliveImages.add(ImageIO.read(new File("res/asteroid/asteroid_top_4.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
        setAliveState(new Alive(aliveImages, this));

        ArrayList<BufferedImage> deadImages = new ArrayList<>();
        try {
            deadImages.add(ImageIO.read(new File("res/asteroid/explosion.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
        setDeadState(new Dead(deadImages, this));
    }

    public void setDefaultValues(){
        setTextureShiftX(18);
        setTextureShiftY(26);
        setX(Random.from(new Random()).nextInt(0, screenWidth - 20));
        setY(-50);
        setSpeed(3);
        setRespawnCounter(0);
        setRespawnCounterTarget(8);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftX(), 30, 29));
    }
}
