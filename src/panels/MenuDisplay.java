package panels;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class MenuDisplay extends JComponent {
    private TextField textField;
    private Rectangle playButton = new Rectangle(390, 320, 240, 70);
    private Rectangle exitButton = new Rectangle(390, 600, 230, 100);
    private Rectangle leaderboardButton = new Rectangle(180, 480, 665, 70);

    public MenuDisplay() {
        textField = new TextField();
        textField.setBounds(365, 170, 300, 60);
        textField.setFont(new Font("Algerian", Font.BOLD, 50));
        textField.setText("Guest1");
        textField.setBackground(Color.CYAN);
        textField.setVisible(true);
        add(textField, 0);
        validate();
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
        graphics2D.drawString("Play", playButton.x, playButton.y + 70);


        /* Leaderboard */
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 90));
        graphics2D.drawString("Leaderboard", leaderboardButton.x, leaderboardButton.y + 70);

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

    public Rectangle getPlayButton() {
        return playButton;
    }

    public void setPlayButton(Rectangle playButton) {
        this.playButton = playButton;
    }

    public Rectangle getExitButton() {
        return exitButton;
    }

    public void setExitButton(Rectangle exitButton) {
        this.exitButton = exitButton;
    }

    public Rectangle getLeaderboardButton() {
        return leaderboardButton;
    }

    public void setLeaderboardButton(Rectangle leaderboardButton) {
        this.leaderboardButton = leaderboardButton;
    }
}
