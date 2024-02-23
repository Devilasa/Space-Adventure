package entity;

import behaviours.FallingBehaviour;
import states.State;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class FallingObject extends Entity{
    private State state;
    private State flying;
    private State exploded;
    protected ArrayList<BufferedImage> flyingImages = new ArrayList<>();
    protected ArrayList<BufferedImage> explodedImages = new ArrayList<>();
    private int respawnCounterTarget;
    private int respawnCounter;
    private int spriteCounter;
    private int side;
    private FallingBehaviour fallingBehaviour;

    public void performFall(){
        fallingBehaviour.fall(this);
    }

    @Override
    public void update() {
        if(isCollision()){
            setState(getExplodedState());
        }
        state.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        state.draw(graphics2D);
    }

    @Override
    public void reset(){
        setDefaultValues();
    }

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

    public int getSpriteCounter() {
        return spriteCounter;
    }
    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getFlyingState() {
        return flying;
    }

    public void setFlyingState(State flying) {
        this.flying = flying;
    }

    public State getExplodedState() {
        return exploded;
    }

    public void setExplodedState(State exploded) {
        this.exploded = exploded;
    }


    public FallingBehaviour getFallingBehaviour() {
        return fallingBehaviour;
    }

    public void setFallingBehaviour(FallingBehaviour fallingBehaviour) {
        this.fallingBehaviour = fallingBehaviour;
    }

    public ArrayList<BufferedImage> getFlyingImages() {
        return flyingImages;
    }

    public void setFlyingImages(ArrayList<BufferedImage> flyingImages) {
        this.flyingImages = flyingImages;
    }

    public ArrayList<BufferedImage> getExplodedImages() {
        return explodedImages;
    }

    public void setExplodedImages(ArrayList<BufferedImage> explodedImages) {
        this.explodedImages = explodedImages;
    }

    public abstract void respawn();
    public abstract void setDefaultValues();

}
