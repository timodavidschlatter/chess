/*
 * Classname: Row
 *
 * Version information: 1.0
 *
 * Date: 25 May 2020
 *
 * Copyright notice: -
 */

package logic.board;

import javafx.scene.paint.Color;

/**
 * Class displays a row which contains tiles
 */
public class Row {

    private String numbering;
    private Tile[] tiles;
    private final Color black;
    private final Color white;
    private final int numOfTiles;


    /**
     * Initializes the row with numbering information, number of tiles and rowNumber info (for coloring)
     * @param numbering
     * @param numOfTiles
     * @param rowNumber
     */
    public Row(String numbering, int numOfTiles, int rowNumber) {
        this.numbering = numbering;
        this.numOfTiles = numOfTiles;
        this.tiles = new Tile[numOfTiles];
        this.black = Color.BLACK;
        this.white = Color.WHITE;
        createTiles(rowNumber);
    }

    /**
     * Initializes the tiles, colors them and adds them to the row
     * @param rowNumber
     */
    private void createTiles(int rowNumber) {
        Color color = rowNumber % 2 == 0 ? black : white;
        for(int i = 0; i < numOfTiles; i++) {
            color = color.equals(black) ? white : black;
            Tile t = new Tile(color, numbering);
            tiles[i] = t;
        }
    }

    /**
     * Returns a tile array
     * @return
     */
    public Tile[] getTiles() {
        return tiles;
    }
}
