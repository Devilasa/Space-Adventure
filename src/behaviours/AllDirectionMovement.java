package behaviours;

import entity.Spaceship;
import main.KeyHandler;

public class AllDirectionMovement implements MovementBehaviour{
    @Override
    public void move(Spaceship spaceship) {
        KeyHandler keyHandler = spaceship.getKeyHandler();
        if (keyHandler.upPressed && keyHandler.rightPressed){
            spaceship.setY(spaceship.getY() - spaceship.getSpeed());
            spaceship.setX(spaceship.getX() + spaceship.getSpeed());

        } else if (keyHandler.upPressed && keyHandler.leftPressed) {
            spaceship.setY(spaceship.getY() - spaceship.getSpeed());
            spaceship.setX(spaceship.getX() - spaceship.getSpeed());

        } else if (keyHandler.downPressed && keyHandler.rightPressed) {
            spaceship.setY(spaceship.getY() + spaceship.getSpeed());
            spaceship.setX(spaceship.getX() + spaceship.getSpeed());

        } else if(keyHandler.downPressed && keyHandler.leftPressed){
            spaceship.setY(spaceship.getY() + spaceship.getSpeed());
            spaceship.setX(spaceship.getX() - spaceship.getSpeed());

        } else if (keyHandler.upPressed) {
            spaceship.setY(spaceship.getY() - spaceship.getSpeed());

        } else if (keyHandler.rightPressed) {
            spaceship.setX(spaceship.getX() + spaceship.getSpeed());

        } else if (keyHandler.downPressed) {
            spaceship.setY(spaceship.getY() + spaceship.getSpeed());

        } else if (keyHandler.leftPressed) {
            spaceship.setX(spaceship.getX() - spaceship.getSpeed());
        }
    }
}
