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
    private void createBoard() { //TODO Maybe better solution than this? Performancewise. Not to amused about this
        for(int i = 0; i < numOfTiles; i++) {
            rows[i] = new Row(numOfTiles - i + "", numOfTiles, i);
        }
        for(int i = 0; i < numOfTiles; i++) {
            columns[i] = new Column(columnNumbering[i], numOfTiles);
            for(int j = 0; j < numOfTiles; j++) {
                columns[i].addTileToColumn(j, rows[j].getTiles()[i]);
            }
            columns[i].addNumberingToTiles();
        }
    }


    /**
     * returns rows
     * @return
     */
    public Row[] getRows() {
        return rows;
    }

    /**
     * returns columns
     * @return
     */
    public Column[] getColumns() {
        return columns;
    }

    /**
     * returns number of tiles (per row/column)
     * @return
     */
    public int getNumOfTiles() {
        return numOfTiles;
    }
}
