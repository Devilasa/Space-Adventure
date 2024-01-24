package main;

import entity.Entity;
import entity.StraightFall;
import entity.TopAsteroid;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static main.GamePanel.FPS;
import static main.GamePanel.screenHeight;

public class ObjectsManager extends JComponent implements Runnable{
    private ArrayList<Entity> entities;
    private Thread objectsThread;

    public ObjectsManager() {
        entities = new ArrayList<>();
        entities.add(new TopAsteroid(new StraightFall()));
        entities.add(new TopAsteroid(new StraightFall()));

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
                repaint();
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
}
