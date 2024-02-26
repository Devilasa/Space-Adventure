package panels;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static main.GamePanel.SCREEN_SHIFT_Y;

public class LeaderboardDisplay extends JComponent {
    private GamePanel gamePanel;
    private Rectangle leaderboardBackButton = new Rectangle(860, 700, 140, 40);
    private Map<Integer, String> resultMap = new HashMap<>();
    private List<Integer> sortedScoreList;

    public LeaderboardDisplay(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void update(){
        resultMap.put(gamePanel.getScore(), gamePanel.getMenuDisplay().getTextField().getText());
        sortedScoreList = new ArrayList<>(resultMap.keySet().stream().sorted(Comparator.reverseOrder()).toList());
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;


        int height = 0;
        for(int count = 0; count < resultMap.size(); ++count){
            String rank = count + 1 + ".";
            String score = sortedScoreList.get(count).toString();
            String user = resultMap.get(Integer.parseInt(score));

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

        /* Back */
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Algerian", Font.BOLD, 50));
        graphics2D.drawString("Back", leaderboardBackButton.x, leaderboardBackButton.y + 40);

        graphics2D.dispose();
    }

    public Rectangle getLeaderboardBackButton() {
        return leaderboardBackButton;
    }

    public void setLeaderboardBackButton(Rectangle leaderboardBackButton) {
        this.leaderboardBackButton = leaderboardBackButton;
    }

    public Map<Integer, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<Integer, String> resultMap) {
        this.resultMap = resultMap;
    }
}
