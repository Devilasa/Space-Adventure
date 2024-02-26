package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends JFrame implements MouseListener {

    GamePanel gamePanel;

    public MouseHandler(GamePanel gamePanel) throws HeadlessException {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(gamePanel.getGameState().getClass().getSimpleName().equals("Menu") && gamePanel.getMenuDisplay().getPlayButton().contains(mouseEvent.getPoint())){
            gamePanel.getGameState().goGame();
        } else if(gamePanel.getGameState().getClass().getSimpleName().equals("Gameover") && gamePanel.getGameoverDisplay().getTryAgainButton().contains(mouseEvent.getPoint())){
            gamePanel.getGameState().goGame();
        } else if (gamePanel.getGameState().getClass().getSimpleName().equals("Gameover") && gamePanel.getGameoverDisplay().getGameOverBackButton().contains(mouseEvent.getPoint())){
            gamePanel.getGameState().goMenu();
        } else if (gamePanel.getGameState().getClass().getSimpleName().equals("Menu") && gamePanel.getMenuDisplay().getLeaderboardButton().contains(mouseEvent.getPoint())) {
            gamePanel.getGameState().goLeaderboard();
        } else if (gamePanel.getGameState().getClass().getSimpleName().equals("Leaderboard") && gamePanel.getLeaderboardDisplay().getLeaderboardBackButton().contains(mouseEvent.getPoint())) {
            gamePanel.getGameState().goMenu();
        } else if (gamePanel.getGameState().getClass().getSimpleName().equals("Menu") && gamePanel.getMenuDisplay().getExitButton().contains(mouseEvent.getPoint())) {
            System.exit(0);
        }
    }
}