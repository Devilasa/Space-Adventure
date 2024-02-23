package gameStates;

import main.GamePanel;

public class Gameover implements GameState{
    private GamePanel gamePanel;
    private int timer = 0;

    public Gameover(GamePanel gamePanel) {
       this.gamePanel = gamePanel;
    }
    @Override
    public void update() {
        gamePanel.getGameoverDisplay().update();
        gamePanel.getObjectsManager().update();
        if(gamePanel.getGameoverDisplay().getScale() >= 500) goGameOver();
    }

    @Override
    public void goMenu() {

    }

    @Override
    public void goGame() {

    }

    @Override
    public void goGameOver() {
        if(timer == 0) {
            gamePanel.getObjectsManager().explodeAll();
        }
        if(timer > 70) {
            gamePanel.remove(gamePanel.getObjectsManager());
            gamePanel.validate();
            timer = 0;
        }
        timer++;
    }

}
