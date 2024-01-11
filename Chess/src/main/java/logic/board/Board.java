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

import javafx.scene.paint.Color;
import logic.figures.*;

/**
 * Class displays a board which contains rows and columns
 */
public class Board {

    private Row[] rows;
    private final int numOfTiles = 8;

    /**
     * Initializes the board which contains rows and columns. Sets number of tiles and column numbering.
     */
    public Board() {
        this.rows = new Row[numOfTiles];
        createBoard();
        addFigures();
    }

    /**
     * Creates multiple rows and columns and adds them to the board
     */
    private void createBoard() { //TODO Maybe better solution than this? Performancewise. Not too amused about this
        for(int i = 0; i < numOfTiles; i++) {
            rows[i] = new Row(numOfTiles - 1 - i, numOfTiles, i);
        }
    }

    // TODO Enhance code, (remove switch case) use OO, remove redundancy
    private void addFigures() {
        int rowWhiteFigures = 7, rowWhitePawns = 6;
        int rowBlackFigures = 0, rowBlackPawns = 1;

        for(int i = 0; i < numOfTiles; i++) {
            rows[rowWhitePawns].getTiles()[i].getChildren().add(new Pawn(Color.WHITE, rows[rowWhitePawns].getTiles()[i].getPosition())); //White pawns
            rows[rowBlackPawns].getTiles()[i].getChildren().add(new Pawn(Color.BLACK, rows[rowBlackPawns].getTiles()[i].getPosition())); //Black pawns
            switch(i) {
                case 0:
                case 7:
                    rows[rowWhiteFigures].getTiles()[i].getChildren().add(new Rook(Color.WHITE, rows[rowWhiteFigures].getTiles()[i].getPosition())); //White Rook
                    rows[rowBlackFigures].getTiles()[i].getChildren().add(new Rook(Color.BLACK, rows[rowBlackFigures].getTiles()[i].getPosition())); //Black Rook
                    break;
                case 1:
                case 6:
                    rows[rowWhiteFigures].getTiles()[i].getChildren().add(new Knight(Color.WHITE, rows[rowWhiteFigures].getTiles()[i].getPosition())); //White Knight
                    rows[rowBlackFigures].getTiles()[i].getChildren().add(new Knight(Color.BLACK, rows[rowBlackFigures].getTiles()[i].getPosition())); //Black Knight
                    break;
                case 2:
                case 5:
                    rows[rowWhiteFigures].getTiles()[i].getChildren().add(new Bishop(Color.WHITE, rows[rowWhiteFigures].getTiles()[i].getPosition())); //White Bishop
                    rows[rowBlackFigures].getTiles()[i].getChildren().add(new Bishop(Color.BLACK, rows[rowBlackFigures].getTiles()[i].getPosition())); //Black Bishop
                    break;
                case 3:
                    rows[rowWhiteFigures].getTiles()[i].getChildren().add(new Queen(Color.WHITE, rows[rowWhiteFigures].getTiles()[i].getPosition())); //White Queen
                    rows[rowBlackFigures].getTiles()[i].getChildren().add(new Queen(Color.BLACK, rows[rowBlackFigures].getTiles()[i].getPosition())); //Black Queen
                    break;
                case 4:
                    rows[rowWhiteFigures].getTiles()[i].getChildren().add(new King(Color.WHITE, rows[rowWhiteFigures].getTiles()[i].getPosition())); //White King
                    rows[rowBlackFigures].getTiles()[i].getChildren().add(new King(Color.BLACK, rows[rowBlackFigures].getTiles()[i].getPosition())); //Black King
                    break;
                default:
                    System.err.println("Class Board.java, Method addFigures: There went something wrong with the for-loop if you see this message!");
                    break;
            }
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
     * returns number of tiles (per row/column)
     * @return
     */
    public int getNumOfTiles() {
        return numOfTiles;
    }
}
