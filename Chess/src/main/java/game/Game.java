package game;

import game.figure.*;
import game.tile.Tile;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import logic.helper.Position;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final GameModel gameModel = new GameModel();
    private final GameViewBuilder gameViewBuilder = new GameViewBuilder();
    private final int numOfTiles = 8;
    private final Tile[][] board = new Tile[numOfTiles][numOfTiles];
    private final List<Figure> figures = new ArrayList<>();
    private Figure selectedFigure;
    private Color turn = Color.WHITE;

    /**
     * Returns the built game view as a Region (for more interchangeability).
     * @return Game view built by the GameViewBuilder.
     */
    public Region getView() {
        return gameViewBuilder.build();
    }

    /**
     * Creates the tiles, adds it to the local board array and uses the reference to
     * the game view (GameViewBuilder) to add the tile view to it.
     */
    public void createBoard() {
        for (int i = 0; i < board.length; i++) {
            Color color = i % 2 == 0 ? Color.GRAY : Color.WHITE;

            for (int j = 0; j < board[i].length; j++) {
                color = color.equals(Color.GRAY) ? Color.WHITE : Color.GRAY;
                Tile tile = new Tile(color, new Position(i, j), this::moveFigure);
                board[i][j] = tile;
                gameViewBuilder.addTileToChessBoard(tile.getView(), j, i);
            }
        }
    }

    /**
     * Creates the figures and adds them to the board via {@link #addFigureToBoard(Figure, int, int)}.
     */
    public void createAndAddFigures() {

        int rowWhiteFigures = 7, rowWhitePawns = 6;
        int rowBlackFigures = 0, rowBlackPawns = 1;

        for(int i = 0; i < numOfTiles; i++) {
            Figure whitePawn = new Pawn(Color.WHITE, new Position(rowWhitePawns, i), this::setSelectedFigure, "whitePawn-" + i);
            Figure blackPawn = new Pawn(Color.BLACK, new Position(rowBlackPawns, i), this::setSelectedFigure, "blackPawn-" + i);
            addFigureToBoard(whitePawn, rowWhitePawns, i);
            addFigureToBoard(blackPawn, rowBlackPawns, i);

            switch(i) {
                case 0:
                case 7:
                    Figure whiteRook = new Rook(Color.WHITE, new Position(rowWhiteFigures, i), this::setSelectedFigure, "whiteRook-" + i);
                    Figure blackRook = new Rook(Color.BLACK, new Position(rowBlackFigures, i), this::setSelectedFigure, "blackRook-" + i);
                    addFigureToBoard(whiteRook, rowWhiteFigures, i);
                    addFigureToBoard(blackRook, rowBlackFigures, i);
                    break;
                case 2:
                case 5:
                    Figure whiteBishop = new Bishop(Color.WHITE, new Position(rowWhiteFigures, i), this::setSelectedFigure, "whiteBishop-" + i);
                    Figure blackBishop = new Bishop(Color.BLACK, new Position(rowBlackFigures, i), this::setSelectedFigure, "blackBishop-" + i);
                    addFigureToBoard(whiteBishop, rowWhiteFigures, i);
                    addFigureToBoard(blackBishop, rowBlackFigures, i);
                    break;
                case 1:
                case 6:
                    Figure whiteKnight = new Knight(Color.WHITE, new Position(rowWhiteFigures, i), this::setSelectedFigure, "whiteKnight-" + i);
                    Figure blackKnight = new Knight(Color.BLACK, new Position(rowBlackFigures, i), this::setSelectedFigure, "blackKnight-" + i);
                    addFigureToBoard(whiteKnight, rowWhiteFigures, i);
                    addFigureToBoard(blackKnight, rowBlackFigures, i);
                    break;
                case 3:
                    Figure whiteQueen = new Queen(Color.WHITE, new Position(rowWhiteFigures, i), this::setSelectedFigure, "whiteQueen-" + i);
                    Figure blackQueen = new Queen(Color.BLACK, new Position(rowBlackFigures, i), this::setSelectedFigure, "blackQueen-" + i);
                    addFigureToBoard(whiteQueen, rowWhiteFigures, i);
                    addFigureToBoard(blackQueen, rowBlackFigures, i);
                    break;
                case 4:
                    Figure whiteKing = new King(Color.WHITE, new Position(rowWhiteFigures, i), this::setSelectedFigure, "whiteKing-" + i);
                    Figure blackKing = new King(Color.BLACK, new Position(rowBlackFigures, i), this::setSelectedFigure, "blackKing-" + i);
                    addFigureToBoard(whiteKing, rowWhiteFigures, i);
                    addFigureToBoard(blackKing, rowBlackFigures, i);
                    break;
                default:
                    System.err.println("Class Board.java, Method addFigures: There went something wrong with the for-loop if you see this message!");
                    break;
            }
        }
    }

    /**
     * Helper method to add a figure to the board. Adds the figure to the figures array,
     * sets the child figure of a tile and adds it to the acutal board.
     * @param figure The figure to add.
     * @param row The row.
     * @param col The column.
     */
    private void addFigureToBoard(Figure figure, int row, int col) {
        figures.add(figure);
        board[row][col].setChildFigure(figure);
        gameViewBuilder.addFiguresToChessBoard(board[row][col].getView(), figure.getView());
    }


    /**
     * The method to move a figure. Executes multiple checks to allow the move.
     * 1. Checks if the clicked tile is not blocked by a figure of the same color via {@link #isClickedTileBlockedBySameColor(Tile)}
     * 2. Checks the possible movements of the figure via {@link #canFigureMoveOnClickedTile(Tile)}
     * 3. Checks if tiles in between are empty via {@link #areTilesInBetweenEmpty(Position, Position)}
     *
     * @param clickedTile The tile that the figure should move to.
     */
    private void moveFigure(Tile clickedTile) {

        if (selectedFigure == null) {
            return;
        }

        Position oldPosition = selectedFigure.getPosition();

        if (oldPosition.equals(clickedTile.getPosition())) {
            return;
        }

        /* The figure cannot move on a figure of the same color. */
        if (isClickedTileBlockedBySameColor(clickedTile)) {
            return;
        }

        /* The figure cannot move on the clicked tile. */
        if (!canFigureMoveOnClickedTile(clickedTile)) {
            return;
        }

        /* The knight is allowed to jump over figures */
        if (!(selectedFigure instanceof Knight)) {
                /* The figure cannot move to the selected tile because
                 * the tiles in between are blocked by other figures. */
            if (!areTilesInBetweenEmpty(selectedFigure.getPosition(), clickedTile.getPosition())) {
                return;
            }
        }

        /* The actual movement */
        selectedFigure.setPosition(clickedTile.getPosition());
        clickedTile.setChildFigure(selectedFigure);

        gameViewBuilder.moveFigure(
                board[oldPosition.getRowNumber()][oldPosition.getColumnNumber()].getView(),
                clickedTile.getView(),
                selectedFigure.getView(),
                selectedFigure.getColor());

        selectedFigure.selectFigure(false);
        selectedFigure = null;

        changeTurn();
    }

    /**
     * Changes the turn to the other color (WHITE <-> BLACK).
     */
    private void changeTurn() {
        if (turn.equals(Color.WHITE)) {
            turn = Color.BLACK;
        } else {
            turn = Color.WHITE;
        }
    }

    /**
     * Checks if the clicked tile is blocked by the same color.
     * @param clickedTile The clicked tile by the player.
     * @return true if the clicked tile is blocked by a figure of the same color, false otherwise
     */
    private boolean isClickedTileBlockedBySameColor(Tile clickedTile) {
        if (clickedTile.hasChildren()) {
            return clickedTile.getChildFigure().getColor().equals(turn);
        }
        return false;
    }

    /**
     * Checks all the positions a figure can move to by its possible movements.
     * This function does not check if the tiles in between its current position and
     * the selected position are empty!
     * @param clickedTile The clicked tile by the player
     * @return true if the figure can move by its possible movements on the clicked tile, false otherwise
     */
    private boolean canFigureMoveOnClickedTile(Tile clickedTile) {
        List<Position> positions = selectedFigure.move();

        if (selectedFigure instanceof Pawn) {
            specialMovementsOfPawn(positions);
        }

        for (Position position : positions) {
            if (position.equals(clickedTile.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private void specialMovementsOfPawn(List<Position> positions) {
        int currRowNr = selectedFigure.getPosition().getRowNumber();
        int currColNr = selectedFigure.getPosition().getColumnNumber();

        if (selectedFigure.getColor().equals(Color.WHITE)) {

            // Attack diagonal left
            if (board[currRowNr - 1][currColNr - 1].hasChildren()) {
                positions.add(new Position(currRowNr - 1, currColNr - 1));
            }

            // Attack diagonal right
            if (board[currRowNr - 1][currColNr + 1].hasChildren()) {
                positions.add(new Position(currRowNr - 1, currColNr + 1));
            }

            // Pawn cannot attack forward
            if (board[currRowNr - 1][currColNr].hasChildren()) {
                positions.remove(new Position(currRowNr - 1, currColNr));
            }
            if (currRowNr == 6 && board[currRowNr - 2][currColNr].hasChildren()) {
                positions.remove(new Position(currRowNr - 2, currColNr));
            }

        } else {

            // Attack diagonal left
            if (board[currRowNr + 1][currColNr + 1].hasChildren()) {
                positions.add(new Position(currRowNr + 1, currColNr + 1));
            }

            // Attack diagonal right
            if (board[currRowNr + 1][currColNr - 1].hasChildren()) {
                positions.add(new Position(currRowNr + 1, currColNr - 1));
            }

            // Pawn cannot attack forward
            if (board[currRowNr + 1][currColNr].hasChildren()) {
                positions.remove(new Position(currRowNr + 1, currColNr));
            }
            if (currRowNr == 1 && board[currRowNr + 2][currColNr].hasChildren()) {
                positions.remove(new Position(currRowNr + 2, currColNr));
            }
        }
    }

    /**
     * Checks if the tiles between a movement are empty (-> not blocked by other figures).
     * This function does not check if the desired position is blocked (by a figure of the same color)!
     * @param start The start position of the figure
     * @param end The desired end position of the figure
     * @return true if the tiles in between are empty, false otherwise
     */
    private boolean areTilesInBetweenEmpty(Position start, Position end) {
        int startRowNum = start.getRowNumber();
        int endRowNum = end.getRowNumber();
        int startColNum = start.getColumnNumber();
        int endColNum = end.getColumnNumber();

        List<Position> positions = new ArrayList<>();

        int rowDiff = Math.abs(startRowNum - endRowNum);
        int colDiff = Math.abs(startColNum - endColNum);

        int rowIncrement = (startRowNum < endRowNum) ? 1 : -1;
        int colIncrement = (startColNum < endColNum) ? 1 : -1;

        // A figure cannot stay on the same spot
        if (rowDiff == 0 && colDiff == 0) {
            return false;
        }

        /*
         * Covers moveUp, moveDown fully and sets the correct rowNum
         * for all diagonal movements.
         */
        for (int i = 1; i < rowDiff; i++) {
            int rowNum = startRowNum + (i * rowIncrement);
            positions.add(new Position(rowNum, startColNum));
        }

        for (int i = 1; i < colDiff; i++) {
            int colNum = startColNum + (i * colIncrement);

            // Covers moveRight, moveLeft fully.
            if (rowDiff == 0) {
                positions.add(new Position(startRowNum, colNum));
            } else { // Sets the correct colNum for all diagonal movements.
                positions.get(i - 1).setColumnNumber(colNum);
            }
        }



        return positions.stream().allMatch(position -> {
            Tile tile = board[position.getRowNumber()][position.getColumnNumber()];
            return !tile.hasChildren();
            //return board.getTile(position).getChildren().isEmpty();
        });
    }

    /**
     * The method that is injected to the game view (GameViewBuilder) via constructor
     * to be executed on a user click on the figure. The method sets the variable {@link #selectedFigure}
     * @param figure The figure that was clicked on by the user.
     */
    private void setSelectedFigure(Figure figure) {

        // The game defines which color is able to be moved (and therefore also be selected)
        if (!figure.getColor().equals(turn)) {
            return;
        }

        if (selectedFigure != null) {
            selectedFigure.selectFigure(false);
        }

        figure.selectFigure(true);
        selectedFigure = figure;

    }
}
