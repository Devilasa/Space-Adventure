package main;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GameWindowFacade gameWindow = new GameWindowFacade();
        gameWindow.start();


    }
}
