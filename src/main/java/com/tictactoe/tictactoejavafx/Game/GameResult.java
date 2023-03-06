package com.tictactoe.tictactoejavafx.Game;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import static com.tictactoe.tictactoejavafx.Game.GameEngine.*;

public class GameResult {
    public boolean gameResultBoardForPlayWithFriend(Button[] buttonArray) {
        if (buttonArray[0].getText().equals("X") && buttonArray[1].getText().equals("X") && buttonArray[2].getText().equals("X") ||
                buttonArray[3].getText().equals("X") && buttonArray[4].getText().equals("X") && buttonArray[5].getText().equals("X") ||
                buttonArray[6].getText().equals("X") && buttonArray[7].getText().equals("X") && buttonArray[8].getText().equals("X")) {
            if (PLAYERONESHAPE == "X") {
                PLAYERONESCORE++;
            } else {
                PLAYERTWOORCPUSCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText().equals("O") && buttonArray[1].getText().equals("O") && buttonArray[2].getText().equals("O") ||
                buttonArray[3].getText().equals("O") && buttonArray[4].getText().equals("O") && buttonArray[5].getText().equals("O") ||
                buttonArray[6].getText().equals("O") && buttonArray[7].getText().equals("O") && buttonArray[8].getText().equals("O")) {
            if (PLAYERTWOSHAPE == "O") {
                PLAYERTWOORCPUSCORE++;
            } else {
                PLAYERONESCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText().equals("X") && buttonArray[3].getText().equals("X") && buttonArray[6].getText().equals("X") ||
                buttonArray[1].getText().equals("X") && buttonArray[4].getText().equals("X") && buttonArray[7].getText().equals("X") ||
                buttonArray[2].getText().equals("X") && buttonArray[5].getText().equals("X") && buttonArray[8].getText().equals("X")) {
            if (PLAYERONESHAPE == "X") {
                PLAYERONESCORE++;
            } else {
                PLAYERTWOORCPUSCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText().equals("O") && buttonArray[3].getText().equals("O") && buttonArray[6].getText().equals("O") ||
                buttonArray[1].getText().equals("O") && buttonArray[4].getText().equals("O") && buttonArray[7].getText().equals("O") ||
                buttonArray[2].getText().equals("O") && buttonArray[5].getText().equals("O") && buttonArray[8].getText().equals("O")) {
            if (PLAYERTWOSHAPE == "O") {
                PLAYERTWOORCPUSCORE++;
            } else {
                PLAYERONESCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText().equals("X") && buttonArray[4].getText().equals("X") && buttonArray[8].getText().equals("X") ||
        buttonArray[2].getText().equals("X") && buttonArray[4].getText().equals("X") && buttonArray[6].getText().equals("X")) {
            if (PLAYERONESHAPE == "X") {
                PLAYERONESCORE++;
            } else {
                PLAYERTWOORCPUSCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText().equals("O") && buttonArray[4].getText().equals("O") && buttonArray[8].getText().equals("O") ||
                buttonArray[2].getText().equals("O") && buttonArray[4].getText().equals("O") && buttonArray[6].getText().equals("O")) {
            if (PLAYERTWOSHAPE == "O") {
                PLAYERTWOORCPUSCORE++;
            } else {
                PLAYERONESCORE++;
            }
            victorySound();
            return true;
        }
        if (buttonArray[0].getText() != ("") && buttonArray[1].getText() != ("") && buttonArray[2].getText() != ("") &&
                buttonArray[3].getText() != ("") && buttonArray[4].getText() != ("") && buttonArray[5].getText() != ("") &&
                buttonArray[6].getText() != ("") && buttonArray[7].getText() != ("") && buttonArray[8].getText() != ("")) {
            Alert tieAlert = new Alert(Alert.AlertType.CONFIRMATION, "TIE!", ButtonType.CLOSE);
            tieAlert.setTitle("Tie!");
            tieAlert.setHeaderText("Tie!");
            tieAlert.setContentText("There is a tie!");
            tieAlert.show();
            tieSound();
            return true;
        }
        return false;
    }
}
