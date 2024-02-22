package behaviours;

import entity.Spaceship;
import main.KeyHandler;

public class AxesMovement implements MovementBehaviour{
    @Override
    public void move(Spaceship spaceship) {
        KeyHandler keyHandler = spaceship.getKeyHandler();
        if (keyHandler.upPressed) {
            spaceship.setY(spaceship.getY() - (spaceship.getSpeed()*2));

        } else if (keyHandler.rightPressed) {
            spaceship.setX(spaceship.getX() + (spaceship.getSpeed()*2));

        } else if (keyHandler.downPressed) {
            spaceship.setY(spaceship.getY() + (spaceship.getSpeed()*2));

        } else if (keyHandler.leftPressed) {
            spaceship.setX(spaceship.getX() - (spaceship.getSpeed()*2));
        }
    }
}
