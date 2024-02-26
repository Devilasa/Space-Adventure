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
        timer = 0;
        gamePanel.getObjectsManager().reset();
        gamePanel.getGameoverDisplay().setScale(0);
        gamePanel.remove(gamePanel.getObjectsManager());
        gamePanel.remove(gamePanel.getGameoverDisplay());
        gamePanel.add(gamePanel.getMenuDisplay(),0);
        gamePanel.validate();
        gamePanel.setGameState(gamePanel.getMenuState());
        gamePanel.getSong().switchSong();
    }

    @Override
    public void goGame() {
        timer = 0;
        gamePanel.getObjectsManager().reset();
        gamePanel.getGameoverDisplay().setScale(0);
        gamePanel.remove(gamePanel.getGameoverDisplay());
        gamePanel.add(gamePanel.getObjectsManager(), 0);
        gamePanel.validate();
        gamePanel.setGameState(gamePanel.getInGameState());
    }

    @Override
    public void goGameOver() {
        if(timer == 0) {
            gamePanel.getObjectsManager().explodeAll();
        }
        if(timer > 70) {
            gamePanel.remove(gamePanel.getObjectsManager());
            gamePanel.validate();
            timer = 1;
        }
        timer++;
    }

    @Override
    public void goLeaderboard() {

    }

}
