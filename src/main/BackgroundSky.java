package main;

import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static main.GamePanel.*;

public class BackgroundSky extends JComponent implements Runnable{

    private TileManager tileManager1;
    private TileManager tileManager2;
    private Thread skyThread;

    public BackgroundSky() {
        tileManager1 = new TileManager();
        tileManager2 = new TileManager();
        tileManager2.setY(-screenHeight);
        skyThread = new Thread(this);
        skyThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while(skyThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                //repaint();
                //System.out.println("BackgroundSky thread is running");
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        if (tileManager1.getY() < screenHeight) {
            tileManager2.setY(tileManager2.getY()+tileManager2.getTileSpeed());
            tileManager1.setY(tileManager1.getY()+tileManager2.getTileSpeed());
        } else {
            tileManager1.setMapTileNumber(tileManager2.getMapTileNumber());
            tileManager2.loadMap();

            tileManager2.setY(-screenHeight);
            tileManager1.setY(0);
        }

        tileManager1.draw(graphics2D);
        tileManager2.draw(graphics2D);
        graphics2D.dispose();
    }

    public TileManager getTileManager1() {
        return tileManager1;
    }

    public void setTileManager1(TileManager tileManager1) {
        this.tileManager1 = tileManager1;
    }

    public TileManager getTileManager2() {
        return tileManager2;
    }

    public void setTileManager2(TileManager tileManager2) {
        this.tileManager2 = tileManager2;
    }

    public Thread getSkyThread() {
        return skyThread;
    }

    public void setSkyThread(Thread skyThread) {
        this.skyThread = skyThread;
    }
}
