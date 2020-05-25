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
    private final int numOfTiles;

    /**
     * Initializes the row with numbering information, number of tiles
     * @param numbering
     * @param numOfTiles
     */
    public Row(String numbering, int numOfTiles) {
        this.numbering = numbering;
        this.numOfTiles = numOfTiles;
        this.tiles = new Tile[numOfTiles];
        createTiles();
    }

    /**
     * Initializes the tiles and adds them to the row
     */
    private void createTiles() {
        for(int i = 0; i < numOfTiles; i++) {
            Color c = i % 2 == 0 ? Color.BLACK : Color.WHITE; //TODO
            Tile t = new Tile(c, numbering);
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
