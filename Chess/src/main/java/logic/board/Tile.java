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
    private String position;

    /**
     * Initialize tile with its color and position information
     * @param position
     */
    public Tile(Color color, String position) {
        this.color = color;
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.position = position;
    }

    /**
     * Sets position
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * returns position
     * @return
     */
    public String getPosition() {
        return position;
    }
}
