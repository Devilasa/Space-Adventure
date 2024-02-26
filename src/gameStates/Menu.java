package gameStates;

import main.GamePanel;

public class Menu implements GameState{
    private GamePanel gamePanel;

    public Menu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {

    }

    @Override
    public void goMenu() {

    }

    @Override
    public void goGame() {
        gamePanel.add(gamePanel.getObjectsManager(), 0);
        gamePanel.remove(gamePanel.getMenuDisplay());
        gamePanel.validate();
        gamePanel.setGameState(gamePanel.getInGameState());
    }

    @Override
    public void goGameOver() {

    }

    @Override
    public void goLeaderboard() {
        gamePanel.add(gamePanel.getLeaderboardDisplay(), 0);
        gamePanel.remove(gamePanel.getMenuDisplay());
        gamePanel.validate();
        gamePanel.setGameState(gamePanel.getLeaderboardState());
    }
}
