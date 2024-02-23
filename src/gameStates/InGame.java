package gameStates;

import main.GamePanel;

public class InGame implements GameState{
    private GamePanel gamePanel;

    public InGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {

        gamePanel.getObjectsManager().update();
        if(gamePanel.getUpdateScore()) {
            gamePanel.setScore(gamePanel.getScore() + 1);
        }

    }

    @Override
    public void goMenu() {

    }

    @Override
    public void goGame() {

    }

    @Override
    public void goGameOver() {
        gamePanel.add(gamePanel.getGameoverDisplay(),0);
        gamePanel.validate();

        gamePanel.setGameState(gamePanel.getGameoverState());
    }
}
