package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface State {
    public void update();
    public void draw(Graphics2D graphics2D);
}
