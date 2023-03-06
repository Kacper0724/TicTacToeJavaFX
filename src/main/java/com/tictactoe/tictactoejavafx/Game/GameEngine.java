package com.tictactoe.tictactoejavafx.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class GameEngine {
    GameResult gameResult = new GameResult();
    Font montserratBold = Font.loadFont("file:src/main/resources/font/Montserrat-Bold.ttf", 25);
    Font montserratRegular = Font.loadFont("file:src/main/resources/font/Montserrat-Regular.ttf", 20);
    private static final Image imageBackground = new Image("file:src/main/resources/background.png");
    public static String PLAYERONESHAPE;
    public static String PLAYERTWOSHAPE;
    public static int PLAYERONESCORE = 0;
    public static int PLAYERTWOORCPUSCORE = 0;
    String p2OrCpu = "";
    Label p1Shape;
    Label p2ShapeOrCpu;
    Button playButton = new Button("Play!");
    Button confirmButton = new Button("Confirm!");
    Button runGameButton = new Button("Run Game!");
    private Button[] buttonsArray;
    boolean endGame = false;
    int playerTurn = 0;
    public Parent mainMenu() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        column1.setPrefWidth(100);
        column2.setPrefWidth(200);
        column3.setPrefWidth(100);
        column1.setHalignment(HPos.CENTER);
        column2.setHalignment(HPos.CENTER);
        column3.setHalignment(HPos.CENTER);
        row1.setPrefHeight(50);
        row2.setPrefHeight(150);
        row3.setPrefHeight(100);
        row4.setPrefHeight(100);
        row1.setValignment(VPos.CENTER);
        row2.setValignment(VPos.CENTER);
        row3.setValignment(VPos.CENTER);
        row4.setValignment(VPos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.getColumnConstraints().add(column1);
        gridPane.getColumnConstraints().add(column2);
        gridPane.getColumnConstraints().add(column3);
        gridPane.getRowConstraints().add(row1);
        gridPane.getRowConstraints().add(row2);
        gridPane.getRowConstraints().add(row3);
        gridPane.getRowConstraints().add(row4);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        BackgroundSize backgroundSize = new BackgroundSize(100, 130, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        Label hello = new Label("Tic Tac Toe");
        hello.setFont(montserratBold);
        gridPane.add(hello, 1, 0);

        playButton.setPrefHeight(50);
        playButton.setPrefWidth(100);
        playButton.setStyle("-fx-background-color: #ffff");
        playButton.setOnMouseEntered(event -> playButton.setStyle("-fx-background-color: #6e6e6e"));
        playButton.setOnMouseExited(event -> playButton.setStyle("-fx-background-color: #ffff"));
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switchSceneToHowYouWantsToPlay();
                playButtonSound();
            }
        });
        playButton.setFont(montserratRegular);

        Button quitButton = new Button("Quit!");
        quitButton.setPrefHeight(50);
        quitButton.setPrefWidth(100);
        quitButton.setStyle("-fx-background-color: #ffff");
        quitButton.setOnMouseEntered(event -> quitButton.setStyle("-fx-background-color: #6e6e6e"));
        quitButton.setOnMouseExited(event -> quitButton.setStyle("-fx-background-color: #ffff"));
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
                playButtonSound();
            }
        });
        quitButton.setFont(montserratRegular);

        gridPane.add(playButton, 1, 2);
        gridPane.add(quitButton, 1, 3);

        return gridPane;
    }

    public Parent howYouWantsToPlay() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        column1.setPrefWidth(50);
        column2.setPrefWidth(300);
        column3.setPrefWidth(50);
        column1.setHalignment(HPos.CENTER);
        column2.setHalignment(HPos.CENTER);
        column3.setHalignment(HPos.CENTER);
        row1.setPrefHeight(50);
        row2.setPrefHeight(50);
        row3.setPrefHeight(100);
        row4.setPrefHeight(100);
        row5.setPrefHeight(100);
        row1.setValignment(VPos.CENTER);
        row2.setValignment(VPos.CENTER);
        row3.setValignment(VPos.CENTER);
        row4.setValignment(VPos.CENTER);
        row5.setValignment(VPos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.getColumnConstraints().add(column1);
        gridPane.getColumnConstraints().add(column2);
        gridPane.getColumnConstraints().add(column3);
        gridPane.getRowConstraints().add(row1);
        gridPane.getRowConstraints().add(row2);
        gridPane.getRowConstraints().add(row3);
        gridPane.getRowConstraints().add(row4);
        gridPane.getRowConstraints().add(row5);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        BackgroundSize backgroundSize = new BackgroundSize(100, 130, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        Label chooseWhatYouCanToPlay = new Label("How you want to play?");
        chooseWhatYouCanToPlay.setFont(montserratRegular);
        gridPane.add(chooseWhatYouCanToPlay, 1, 0);

        RadioButton playWithPlayerTwo = new RadioButton("With friend");
        playWithPlayerTwo.setFont(montserratRegular);

        RadioButton playWithCPU = new RadioButton("With computer");
        playWithCPU.setFont(montserratRegular);

        ToggleGroup toggleGroupHowWantsToPlay = new ToggleGroup();
        playWithPlayerTwo.setToggleGroup(toggleGroupHowWantsToPlay);
        playWithCPU.setToggleGroup(toggleGroupHowWantsToPlay);

        gridPane.add(playWithPlayerTwo, 1, 2);
        gridPane.add(playWithCPU, 1, 3);

        confirmButton.setPrefHeight(50);
        confirmButton.setPrefWidth(150);
        confirmButton.setStyle("-fx-background-color: #ffff");
        confirmButton.setOnMouseEntered(event -> confirmButton.setStyle("-fx-background-color: #6e6e6e"));
        confirmButton.setOnMouseExited(event -> confirmButton.setStyle("-fx-background-color: #ffff"));
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playButtonSound();
                if (toggleGroupHowWantsToPlay.getSelectedToggle() == playWithPlayerTwo) {
                    switchSceneToChooseShape();
                } else if (toggleGroupHowWantsToPlay.getSelectedToggle() == playWithCPU) {
                    PLAYERONESHAPE = "X";
                    PLAYERTWOSHAPE = "O";
                    p2OrCpu = "CPU";
                    printWinnerP2OrCPU();
                    howToPlayWithComputer();
                    switchSceneToBoard();
                } else {
                    Alert chooseHowYouWantsToPlay = new Alert(Alert.AlertType.CONFIRMATION, "Choose how you wants to play!", ButtonType.CLOSE);
                    chooseHowYouWantsToPlay.setTitle("Choose!");
                    chooseHowYouWantsToPlay.setHeaderText("Choose how you wants to play!");
                    chooseHowYouWantsToPlay.setContentText("You must choose how you wants to play!");
                    chooseHowYouWantsToPlay.show();
                }
            }
        });
        confirmButton.setFont(montserratRegular);

        gridPane.add(confirmButton, 1, 4);


        return gridPane;
    }

    public Parent chooseShapeScene() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        column1.setPrefWidth(50);
        column2.setPrefWidth(300);
        column3.setPrefWidth(50);
        column1.setHalignment(HPos.CENTER);
        column2.setHalignment(HPos.CENTER);
        column3.setHalignment(HPos.CENTER);
        row1.setPrefHeight(50);
        row2.setPrefHeight(50);
        row3.setPrefHeight(100);
        row4.setPrefHeight(100);
        row5.setPrefHeight(100);
        row1.setValignment(VPos.CENTER);
        row2.setValignment(VPos.CENTER);
        row3.setValignment(VPos.CENTER);
        row4.setValignment(VPos.CENTER);
        row5.setValignment(VPos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.getColumnConstraints().add(column1);
        gridPane.getColumnConstraints().add(column2);
        gridPane.getColumnConstraints().add(column3);
        gridPane.getRowConstraints().add(row1);
        gridPane.getRowConstraints().add(row2);
        gridPane.getRowConstraints().add(row3);
        gridPane.getRowConstraints().add(row4);
        gridPane.getRowConstraints().add(row5);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        BackgroundSize backgroundSize = new BackgroundSize(100, 130, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        Label playerOneShape = new Label("Player one shape:");
        playerOneShape.setFont(montserratRegular);
        gridPane.add(playerOneShape, 1, 0);

        RadioButton playerOneShapeX = new RadioButton("X");
        playerOneShapeX.setFont(montserratRegular);

        RadioButton playerOneShapeO = new RadioButton("O");
        playerOneShapeO.setFont(montserratRegular);

        ToggleGroup toggleGroupPlayerOneShape = new ToggleGroup();
        playerOneShapeX.setToggleGroup(toggleGroupPlayerOneShape);
        playerOneShapeO.setToggleGroup(toggleGroupPlayerOneShape);

        gridPane.add(playerOneShapeX, 1, 2);
        gridPane.add(playerOneShapeO, 1, 3);

        runGameButton.setPrefHeight(50);
        runGameButton.setPrefWidth(150);
        runGameButton.setStyle("-fx-background-color: #ffff");
        runGameButton.setOnMouseEntered(event -> runGameButton.setStyle("-fx-background-color: #6e6e6e"));
        runGameButton.setOnMouseExited(event -> runGameButton.setStyle("-fx-background-color: #ffff"));
        runGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playButtonSound();
                if (toggleGroupPlayerOneShape.getSelectedToggle() == playerOneShapeX) {
                    PLAYERONESHAPE = "X";
                    PLAYERTWOSHAPE = "O";
                    p2OrCpu = "P2";
                    switchSceneToBoardFromChooseShape();
                    tieSound();
                } else if (toggleGroupPlayerOneShape.getSelectedToggle() == playerOneShapeO) {
                    PLAYERONESHAPE = "O";
                    PLAYERTWOSHAPE = "X";
                    p2OrCpu = "P2";
                    switchSceneToBoardFromChooseShape();
                    tieSound();
                } else {
                    Alert chooseShapeAlert = new Alert(Alert.AlertType.CONFIRMATION, "Choose shape for player one!", ButtonType.CLOSE);
                    chooseShapeAlert.setTitle("Choose shape!");
                    chooseShapeAlert.setHeaderText("Choose shape!");
                    chooseShapeAlert.setContentText("Choose shape for player one!");
                    chooseShapeAlert.show();
                }
            }
        });
        runGameButton.setFont(montserratRegular);

        gridPane.add(runGameButton, 1, 4);

        return gridPane;
    }

    public Parent boardScene() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        column1.setPrefWidth(133);
        column2.setPrefWidth(133);
        column3.setPrefWidth(133);
        column1.setHalignment(HPos.CENTER);
        column2.setHalignment(HPos.CENTER);
        column3.setHalignment(HPos.CENTER);
        row1.setPrefHeight(100);
        row2.setPrefHeight(133);
        row3.setPrefHeight(133);
        row4.setPrefHeight(133);
        row5.setPrefHeight(100);
        row1.setValignment(VPos.CENTER);
        row2.setValignment(VPos.CENTER);
        row3.setValignment(VPos.CENTER);
        row4.setValignment(VPos.CENTER);
        row5.setValignment(VPos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.getColumnConstraints().add(column1);
        gridPane.getColumnConstraints().add(column2);
        gridPane.getColumnConstraints().add(column3);
        gridPane.getRowConstraints().add(row1);
        gridPane.getRowConstraints().add(row2);
        gridPane.getRowConstraints().add(row3);
        gridPane.getRowConstraints().add(row4);
        gridPane.getRowConstraints().add(row5);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        BackgroundSize backgroundSize = new BackgroundSize(100, 130, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        p1Shape = new Label("P1 = " + PLAYERONESHAPE);
        p2ShapeOrCpu = new Label(p2OrCpu + " = " + PLAYERTWOSHAPE);

        p1Shape.setFont(montserratBold);
        gridPane.add(p1Shape,0,0);

        p2ShapeOrCpu.setFont(montserratBold);
        gridPane.add(p2ShapeOrCpu, 2, 0);

        Label playersScore = new Label(PLAYERONESCORE + " - " + PLAYERTWOORCPUSCORE);
        playersScore.setFont(montserratRegular);
        gridPane.add(playersScore, 1, 0);

        buttonsArray = createButton();
        gridPane.add(buttonsArray[0],0,1);
        gridPane.add(buttonsArray[1],1,1);
        gridPane.add(buttonsArray[2],2,1);
        gridPane.add(buttonsArray[3],0,2);
        gridPane.add(buttonsArray[4],1,2);
        gridPane.add(buttonsArray[5],2,2);
        gridPane.add(buttonsArray[6],0,3);
        gridPane.add(buttonsArray[7],1,3);
        gridPane.add(buttonsArray[8],2,3);

        for (int i = 0; i < 9; i++) {
            buttonsArray[i].setFont(montserratBold);
            buttonsArray[i].setStyle("-fx-background-color: #ffff");
        }

        for (Button button : buttonsArray) {
            button.setOnMouseClicked(event -> {
                setPlayerSymbol(button, buttonsArray);
                endGame = gameResult.gameResultBoardForPlayWithFriend(buttonsArray);
                if (endGame) {
                    for (int i = 0; i < 9; i++) {
                        buttonsArray[i].setDisable(true);
                        buttonsArray[i].setOpacity(1);
                    }
                    playersScore.setText(PLAYERONESCORE + " - " + PLAYERTWOORCPUSCORE);
                }
                System.out.println(endGame + " " + PLAYERONESCORE + " " + PLAYERTWOORCPUSCORE);
            });
        }

        Button resetGameButton = new Button("Reset");
        resetGameButton.setPrefHeight(50);
        resetGameButton.setPrefWidth(100);
        resetGameButton.setStyle("-fx-background-color: #ffff");
        resetGameButton.setOnMouseEntered(event -> resetGameButton.setStyle("-fx-background-color: #6e6e6e"));
        resetGameButton.setOnMouseExited(event -> resetGameButton.setStyle("-fx-background-color: #ffff"));
        resetGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cleanBoard();
                playButtonSound();
            }
        });
        resetGameButton.setFont(montserratRegular);

        gridPane.add(resetGameButton, 0,4);

        Button exitGameButton = new Button("Exit");
        exitGameButton.setPrefHeight(50);
        exitGameButton.setPrefWidth(100);
        exitGameButton.setStyle("-fx-background-color: #ffff");
        exitGameButton.setOnMouseEntered(event -> exitGameButton.setStyle("-fx-background-color: #6e6e6e"));
        exitGameButton.setOnMouseExited(event -> exitGameButton.setStyle("-fx-background-color: #ffff"));
        exitGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
                playButtonSound();
            }
        });
        exitGameButton.setFont(montserratRegular);

        gridPane.add(exitGameButton, 2, 4);

        return gridPane;
    }

    public Button[] createButton() {
        Button[] buttonsArray = new Button[9];

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setMinSize(100, 100);
            button.setId(String.valueOf(i + 1));
            buttonsArray[i] = button;
        }
        return buttonsArray;
    }

    public void cleanBoard() {
       for (Button button : buttonsArray) {
           button.setDisable(false);
           button.setText("");
       }
    }

    public void switchSceneToHowYouWantsToPlay() {
        Scene howYouWantsToPlay = new Scene(howYouWantsToPlay(), 400, 500);

        Stage window = (Stage) playButton.getScene().getWindow();
        window.setScene(howYouWantsToPlay);
    }

    public void switchSceneToChooseShape() {
        Scene chooseShapeScene = new Scene(chooseShapeScene(), 400, 500);

        Stage window = (Stage) confirmButton.getScene().getWindow();
        window.setScene(chooseShapeScene);
    }

    public void switchSceneToBoard() {
        Scene boardScene = new Scene(boardScene(), 400, 500);

        Stage window = (Stage) confirmButton.getScene().getWindow();
        window.setScene(boardScene);
    }

    public void switchSceneToBoardFromChooseShape(){
        Scene boardScene = new Scene(boardScene(), 400, 500);

        Stage window = (Stage) runGameButton.getScene().getWindow();
        window.setScene(boardScene);
    }

    public void playerOneMove(Button button) {
        button.setText(PLAYERONESHAPE);
        button.setDisable(true);
        button.setOpacity(0.8);
        shapeChoseSound();
    }

    public void playerTwoMove(Button button) {
        button.setText(PLAYERTWOSHAPE);
        button.setDisable(true);
        button.setOpacity(0.8);
        shapeChoseSound();
    }

    public boolean cpuMoveValidator(Button[] buttonsArray, int move) {
        for (int i = 0; i < 9; i++) {
            if (buttonsArray[move].getText() == "") {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void cpuMove(Button[] buttonsArray) {
        Random randomGenerator = new Random();
        int move = randomGenerator.nextInt(8);
        boolean moveValidator = cpuMoveValidator(buttonsArray, move);
        while(!moveValidator) {
            move = randomGenerator.nextInt(8);
            moveValidator = cpuMoveValidator(buttonsArray, move);
        }
        buttonsArray[move].setText(PLAYERTWOSHAPE);
        buttonsArray[move].setDisable(true);
        buttonsArray[move].setOpacity(0.8);
        shapeChoseSound();
    }

    public void setPlayerSymbol(Button button, Button[] buttonsArray) {
        if (playerTurn % 2 == 0) {
            p1Shape.setUnderline(false);
            p2ShapeOrCpu.setUnderline(true);
            playerOneMove(button);
            playerTurn = 1;
        } else if (p2OrCpu == " CPU"){
            p1Shape.setUnderline(true);
            p2ShapeOrCpu.setUnderline(false);
            cpuMove(buttonsArray);
            playerTurn = 0;
        } else {
            p1Shape.setUnderline(true);
            p2ShapeOrCpu.setUnderline(false);
            playerTwoMove(button);
            playerTurn = 0;
        }
    }

    public void printWinnerP2OrCPU() {
        if (p2OrCpu == "CPU") {
            p2OrCpu = " CPU";
        } else {
            p2OrCpu = " P2";
        }
    }

    public void howToPlayWithComputer() {
        Alert howToPlayWithComputer = new Alert(Alert.AlertType.CONFIRMATION, "How to play with computer!", ButtonType.APPLY);
        howToPlayWithComputer.setTitle("How to play!");
        howToPlayWithComputer.setHeaderText("How to play with computer?");
        howToPlayWithComputer.setContentText("If you make a move then you have to press on an empty field then the computer will make any move.");
        howToPlayWithComputer.show();
        tieSound();
    }

    private void playButtonSound() {
        AudioClip btnSound = new AudioClip("file:src/main/resources/audio/ButtonMouse.wav");
        btnSound.setVolume(150);
        btnSound.play();
    }

    private void shapeChoseSound() {
        AudioClip btnSound = new AudioClip("file:src/main/resources/audio/ShapeChose.mp3");
        btnSound.play();
    }

    public static void victorySound() {
        AudioClip victory = new AudioClip("file:src/main/resources/audio/VictorySound.mp3");
        victory.play();
    }

    public static void tieSound() {
        AudioClip tie = new AudioClip("file:src/main/resources/audio/TieSound.mp3");
        tie.play();
    }
}