package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity {
    private int x, y;
    private int speed;
    private int TextureShiftX;
    private int TextureShiftY;
    private Rectangle solidArea;
    private State state;
    private State Alive;
    private State Dead;
    private MovementBehaviour movementBehaviour;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getAliveState() {
        return Alive;
    }

    public void setAliveState(State alive) {
        Alive = alive;
    }

    public State getDeadState() {
        return Dead;
    }

    public void setDeadState(State dead) {
        Dead = dead;
    }

    public void update(){
        state.update();
    }
    public void draw(Graphics2D graphics2D){
        state.draw(graphics2D);
    }
    public abstract void getImages();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTextureShiftX() {
        return TextureShiftX;
    }

    public void setTextureShiftX(int textureShiftX) {
        TextureShiftX = textureShiftX;
    }

    public int getTextureShiftY() {
        return TextureShiftY;
    }

    public void setTextureShiftY(int textureShiftY) {
        TextureShiftY = textureShiftY;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public MovementBehaviour getMovementBehaviour() {
        return movementBehaviour;
    }

    public void setMovementBehaviour(MovementBehaviour movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }
}
