package main;

import behaviours.*;
import entity.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static main.GamePanel.FPS;

public class ObjectsManager extends JComponent implements Runnable{
    private ArrayList<Entity> entities;
    private Thread objectsThread;
    private KeyHandler keyHandler;

    public ObjectsManager() {
        this.keyHandler = new KeyHandler();
        entities = new ArrayList<>();
        entities.add(new TopAsteroid(new StraightFall()));
        entities.add(new TopAsteroid(new StraightFall()));
        entities.add(new Spaceship(keyHandler, new AllDirectionMovement()));
        entities.add(new DiagonalAsteroid(new RightDiagonalFall()));
        entities.add(new BlueAsteroid(new LeftDiagonalFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));
        entities.add(new AlienShip(new ZigZagFall()));


        objectsThread = new Thread(this);
        objectsThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while(objectsThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                //repaint();
                update();
                //System.out.println("OBJ MANAGER RUNNING");
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
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

    public Thread getObjectsThread() {
        return objectsThread;
    }

    public void setObjectsThread(Thread objectsThread) {
        this.objectsThread = objectsThread;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public void setKeyHandler(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
}
