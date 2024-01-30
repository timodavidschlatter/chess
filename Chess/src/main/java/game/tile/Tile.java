/*
 * Classname: Tile
 *
 * Version information: 1.0
 *
 * Date: 25 May 2020
 *
 * Copyright notice: -
 */

package game.tile;

import game.figure.Figure;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import logic.helper.Position;

import java.util.function.Consumer;

/**
 * Class displays a tile from the chessboard
 */
public class Tile {

    private final Position position;
    private final TileModel tileModel;
    private final TileView tileView;
    private final Consumer<Tile> moveFigure;
    private Figure childFigure;

    /**
     * Initialize tile with its color and position information
     * @param position
     */
    public Tile(Color color, Position position, Consumer<Tile> moveFigure) {
        this.position = position;
        this.tileModel = new TileModel();
        this.tileView = new TileView(tileModel, color, this::onMouseClick);
        this.moveFigure = moveFigure;
    }

    private void onMouseClick(Runnable runnable) {
        System.out.println("TIle was clicked.");
        moveFigure.accept(this);
    }

    public TileView getView() {
        return tileView;
    }

    public boolean hasChildren() {
        return tileModel.isHasFigure();
    }

    /**
     * returns position
     * @return
     */
    public Position getPosition() {
        return position;
    }


    public Figure getChildFigure() {
        return childFigure;
    }

    public void setChildFigure(Figure childFigure) {
        this.childFigure = childFigure;
    }
}
