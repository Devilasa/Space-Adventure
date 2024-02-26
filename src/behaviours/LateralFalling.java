package behaviours;

import entity.FallingObject;

public class LateralFalling implements FallingBehaviour{
    @Override
    public void fall(FallingObject fallingObject) {
        int side = fallingObject.getSide();
        if(side == 1){
            fallingObject.setX(fallingObject.getX()-fallingObject.getSpeed());
        } else {
            fallingObject.setX(fallingObject.getX()+fallingObject.getSpeed());
        }
    }
}
