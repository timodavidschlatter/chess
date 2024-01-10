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

import logic.figures.Figure;

/**
 * Class displays in game scenario
 * TODO Do I need instances of 'Game' or can it be static?
 */
public class Game {

    private Board board;
    private static Figure selectedFigure;

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

    /**
     * returns board
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
