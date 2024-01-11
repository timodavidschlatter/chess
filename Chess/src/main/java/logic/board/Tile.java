/*
 * Classname: Tile
 *
 * Version information: 1.0
 *
 * Date: 25 May 2020
 *
 * Copyright notice: -
 */

package logic.board;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Class displays a tile from the chessboard
 */
public class Tile extends StackPane {

    private Color color;
    private Position position;

    /**
     * Initialize tile with its color and position information
     * @param position
     */
    public Tile(Color color, Position position) {
        this.color = color;
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.position = position;
        this.setOnMouseClicked(this::handleMouseClick); // Add event handler for mouse click
    }

    private void handleMouseClick(MouseEvent mouseEvent) {
        Game.moveFigure(this);
    }

    /**
     * Sets position
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * returns position
     * @return
     */
    public Position getPosition() {
        return position;
    }
}
