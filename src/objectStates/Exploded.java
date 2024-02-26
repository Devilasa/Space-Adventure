package objectStates;

import entity.FallingObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GamePanel.tileSize;

public class Exploded implements State{
    private FallingObject fallingObject;
    ArrayList<BufferedImage> images;
    BufferedImage currentImage;
    private int respawnTimer = 0;

    public Exploded(FallingObject fallingObject) {
        this.fallingObject = fallingObject;
        this.images=fallingObject.getExplodedImages();
        currentImage = images.get(0);
    }

    @Override
    public void update() {
        fallingObject.setX(fallingObject.getX()+1);
        fallingObject.setY(fallingObject.getY()+1);
        fallingObject.getSolidArea().setLocation(-100, -100);
        respawnTimer++;
        if(respawnTimer > 70){
            respawnTimer = 0;
            fallingObject.setCollision(false);
            fallingObject.setState(fallingObject.getFlyingState());
            fallingObject.respawn();
            fallingObject.setRespawnCounter(fallingObject.getRespawnCounter() + 1);
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(currentImage, fallingObject.getX(), fallingObject.getY(), tileSize, tileSize, null);
    }
}
