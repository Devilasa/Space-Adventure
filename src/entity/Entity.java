package entity;

import java.awt.*;


public abstract class Entity {
    private int x, y;
    private int speed;
    private int TextureShiftX;
    private int TextureShiftY;
    private Rectangle solidArea;
    private boolean collision;

    public abstract void update();
    public abstract void draw(Graphics2D graphics2D);
    public abstract void getImages();
    public abstract void reset();

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

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public void updateSolidArea(){
        solidArea.setLocation(getX() + getTextureShiftX(), getY() + getTextureShiftY());
    }


}
