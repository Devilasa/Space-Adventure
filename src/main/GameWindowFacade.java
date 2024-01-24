package main;

import javax.swing.*;

public class GameWindowFacade {
    private JFrame window;
    private GamePanel gamePanel;

    public GameWindowFacade() {
        window = new JFrame();
        gamePanel = new GamePanel();
        setWindow();
    }

    public void setWindow(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space Adventure");
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void start(){
        gamePanel.startGameThread();
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
