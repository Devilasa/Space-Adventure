package behaviours.fallingBahaviour;

import entity.FallingObject;

public class RightDiagonalFall implements FallingBehaviour{
    @Override
    public void fall(FallingObject fallingObject) {
        fallingObject.setY(fallingObject.getY() + fallingObject.getSpeed());
        fallingObject.setX(fallingObject.getX() + fallingObject.getSpeed() + 1);
    }
}
