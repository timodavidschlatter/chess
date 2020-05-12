package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class GameController {

    @FXML
    private GridPane rowIdentifier;

    @FXML
    private GridPane chessBoard;

    @FXML
    private GridPane columnIdentifier;

    private final int numOfTiles = 8;


    @FXML
    private void initialize() {
        createRowsIdentifier();
        createChessBoard();
        createColumnIdentifier();
    }

    /**
     * Creates the Chessboard (GridPane)
     */
    private void createChessBoard() {
        //chessBoard.minHeightProperty().bind(chessBoard.widthProperty());
        //chessBoard.maxHeightProperty().bind(chessBoard.widthProperty());

        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(12.5);

        RowConstraints row = new RowConstraints();
        row.setPercentHeight(12.5);
        //row.maxHeightProperty().bind(chessBoard.widthProperty().divide(8));
        //row.minHeightProperty().bind(chessBoard.widthProperty().divide(8));

        for(int i = 0; i < numOfTiles; i++) {
            chessBoard.getColumnConstraints().add(column);
            chessBoard.getRowConstraints().add(row);
            for(int j = 0; j < numOfTiles; j++) {
                //StackPane tile = new StackPane();
                Label tile = new Label("Hallo");
                chessBoard.add(tile, i, j);
            }
        }
    }

    private void createRowsIdentifier() {
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(100);
        rowIdentifier.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(12.5);
        for(int i = 0; i < numOfTiles; i++) {
            rowIdentifier.getRowConstraints().add(row);
            Label tile = new Label((numOfTiles - i) + "");
            rowIdentifier.add(tile, 0, i);
        }
    }

    private void createColumnIdentifier() {
        String[] columnText = {"A", "B", "C", "D", "E", "F", "G", "H"};

        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100);
        columnIdentifier.getRowConstraints().add(row);
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(12.5);

        for(int i = 0; i < numOfTiles; i++) {
            columnIdentifier.getColumnConstraints().add(column);
            Label tile = new Label(columnText[i]);
            columnIdentifier.add(tile, i, 0);
        }
    }
}
