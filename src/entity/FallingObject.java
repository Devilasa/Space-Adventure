package entity;

public abstract class FallingObject extends Entity{
    private int respawnCounterTarget;
    private int respawnCounter;

    public int getRespawnCounterTarget() {
        return respawnCounterTarget;
    }

    public void setRespawnCounterTarget(int respawnCounterTarget) {
        this.respawnCounterTarget = respawnCounterTarget;
    }

    public int getRespawnCounter() {
        return respawnCounter;
    }

    public void setRespawnCounter(int respawnCounter) {
        this.respawnCounter = respawnCounter;
    }
    public void setDefaultValues(){

    }

}
