package behaviours;

import entity.FallingObject;

public class LeftDiagonalFall implements FallingBehaviour{
    @Override
    public void fall(FallingObject fallingObject) {
        fallingObject.setY(fallingObject.getY() + fallingObject.getSpeed());
        fallingObject.setX(fallingObject.getX() - fallingObject.getSpeed());
    }
}
