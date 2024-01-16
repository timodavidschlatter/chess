/*
 * Classname: Game
 *
 * Version information: 0.1
 *
 * Date: 26 May 2020
 *
 * Copyright notice: -
 */

package logic.board;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import logic.figures.Figure;
import logic.figures.Knight;

import java.util.ArrayList;
import java.util.List;

/**
 * Class displays in game scenario
 * TODO Do I need instances of 'Game' or can it be static?
 */
public class Game {

    private static Board board;
    private static Figure selectedFigure;
    private static Color turn = Color.WHITE;

    /**
     * Initalizes the game with its board
     */
    public Game() {
        board = new Board();
    }

    /**
     * This checks if the clicked figure can be selected and adds styling to it.
     * @param figure The figure which was clicked by the player.
     */
    public static void selectFigure(Figure figure) {
        try {

            // TODO Does this make sense?
            if (figure == null) {
                throw new NullPointerException();
            }

            // Deselect the previously selected figure if any
            if (selectedFigure != null) {
                selectedFigure.setStyle(""); // Remove any styling you might have applied
            }

            selectedFigure = figure;
            selectedFigure.setStyle("-fx-background-color: lightblue;");
        } catch (NullPointerException exception) {
            System.err.println("Unexpected error. A figure should not be null within this method");
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Does various necessary checks if the figure is even allowed to move
     * to the clicked tile. If it is, it actually moves the figure to the new position.
     * @param clickedTile The clicked tile by the player.
     */
    public static void moveFigure(Tile clickedTile) {

        try {

            if (clickedTile.getChildren().size() > 1) {
                System.err.println("Unexpected error: There are more than one figure on the same tile.");
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
            Tile tileOfSelectedFigure = board.getTile(selectedFigure.getPosition());
            tileOfSelectedFigure.getChildren().clear(); // Remove the figure from the start tile.
            clickedTile.getChildren().add(selectedFigure); // Add the figure to the clicked tile.
            selectedFigure.setPosition(clickedTile.getPosition()); // Set the new position to the moved figure.

        } catch(NullPointerException exception) {
            System.err.println("Unexpected error: The clicked tile by the player is null.");
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Checks if the clicked tile is blocked by the same color.
     * @param clickedTile The clicked tile by the player.
     * @return true if the clicked tile is blocked by a figure of the same color, false otherwise
     */
    private static boolean isClickedTileBlockedBySameColor(Tile clickedTile) {
        List<Node> children = clickedTile.getChildren();

        if (!children.isEmpty()) {
            Figure figure = (Figure) children.get(0); // TODO without casting?
            return figure.getColor().equals(turn);
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
    private static boolean canFigureMoveOnClickedTile(Tile clickedTile) {
        List<Position> positions = selectedFigure.move();

        for (Position position : positions) {
            if (position.equals(clickedTile.getPosition())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the tiles between a movement are empty (-> not blocked by other figures).
     * This function does not check if the desired position is blocked (by a figure of the same color)!
     * @param start The start position of the figure
     * @param end The desired end position of the figure
     * @return true if the tiles in between are empty, false otherwise
     */
    private static boolean areTilesInBetweenEmpty(Position start, Position end) {
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

        return positions.stream().allMatch(position -> board.getTile(position).getChildren().isEmpty());
    }

    /**
     * Return the playing board.
     * @return the board.
     */
    public Board getBoard() {
        return board;
    }
}
