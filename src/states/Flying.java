package states;

import entity.FallingObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GamePanel.*;

public class Flying implements State {
    private final int spriteChange = 20;
    private FallingObject fallingObject;
    private ArrayList<BufferedImage> images;
    private BufferedImage currentImage;


    public Flying(FallingObject fallingObject) {
        this.fallingObject = fallingObject;
        this.images = fallingObject.getFlyingImages();
        currentImage = images.get(0);
    }

    @Override
    public void update() {
        if (fallingObject.getY() > (screenHeight * 2) || fallingObject.getX() > (screenWidth * 2)) {
            fallingObject.respawn();
            fallingObject.setRespawnCounter(fallingObject.getRespawnCounter() + 1);
        } else {
            fallingObject.performFall();
        }
        fallingObject.updateSolidArea();


        fallingObject.setSpriteCounter(fallingObject.getSpriteCounter() + 1);
        if (fallingObject.getSpriteCounter() >= spriteChange) {
            fallingObject.setSpriteCounter(0);
            if (images.indexOf(currentImage) == images.size() - 1) {
                currentImage = images.get(0);
            } else {
                currentImage = images.get(images.indexOf(currentImage) + 1);
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(currentImage, fallingObject.getX(), fallingObject.getY(), tileSize, tileSize, null);
    }

}
