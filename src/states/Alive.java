package states;

import entity.Spaceship;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GamePanel.*;

public class Alive implements State{
    private Spaceship spaceship;
    private ArrayList<BufferedImage> images;
    private BufferedImage currentImage;

    public Alive(Spaceship spaceship) {
        this.spaceship = spaceship;
        this.images = spaceship.getAliveImages();
    }

    @Override
    public void update() {
        KeyHandler keyHandler = spaceship.getKeyHandler();
        if (keyHandler.upPressed && keyHandler.rightPressed){
            currentImage = images.get(5);

        } else if (keyHandler.upPressed && keyHandler.leftPressed) {
            currentImage = images.get(6);

        } else if (keyHandler.downPressed && keyHandler.rightPressed) {
            currentImage = images.get(7);

        } else if(keyHandler.downPressed && keyHandler.leftPressed){
            currentImage = images.get(8);

        } else if (keyHandler.upPressed) {
            currentImage = images.get(1);

        } else if (keyHandler.rightPressed) {
            currentImage = images.get(2);

        } else if (keyHandler.downPressed) {
            currentImage = images.get(3);

        } else if (keyHandler.leftPressed) {
            currentImage = images.get(4);

        } else {

            currentImage = images.get(0);
        }
        if(spaceship.getX() > screenWidth - SCREEN_SHIFT_X){
            spaceship.setX(-SCREEN_SHIFT_X);
        } else if (spaceship.getX() < -SCREEN_SHIFT_X) {
            spaceship.setX(screenWidth - SCREEN_SHIFT_X);
        }
        if(spaceship.getY() > screenHeight - SCREEN_SHIFT_Y){
            spaceship.setY(screenHeight-SCREEN_SHIFT_Y);
        } else if (spaceship.getY() < 0) {
            spaceship.setY(0);
        }
        spaceship.performMovement();
        spaceship.updateSolidArea();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(currentImage, spaceship.getX(), spaceship.getY(), tileSize, tileSize, null);
    }
}
