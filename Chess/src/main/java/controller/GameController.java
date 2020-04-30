package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class GameController {

    @FXML
    private HBox main;

    @FXML
    private void initialize() {
        createChessBoard();
    }

    /**
     *
     */
    private void createChessBoard() {
        GridPane chessBoard = new GridPane();
        int a = 8;
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < a; j++) {
                //StackPane tile = new StackPane();
                Button tile = new Button("Fuck You");
                chessBoard.add(tile, i, j);
            }
        }
        main.getChildren().add(chessBoard);
    }



}
