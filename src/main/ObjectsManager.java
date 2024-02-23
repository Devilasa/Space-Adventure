package main;

import behaviours.*;
import entity.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static main.GamePanel.FPS;

public class ObjectsManager extends JComponent{
    private GamePanel gamePanel;
    private ArrayList<Entity> entities;
    private KeyHandler keyHandler;

    public ObjectsManager(GamePanel gamePanel) {
        this.keyHandler = new KeyHandler();
        entities = new ArrayList<>();
        entities.add(new TopAsteroid(new StraightFall()));
        entities.add(new TopAsteroid(new StraightFall()));
        entities.add(new Spaceship(gamePanel, keyHandler, new AllDirectionMovement()));
        entities.add(new DiagonalAsteroid(new RightDiagonalFall()));
        entities.add(new BlueAsteroid(new LeftDiagonalFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));

    }


    public void update(){
        for(Entity entity : entities){
            entity.update();
            checkCollision(entity);
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        for(Entity entity : entities){
            entity.draw(graphics2D);
        }

        graphics2D.dispose();
    }

    public void checkCollision(Entity entity){
        for(Entity e : entities){
            if(e != entity) {
                if (entity.getSolidArea().intersects(e.getSolidArea())) {
                    entity.setCollision(true);
                    break;
                }
            }
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public void setKeyHandler(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
}
