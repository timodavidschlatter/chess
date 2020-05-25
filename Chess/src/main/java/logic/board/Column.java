/*
 * Classname: Column
 *
 * Version information: 1.0
 *
 * Date: 25 May 2020
 *
 * Copyright notice: -
 */

package logic.board;

/**
 * Class displays a column which contains tiles
 */
public class Column {

    private String numbering;
    private Tile[] tiles;
    private final int numOfTiles;

    /**
     * Initalizes column with numbering information, number of tiles and all tiles to add
     * @param numbering
     * @param numOfTiles
     * @param tiles
     */
    public Column(String numbering, int numOfTiles, Tile[] tiles) {
        this.numbering = numbering;
        this.numOfTiles = numOfTiles;
        this.tiles = new Tile[numOfTiles];
        addTiles(tiles); //Necessary?
    }

    /**
     * Adds the tiles to the column
     * @param tiles
     */
    private void addTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
}
