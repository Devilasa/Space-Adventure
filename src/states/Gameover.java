package states;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.GamePanel.*;

public class Gameover implements State{
    private GamePanel gamePanel;

    public Gameover(GamePanel gamePanel) {
       this.gamePanel = gamePanel;
    }
    @Override
    public void update() {
        gamePanel.getGameoverDisplay().update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
    }

    public void changePanel(){
        gamePanel.add(gamePanel.add(gamePanel.getGameoverDisplay(),0));
        gamePanel.remove(gamePanel.getObjectsManager());
    }
}
