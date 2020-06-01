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
     * @param color
     * @param position
     */
    public Tile(Color color, String position) {
        this.color = color;
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
