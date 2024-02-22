package states;

import entity.Spaceship;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GamePanel.tileSize;

public class Dead implements State{
    private Spaceship spaceship;
    private ArrayList<BufferedImage> images;
    private BufferedImage currentImage;
    private int deathTimer = 0;
    private final int DEATH_ANIMATION_SPEED_MULTIPLIER = 70;

    public Dead(Spaceship spaceship) {
        this.spaceship = spaceship;
        this.images = spaceship.getDeadImages();
        currentImage = images.get(0);
    }

    @Override
    public void update() {
        if(deathTimer == DEATH_ANIMATION_SPEED_MULTIPLIER){
            currentImage = images.get(1);
        } else if (deathTimer == DEATH_ANIMATION_SPEED_MULTIPLIER*2) {
            currentImage = images.get(2);
        } else if (deathTimer == DEATH_ANIMATION_SPEED_MULTIPLIER*3) {
            currentImage = images.get(3);
            spaceship.setX(spaceship.getX() - 32);
            spaceship.setY(spaceship.getY() - 32);
        } else if (deathTimer == DEATH_ANIMATION_SPEED_MULTIPLIER*4) {
            currentImage = images.get(4);
        } else if (deathTimer == DEATH_ANIMATION_SPEED_MULTIPLIER*5) {
            currentImage = images.get(5);
            spaceship.setX(spaceship.getX() - 64);
            spaceship.setY(spaceship.getY() - 64);
            spaceship.getSolidArea().setLocation(-150, 0);
            deathTimer = -1;
        }
        if(deathTimer > -1) {
            ++deathTimer;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(currentImage, spaceship.getX(), spaceship.getY(), currentImage.getWidth(), currentImage.getHeight(), null);
    }
}
