package game;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class GameFxmlController {

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
        //createBoard();
        //addFigures();
        createGameView();
    }

    // TODO remove all 8 with a variable given by the controller

    public void addTileToChessBoard(StackPane tileView, int x, int y) {
        //Adding Changelistener to the tiles and resize figures according to it - TODO: WTF? Was ist das ?
        if(tileView.getChildren().toArray().length > 0) {
            Label l = (Label) tileView.getChildren().get(0);
            tileView.widthProperty().addListener((o, oldVal, newVal) -> {
                l.setFont(Font.font(tileView.getWidth() / 2));
                tileView.getChildren().remove(0);
                tileView.getChildren().add(l);
            });
        }
        tileView.setId("tile-" + x + y);
        chessBoard.add(tileView, x, y);
    }

    /**
     * Add tiles to the gridpanes (rowIdentifier, columnIdentifier, chessboard)
     */
    private void createGameView() {
        rowIdentifier.getColumnConstraints().add(createColumnConstraints(100));
        columnIdentifier.getRowConstraints().add(createRowConstraints(100));
        createBenches();

        for(int i = 0; i < 8; i++) {
            addTileToRowIdentifier(8 - 1 - i + "", i);
            addTileToColumnIdentifier(i + "", i);
            setGridConstraints(100);
        }
    }

    /**
     * Creates the benches for killed figures
     */
    private void createBenches() {
        int numOfCol = 2;
        int percentHeight = 100 / 8;
        int percentWidth = 100 / numOfCol;

        for(int i = 0; i < numOfCol; i++) {
            for(int j = 0; j < 8; j++) {
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
        percent /= 8;
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
        Label tile = createLabel(text, columnIdentifier.widthProperty().divide(8));
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




    public void addFiguresToChessBoard(StackPane tileView, Region figureView) {
        // TODO Size of figures on board
        /*VBox.setVgrow(figureView, Priority.ALWAYS);
        HBox.setHgrow(figureView, Priority.ALWAYS);
        figureView.prefWidthProperty().bind(columnIdentifier.widthProperty().divide(8));
        figureView.prefHeightProperty().bind(rowIdentifier.widthProperty().divide(8));*/
        tileView.getChildren().add(figureView);

    }

    public void moveFigure(StackPane oldTile, StackPane newTile, Region figureView) {
        oldTile.getChildren().clear(); // Remove the figure from the start tile.
        newTile.getChildren().clear(); // Remove ('kill') the figure that is currently on the tile (if any).
        newTile.getChildren().add(figureView); // Add the figure to the clicked tile.
    }
}
