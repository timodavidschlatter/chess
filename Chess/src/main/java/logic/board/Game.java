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


    public static void moveFigure(Tile tile) {
        /*
         * 1 Das Tile wird nicht durch eines meiner eigenen Truppen blockiert
         * 2 Die Tiles welche in meinem Bewegungsfeld sind, werden nicht durch meine eigenen Truppen blockiert
         * 3 Wohin kann ich mich bewegen? move() Methode von der Figur ausführen.
         * 4
         */

        // TODO
        if (tile == null) {
            System.out.println("Unexpected error");
        }

        // TODO add error handling
        if (tile.getChildren().size() > 1) {
            System.out.println("This should not be possible");
        }

        // The figure cannot move on a figure of the same color
        List<Node> children = tile.getChildren();
        if (!children.isEmpty()) {
            Figure figure = (Figure) children.get(0); // TODO without casting?
            if (figure.getColor().equals(turn)) {
                return;
            }
        }

        List<Position> positions = selectedFigure.move();
        boolean canTheFigureMoveToTheSelectedTile = false;

        for (Position position : positions) {
            if (position.equals(tile.getPosition())) {
                canTheFigureMoveToTheSelectedTile = true;
                break;
            }
        }

        if (!canTheFigureMoveToTheSelectedTile) {
            return;
        }

        // TODO the knight is allowed to jump over figures

        if (!areTilesInBetweenEmpty(selectedFigure.getPosition(), tile.getPosition())) {
            return;
        }

        Tile tileOfSelectedFigure = board.getTile(selectedFigure.getPosition());
        tileOfSelectedFigure.getChildren().clear();
        tile.getChildren().add(selectedFigure);
        selectedFigure.setPosition(tile.getPosition());

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
     * returns board
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
