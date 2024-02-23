package states;

import entity.Entity;
import main.GamePanel;
import main.ObjectsManager;

import java.awt.*;

public class InGame implements State{
    private GamePanel gamePanel;

    public InGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {

        gamePanel.getObjectsManager().update();
        gamePanel.setScore(gamePanel.getScore()+1);

    }

    @Override
    public void draw(Graphics2D graphics2D) {}
}
