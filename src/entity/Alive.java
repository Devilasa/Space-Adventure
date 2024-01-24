package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GamePanel.tileSize;

public class Alive implements State{
    Entity entity;

    ArrayList<BufferedImage> images;

    public Alive(ArrayList<BufferedImage> images, Entity entity) {
        this.images = images;
        this.entity = entity;
    }
    @Override
    public void update() {
        entity.getMovementBehaviour().move(entity);
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(images.get(0), entity.getX(), entity.getY(), tileSize, tileSize, null);
    }
}
