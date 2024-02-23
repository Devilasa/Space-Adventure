package main;

import javax.swing.*;
import java.awt.*;

import static main.GamePanel.*;

public class MenuDisplay extends JComponent {
    private TextField textField;
    private Rectangle menuPlayButton = new Rectangle(390, 320, 240, 70);
    private Rectangle exitButton = new Rectangle(390, 600, 230, 100);
    private Rectangle menuLeaderboardButton = new Rectangle(180, 480, 665, 70);
    private GamePanel gamePanel;

    public MenuDisplay(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        textField = new TextField();
        textField.setBounds(365, 170, 300, 60);
        textField.setFont(new Font("Algerian", Font.BOLD, 50));
        textField.setText("Guest1");
        textField.setBackground(Color.CYAN);
        textField.setVisible(true);
        //add(textField, 0);
        //validate();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        /* Player :*/
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 80));
        graphics2D.drawString("Player :", 340, 100);

        /* Play */
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 90));
        graphics2D.drawString("Play", menuPlayButton.x, menuPlayButton.y + 70);


        /* Leaderboard */
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 90));
        graphics2D.drawString("Leaderboard", menuLeaderboardButton.x, menuLeaderboardButton.y + 70);

        /* Exit */
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 100));
        graphics2D.drawString("Exit", exitButton.x, exitButton.y + 100);


        graphics2D.dispose();
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Rectangle getMenuPlayButton() {
        return menuPlayButton;
    }

    public void setMenuPlayButton(Rectangle menuPlayButton) {
        this.menuPlayButton = menuPlayButton;
    }

    public Rectangle getExitButton() {
        return exitButton;
    }

    public void setExitButton(Rectangle exitButton) {
        this.exitButton = exitButton;
    }

    public Rectangle getMenuLeaderboardButton() {
        return menuLeaderboardButton;
    }

    public void setMenuLeaderboardButton(Rectangle menuLeaderboardButton) {
        this.menuLeaderboardButton = menuLeaderboardButton;
    }
}
