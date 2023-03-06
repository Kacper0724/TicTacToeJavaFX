package com.tictactoe.tictactoejavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.tictactoe.tictactoejavafx.Game.GameEngine;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameEngine gameEngine = new GameEngine();
        Scene mainMenuScene = new Scene(gameEngine.mainMenu(), 400, 500);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
}
