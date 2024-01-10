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

import javafx.scene.paint.Color;
import logic.figures.Figure;

/**
 * Class displays in game scenario
 * TODO Do I need instances of 'Game' or can it be static?
 */
public class Game {

    private Board board;
    private static Figure selectedFigure;
    private static Color turn = Color.WHITE;

    /**
     * Initalizes the game with its board
     */
    public Game() {
        this.board = new Board();
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


        // TODO
        selectedFigure.move();
        System.out.println(selectedFigure.getPosition());
        System.out.println(tile.getPosition());
    }

    /**
     * returns board
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
