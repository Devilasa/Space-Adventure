package main;

import states.Gameover;
import states.InGame;
import states.State;

import javax.swing.*;
import java.awt.*;
public class GamePanel extends JLayeredPane  implements Runnable {
    public static final int originalTileSize = 16; // 16x16 tile
    public static final int scale = 4;
    public static final int tileSize = originalTileSize * scale; // 64x64 tile
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow = 12;
    public static final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
    public static final int screenHeight = tileSize * maxScreenRow; // 768 pixels
    public static final int SCREEN_SHIFT_X = 32;
    public static final int SCREEN_SHIFT_Y = 56;
    public static final int FPS = 120;
    private Integer score = 0;
    private Thread gameThread;
    private ObjectsManager objectsManager;
    private GameoverDisplay gameoverDisplay;
    State state;
    State menu;
    State inGame;
    State gameover;


    public GamePanel() {
        objectsManager = new ObjectsManager(this);
        gameoverDisplay = new GameoverDisplay(this);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(objectsManager.getKeyHandler());
        this.addMouseListener(new MouseHandler());
        setLayout(new OverlayLayout(this));


        add(new BackgroundSky(), 1);
        add(objectsManager, 0);


        setInGameState(new InGame(this));
        setGameoverState(new Gameover(this));
        setState(inGame);


    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        Song song = Song.getInstance();
        song.setSongType("menuSong");
        //song.playMusic();

    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS; // 1 second = 1000000000 nanosecond. It represents how many times per second you want the event (refresh) to happen.
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                 //System.out.println("GamePanel thread is running");
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                //System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update(){
        state.update();
        //System.out.println(state.getClass());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        state.draw(graphics2D);

    }

    public int getFPS() {
        return FPS;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public ObjectsManager getObjectsManager() {
        return objectsManager;
    }

    public void setObjectsManager(ObjectsManager objectsManager) {
        this.objectsManager = objectsManager;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getMenuState() {
        return menu;
    }

    public void setMenuState(State menu) {
        this.menu = menu;
    }

    public State getInGameState() {
        return inGame;
    }

    public void setInGameState(State inGame) {
        this.inGame = inGame;
    }

    public State getGameoverState() {
        return gameover;
    }

    public void setGameoverState(State gameover) {
        this.gameover = gameover;
    }

    public GameoverDisplay getGameoverDisplay() {
        return gameoverDisplay;
    }

    public void setGameoverDisplay(GameoverDisplay gameoverDisplay) {
        this.gameoverDisplay = gameoverDisplay;
    }
}