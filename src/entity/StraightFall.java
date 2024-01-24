package entity;

public class StraightFall implements MovementBehaviour {
    @Override
    public void move(Entity entity) {

        entity.setY(entity.getY()+ entity.getSpeed());
    }
}
