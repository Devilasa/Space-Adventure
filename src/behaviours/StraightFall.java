package behaviours;

import entity.FallingObject;

public class StraightFall implements FallingBehaviour {
    @Override
    public void fall(FallingObject fallingObject) {
        fallingObject.setY(fallingObject.getY() + fallingObject.getSpeed());
    }
}
