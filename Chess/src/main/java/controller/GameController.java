package controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.board.Board;
import logic.board.Game;
import logic.board.Tile;

public class GameController extends Controller {

    @FXML
    private GridPane rowIdentifier;

    @FXML
    private GridPane chessBoard;

    @FXML
    private GridPane columnIdentifier;

    @FXML
    private GridPane blackBench;

    @FXML
    private GridPane whiteBench;

    @FXML
    private void initialize() {
        createGameView();
    }

    private final Game game;
    private final Board board;
    private final int numOfTiles;

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
        int percent = 100;
        rowIdentifier.getColumnConstraints().add(createColumnConstraints(percent));
        columnIdentifier.getRowConstraints().add(createRowConstraints(percent));
        createBenches();

        for(int i = 0; i < numOfTiles; i++) {
            addTileToRowIdentifier(numOfTiles - 1 - i + "", i);
            addTileToColumnIdentifier(i + "", i);

            for(int j = 0; j < numOfTiles; j++) {
                //Adding Changelistener to the tiles and resize figures according to it - TODO could be done better I think
                Tile t = board.getRows()[i].getTiles()[j];
                if(t.getChildren().toArray().length > 0) {
                    Label l = (Label) t.getChildren().get(0);
                    t.widthProperty().addListener((o, oldVal, newVal) -> {
                        l.setFont(Font.font(t.getWidth() / 2));
                        t.getChildren().remove(0);
                        t.getChildren().add(l);
                    });
                }
                chessBoard.add(t, j, i);
            }
            setGridConstraints(percent);
        }
    }

    /**
     * Creates the benches for killed figures
     */
    private void createBenches() {
        int numOfCol = 2;
        int percentHeight = 100 / numOfTiles;
        int percentWidth = 100 / numOfCol;

        for(int i = 0; i < numOfCol; i++) {
            for(int j = 0; j < numOfTiles; j++) {
                blackBench.add(new Label(), i, j);
                whiteBench.add(new Label(), i, j);
                if(i == 1) {    //TODO
                    blackBench.getRowConstraints().add(createRowConstraints(percentHeight));
                    whiteBench.getRowConstraints().add(createRowConstraints(percentHeight));
                }
            }
            blackBench.getColumnConstraints().add(createColumnConstraints(percentWidth));
            whiteBench.getColumnConstraints().add(createColumnConstraints(percentWidth));
        }

    }

    /**
     * Set all row- and column- constraints for the gridpanes (rowIdentifier, columnIdentifier, chessboard)
     * @param percent - 0: set row- /column- identifier to 100% width/height, 1: set tiles width / height according to number of tiles
     */
    private void setGridConstraints(int percent) {
        percent /= numOfTiles;
        rowIdentifier.getRowConstraints().add(createRowConstraints(percent));
        columnIdentifier.getColumnConstraints().add(createColumnConstraints(percent));
        chessBoard.getColumnConstraints().add(createColumnConstraints(percent));
        chessBoard.getRowConstraints().add(createRowConstraints(percent));
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
        chessBoard.add(tile, colPos, rowPos);
    }
}
