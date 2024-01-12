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

import javafx.geometry.Pos;
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

        // The figure cannot move on a figur of the same color
        if (tile.getChildren().size() > 0) {
            Figure figure = (Figure) tile.getChildren().get(0); // TODO without casting?

            if (figure != null) {
                if (figure.getColor().equals(turn)) {
                    return;
                }
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

        if (!areTilesInBetweenStartAndEndEmpty(selectedFigure.getPosition(), tile.getPosition())) {
            return;
        }

        Tile tileOfSelectedFigure = board.getTile(selectedFigure.getPosition());
        tileOfSelectedFigure.getChildren().clear();
        tile.getChildren().add(selectedFigure);
        selectedFigure.setPosition(tile.getPosition());

    }

    private static boolean areTilesInBetweenStartAndEndEmpty(Position start, Position end) {

        int startRowNumber = start.getRowNumber();
        int endRowNumber = end.getRowNumber();

        int startColumnNumber = start.getColumnNumber();
        int endColumnNumber = end.getColumnNumber();

        List<Position> positions = new ArrayList<>();
        int difference = Math.abs(startColumnNumber - endColumnNumber);

        if (startRowNumber < endRowNumber) {
            for (int i = startRowNumber + 1; i < endRowNumber; i++) {
                Position position = new Position(i, 0);
                positions.add(position);
            }
        } else if (endRowNumber < startRowNumber) {
            for (int i = startRowNumber - 1; i > endRowNumber; i--) {
                Position position = new Position(i, 0);
                positions.add(position);
            }
        } else {
            // what if rownumbers are the same?
            for (int i = 0; i < (difference - 1); i++) {
                Position position = new Position(startRowNumber, 0);
                positions.add(position);
            }
        }

        int counter = 0;
        difference = Math.abs(startRowNumber - endRowNumber);

        if (startColumnNumber < endColumnNumber) {
            for (int i = startColumnNumber + 1; i < endColumnNumber; i++) {
                positions.get(counter).setColumnNumber(i);
                counter++;
            }
        } else if (endColumnNumber < startColumnNumber) {
            for (int i = startColumnNumber - 1; i > endColumnNumber; i--) {
                positions.get(counter).setColumnNumber(i);
                counter++;
            }
        } else {
            for (int i = 0; i < (difference - 1); i++) {
                positions.get(i).setColumnNumber(startColumnNumber);
            }
        }

        for (Position position : positions) {
            if (!board.getTile(position).getChildren().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * returns board
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
