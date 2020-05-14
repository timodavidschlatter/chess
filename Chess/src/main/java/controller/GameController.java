package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

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
        createGameView();
    }

    /**
     *
     */
    private void createGameView() {
        String[] columnIdentifierText = {"A", "B", "C", "D", "E", "F", "G", "H"};
        ColumnConstraints columnConstraints = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();

        columnConstraints.setPercentWidth(12.5);
        rowConstraints.setPercentHeight(12.5);

        for(int i = 0; i < numOfTiles; i++) {
            addTileToRowIdentifier((numOfTiles - i) + "", i, rowConstraints);
            addTileToColumnIdentifier(columnIdentifierText[i], i, columnConstraints);
            for(int j = 0; j < numOfTiles; j++) {
                addTileToChessboard(i, j);
            }
            // Not to happy about those lines about columnconstraints here. TODO
            chessBoard.getColumnConstraints().add(columnConstraints);
            chessBoard.getRowConstraints().add(rowConstraints);
        }
        columnConstraints.setPercentWidth(100);
        rowIdentifier.getColumnConstraints().add(columnConstraints);
        rowConstraints.setPercentHeight(100);
        columnIdentifier.getRowConstraints().add(rowConstraints);
    }

    /**
     *
     * @param text
     * @param position
     * @param rowConstraints
     */
    private void addTileToRowIdentifier(String text, int position, RowConstraints rowConstraints) {
        Label tile = new Label(text);
        tile.prefWidthProperty().bind(rowIdentifier.widthProperty().divide(numOfTiles));
        tile.setAlignment(Pos.CENTER);
        rowIdentifier.getRowConstraints().add(rowConstraints);
        rowIdentifier.add(tile, 0, position);
    }

    /**
     *
     * @param text
     * @param position
     * @param columnConstraints
     */
    private void addTileToColumnIdentifier(String text, int position, ColumnConstraints columnConstraints) {
        Label tile = new Label(text);
        tile.prefWidthProperty().bind(columnIdentifier.widthProperty().divide(numOfTiles));
        tile.setAlignment(Pos.CENTER);
        columnIdentifier.getColumnConstraints().add(columnConstraints);
        columnIdentifier.add(tile, position, 0);
    }

    /**
     *
     * @param rowPos
     * @param colPos
     */
    private void addTileToChessboard(int rowPos, int colPos) {
        StackPane tile = new StackPane();
        chessBoard.add(tile, colPos, rowPos);
    }
}
