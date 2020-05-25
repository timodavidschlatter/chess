/*
 * Classname: Board
 *
 * Version information: 1.0
 *
 * Date: 25 May 2020
 *
 * Copyright notice: -
 */

package logic.board;

/**
 * Class displays a board which contains rows and columns
 */
public class Board {

    private Row[] rows;
    private Column[] columns;
    private final int numOfTiles;
    private final String[] columnNumbering;

    /**
     * Initializes the board which contains rows and columns. Sets number of tiles and column numbering.
     */
    public Board() {
        this.numOfTiles = 8;
        this.columnNumbering = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        this.rows = new Row[numOfTiles];
        this.columns = new Column[numOfTiles];
        createBoard();
    }

    /**
     * Creates multiple rows and columns and adds them to the board
     */
    private void createBoard() {
        for(int i = 0; i < numOfTiles; i++) {
            rows[i] = createRow(numOfTiles - i + "");
            columns[i] = defineColumn(columnNumbering[i], rows[i].getTiles());
        }
    }

    /**
     * Creates a row
     * @param numbering
     * @return Row
     */
    private Row createRow(String numbering) {
        return new Row(numbering, numOfTiles);
    }

    /**
     * Creates a column
     * @param numbering
     * @param tiles
     * @return Column
     */
    private Column defineColumn(String numbering, Tile[] tiles) {
        return new Column(numbering, numOfTiles, tiles);
    }
}
