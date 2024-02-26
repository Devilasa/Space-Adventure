package panels;

import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static main.GamePanel.*;

public class BackgroundSky extends JComponent{

    private TileManager tileManager1;
    private TileManager tileManager2;

    public BackgroundSky() {
        tileManager1 = new TileManager();
        tileManager2 = new TileManager();
        tileManager2.setY(-screenHeight);
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
}
