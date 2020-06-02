package controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.board.Board;
import logic.board.Game;
import logic.board.Row;
import logic.board.Tile;

public class GameController extends Controller {

    @FXML
    private GridPane rowIdentifier;

    @FXML
    private GridPane chessBoard;

    @FXML
    private GridPane columnIdentifier;

    @FXML
    private void initialize() {
        createGameView();
    }

    private Game game;
    private Board board;
    private int numOfTiles;

    public GameController(ControlStation controlStation, Game game) {
        super(controlStation);
        this.game = new Game(); //TODO just for developing like this
        //this.game = game;
        this.board = this.game.getBoard();
        this.numOfTiles = board.getNumOfTiles();
    }

    /**
     * Add tiles to the gridpanes (rowIdentifier, columnIdentifier, chessboard)
     */
    private void createGameView() {

        setGridConstraints(0);

        for(int i = 0; i < numOfTiles; i++) {
            addTileToRowIdentifier(board.getRows()[i].getTiles()[0].getPosition().substring(1), i);
            addTileToColumnIdentifier(board.getRows()[0].getTiles()[i].getPosition().substring(0,1), i);
            chessBoard.addRow(i, board.getRows()[i].getTiles());
            setGridConstraints(1);
        }
    }

    /**
     * Set all row- and column- constraints for the gridpanes (rowIdentifier, columnIdentifier, chessboard)
     * @param i - 0: set row- /column- identifier to 100% width/height, 1: set tiles width / height according to number of tiles
     */
    private void setGridConstraints(int i) { //TODO - Switch cases are not object oriented programming (As my old java teacher told us)
        int percent = 100;
        switch(i) {
            case 0:
                rowIdentifier.getColumnConstraints().add(createColumnConstraints(percent));
                columnIdentifier.getRowConstraints().add(createRowConstraints(percent));
                break;
            case 1:
                percent /= numOfTiles;
                rowIdentifier.getRowConstraints().add(createRowConstraints(percent));
                columnIdentifier.getColumnConstraints().add(createColumnConstraints(percent));
                chessBoard.getColumnConstraints().add(createColumnConstraints(percent));
                chessBoard.getRowConstraints().add(createRowConstraints(percent));
                break;
        }
    }

    /**
     * Create rowconstraints with given double value as percent height
     * @param percentHeight
     * @return RowConstraints
     */
    private RowConstraints createRowConstraints(double percentHeight) {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(percentHeight);
        return rowConstraints;
    }

    /**
     * Create columnconstraints with given double value as percent width
     * @param percentWidth
     * @return ColumnConstraints
     */
    private ColumnConstraints createColumnConstraints(double percentWidth) {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(percentWidth);
        return columnConstraints;
    }

    /**
     * Create tile (Label) and add it to row identifier
     * @param text
     * @param position
     */
    private void addTileToRowIdentifier(String text, int position) {
        Label tile = createLabel(text, rowIdentifier.widthProperty());
        rowIdentifier.add(tile, 0, position);
    }

    /**
     * Create tile (Label) and add it to column identifier
     * @param text
     * @param position
     */
    private void addTileToColumnIdentifier(String text, int position) {
        Label tile = createLabel(text, columnIdentifier.widthProperty().divide(numOfTiles));
        columnIdentifier.add(tile, position, 0);
    }

    /**
     * Create Label and set prefered width property
     * @param text
     * @param observableValue
     * @return Label - with centered text
     */
    private Label createLabel(String text, ObservableValue observableValue) {
        Label label = new Label(text);
        label.prefWidthProperty().bind(observableValue);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    /**
     * Create tile (StackPane) and add it to chessboard
     * @param rowPos
     * @param colPos
     */
    private void addTileToChessboard(int rowPos, int colPos, Color color) {
        StackPane tile = new StackPane();
        tile.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        //tile.getChildren().add(new Label("\u2655"));
        chessBoard.add(tile, colPos, rowPos);
    }
}
