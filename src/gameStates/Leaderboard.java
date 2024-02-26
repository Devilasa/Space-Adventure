package gameStates;

import main.GamePanel;

public class Leaderboard implements GameState{

    private GamePanel gamePanel;

    public Leaderboard(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {

    }

    @Override
    public void goMenu() {
        gamePanel.add(gamePanel.getMenuDisplay(),0);
        gamePanel.remove(gamePanel.getLeaderboardDisplay());
        gamePanel.validate();
        gamePanel.setGameState(gamePanel.getMenuState());
    }

    @Override
    public void goGame() {

    }

    @Override
    public void goGameOver() {

    }

    @Override
    public void goLeaderboard() {

    }
}
