package states;

import java.awt.*;


public interface State {
    void update();
    void draw(Graphics2D graphics2D);
}
