package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        final int size = 8;
        GridPane chessBoard = new GridPane();
        chessBoard.minHeightProperty().bind(chessBoard.widthProperty());
        chessBoard.maxHeightProperty().bind(chessBoard.widthProperty());

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                StackPane tile = new StackPane();
                chessBoard.add(tile, i, j);
            }
        }

        main.getChildren().add(chessBoard);
    }
}
