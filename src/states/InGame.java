package states;

import entity.Entity;
import main.GamePanel;
import main.ObjectsManager;

import java.awt.*;

public class InGame implements State{
    private GamePanel gamePanel;
    private ObjectsManager objectsManager;

    public InGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.objectsManager = gamePanel.getObjectsManager();
    }

    @Override
    public void update() {

        for(Entity entity : objectsManager.getEntities()){
            entity.update();
            objectsManager.checkCollision(entity);
        }

    }

    @Override
    public void draw(Graphics2D graphics2D) {

        for(Entity entity : objectsManager.getEntities()){
            entity.draw(graphics2D);
        }
        //gamePanel.getBackgroundSky().repaint();

        graphics2D.dispose();
    }
}
