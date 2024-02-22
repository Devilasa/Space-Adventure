package behaviours;

import entity.FallingObject;

public class ZigZagFall implements FallingBehaviour{
    private int func = 1;
    private int counter = 0;
    @Override
    public void fall(FallingObject fallingObject) {
        int side = fallingObject.getSide();
        if(side == 1){
            if(func == 1){
                fallingObject.setX(fallingObject.getX() - (fallingObject.getSpeed() + 1));
                fallingObject.setY(fallingObject.getY() - fallingObject.getSpeed());
                if(counter > 100){
                    func = 2;
                    counter = 0;
                }
            } else {
                fallingObject.setX(fallingObject.getX() - (fallingObject.getSpeed() + 1));
                fallingObject.setY(fallingObject.getY() + fallingObject.getSpeed());
                if(counter > 100){
                    func = 1;
                    counter = 0;
                }
            }
        } else {
            if(func == 1){
                fallingObject.setX(fallingObject.getX() + fallingObject.getSpeed() + 1);
                fallingObject.setY(fallingObject.getY() - fallingObject.getSpeed());
                if(counter > 100){
                    func = 2;
                    counter = 0;
                }
            } else {
                fallingObject.setX(fallingObject.getX() + fallingObject.getSpeed() + 1);
                fallingObject.setY(fallingObject.getY() + fallingObject.getSpeed());
                if(counter > 100){
                    func = 1;
                    counter = 0;
                }
            }
        }
        ++counter;
    }
}
