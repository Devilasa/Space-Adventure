package gameStates;

public interface GameState {
    void update();
    void goMenu();
    void goGame();
    void goGameOver();
}
