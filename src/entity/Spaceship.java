package entity;

import behaviours.MovementBehaviour;
import main.GamePanel;
import main.KeyHandler;
import objectStates.Alive;
import objectStates.Dead;
import objectStates.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Spaceship extends Entity{
    private ArrayList<BufferedImage> aliveImages = new ArrayList<>();
    private ArrayList<BufferedImage> deadImages = new ArrayList<>();
    private GamePanel gamePanel;
    private KeyHandler keyHandler;
    private MovementBehaviour movementBehaviour;
    private State state;
    private State alive;
    private State dead;


    public Spaceship(GamePanel gamePanel, KeyHandler keyHandler, MovementBehaviour movementBehaviour) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.movementBehaviour = movementBehaviour;
        getImages();
        setDefaultValues();
    }

    public void performMovement(){
        movementBehaviour.move(this);
    }

    @Override
    public void update() {
        if(isCollision()){
            setState(getDeadState());
            gamePanel.setUpdateScore(false);
        }
        state.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        state.draw(graphics2D);
    }

    @Override
    public void getImages() {
        try {
            aliveImages.add(ImageIO.read(new File("res/spaceship/spaceship_standing.png")));
            aliveImages.add(ImageIO.read(new File("res/spaceship/spaceship_up.png")));
            aliveImages.add(ImageIO.read(new File("res/spaceship/spaceship_right.png")));
            aliveImages.add(ImageIO.read(new File("res/spaceship/spaceship_down.png")));
            aliveImages.add((ImageIO.read(new File("res/spaceship/spaceship_left.png"))));
            aliveImages.add((ImageIO.read(new File("res/spaceship/spaceship_up_right.png"))));
            aliveImages.add((ImageIO.read(new File("res/spaceship/spaceship_up_left.png"))));
            aliveImages.add((ImageIO.read(new File("res/spaceship/spaceship_down_right.png"))));
            aliveImages.add((ImageIO.read(new File("res/spaceship/spaceship_down_left.png"))));
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_broken_1.png")));
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_broken_2.png")));
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_explosion.png")));
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_broken_3.png")));
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_broken_4.png")));
            deadImages.add(ImageIO.read(new File("res/spaceship/spaceship_broken_5.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setDefaultValues(){
        setTextureShiftX(15);
        setTextureShiftY(11);
        setX(460);
        setY(380);
        setSpeed(3);
        setSolidArea(new Rectangle(getX()+getTextureShiftX(), getY()+getTextureShiftY(), 36, 38));
        setAliveState(new Alive(this));
        setDeadState(new Dead(this));
        setState(getAliveState());
        setCollision(false);
    }

    @Override
    public void reset(){
        setDefaultValues();
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getAliveState() {
        return alive;
    }

    public void setAliveState(State alive) {
        this.alive = alive;
    }

    public State getDeadState() {
        return dead;
    }

    public void setDeadState(State dead) {
        this.dead = dead;
    }

    public ArrayList<BufferedImage> getAliveImages() {
        return aliveImages;
    }

    public void setAliveImages(ArrayList<BufferedImage> aliveImages) {
        this.aliveImages = aliveImages;
    }

    public ArrayList<BufferedImage> getDeadImages() {
        return deadImages;
    }

    public void setDeadImages(ArrayList<BufferedImage> deadImages) {
        this.deadImages = deadImages;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
