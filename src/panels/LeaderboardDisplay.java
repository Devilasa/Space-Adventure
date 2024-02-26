package panels;

import javax.swing.*;
import java.awt.*;

import static main.GamePanel.SCREEN_SHIFT_Y;

public class LeaderboardDisplay extends JComponent {
    private Rectangle leaderboardBackButton = new Rectangle(860, 700, 140, 40);

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        int height = 0;
        for(int count = 1; count < 8; ++count) {
            String rank = count + ".";
            String user = "user";
            String score = "score";

            /* Rank */
            graphics2D.setColor(Color.yellow);
            graphics2D.setFont(new Font("Algerian", Font.BOLD, 50));
            graphics2D.drawString(rank, 30, SCREEN_SHIFT_Y + height);

            /* Username */
            graphics2D.setColor(Color.yellow);
            graphics2D.setFont(new Font("Algerian", Font.BOLD, 50));
            graphics2D.drawString(user, 130, SCREEN_SHIFT_Y + height);

            /* Score */
            graphics2D.setColor(Color.yellow);
            graphics2D.setFont(new Font("Algerian", Font.BOLD, 50));
            graphics2D.drawString(score, 580, SCREEN_SHIFT_Y + height);

            /* Back */
            graphics2D.setColor(Color.yellow);
            graphics2D.setFont(new Font("Algerian", Font.BOLD, 50));
            graphics2D.drawString("Back", leaderboardBackButton.x, leaderboardBackButton.y + 40);

            height += 100;
        }
        graphics2D.dispose();
    }

    public Rectangle getLeaderboardBackButton() {
        return leaderboardBackButton;
    }

    public void setLeaderboardBackButton(Rectangle leaderboardBackButton) {
        this.leaderboardBackButton = leaderboardBackButton;
    }
}
