package main;

import behaviours.*;
import entity.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static main.GamePanel.*;
import static main.GamePanel.SCREEN_SHIFT_Y;

public class ObjectsManager extends JComponent{
    private GamePanel gamePanel;
    private ArrayList<Entity> entities;
    private KeyHandler keyHandler;

    public ObjectsManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
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
        graphics2D.setColor(Color.white);
        graphics2D.setFont(new Font("Arial", Font.BOLD, 50));
        graphics2D.drawString(gamePanel.getScore().toString(), screenWidth/2 - SCREEN_SHIFT_X, SCREEN_SHIFT_Y);
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

    public void explodeAll(){
        for(Entity e : entities){
            e.setCollision(true);
        }
    }

    public void reset(){
        for(Entity e : entities){
            e.reset();
        }
        gamePanel.setScore(0);
        gamePanel.setUpdateScore(true);
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
