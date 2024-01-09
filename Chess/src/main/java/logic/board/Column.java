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

    /**
     * Initalizes column with numbering information and all tiles to add
     * @param numbering
     * @param numOfTiles
     */
    public Column(String numbering, int numOfTiles) {
        this.numbering = numbering;
        this.tiles = new Tile[numOfTiles];
        //this.tiles = tiles;
        //addNumberingToTiles();
    }

    /**
     * Adds the numbering of the columns to the tiles
     */
    public void addNumberingToTiles() {
        for(Tile tile : tiles) {
            tile.setPosition(numbering + tile.getPosition());
        }
    }

    /**
     * Adds tile to column
     * @param i
     */
    public void addTileToColumn(int i, Tile tile) {
        tiles[i] = tile;
    }
}
