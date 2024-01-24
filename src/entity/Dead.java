package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Dead implements State{
    Entity entity;
    ArrayList<BufferedImage> images;

    public Dead(ArrayList<BufferedImage> images, Entity entity) {
        this.images = images;
        this.entity = entity;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }
}
