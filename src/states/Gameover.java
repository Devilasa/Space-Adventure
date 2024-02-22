package states;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.GamePanel.*;

public class Gameover implements State{
    private GamePanel gamePanel;
    BufferedImage back;
    BufferedImage gameover;
    BufferedImage tryAgain;
    private int scale = 0;

    public Gameover(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        try {
            gameover = ImageIO.read(new File("res/writings/game_over.png"));
            back = ImageIO.read(new File("res/writings/back.png"));
            tryAgain = ImageIO.read(new File("res/writings/try_again.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if(scale < 500){
            scale += 2;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(gameover, 480 - (scale / 2), 360 - (scale / 2), gameover.getWidth() + scale, gameover.getHeight() + scale, null);
        graphics2D.drawImage(back, 910 - (scale / 2), 530 - (scale / 2), back.getWidth() + scale - 50, back.getHeight() + scale - 50, null);
        graphics2D.drawImage(tryAgain, 280 - (scale / 2), 530 - (scale / 2), tryAgain.getWidth() + scale - 50, tryAgain.getHeight() + scale - 50, null);
        graphics2D.setColor(Color.white);
        graphics2D.setFont(new Font("Arial", Font.BOLD, 50));
        graphics2D.drawString(gamePanel.getScore().toString(), screenWidth/2 - SCREEN_SHIFT_X, SCREEN_SHIFT_Y);
    }
}