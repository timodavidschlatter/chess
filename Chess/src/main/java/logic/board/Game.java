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

    public static void figureSelected(Figure figure) {
        if (selectedFigure != null) {
            // Deselect the previously selected figure if any
            selectedFigure.setStyle(""); // Remove any styling you might have applied
        }
        selectedFigure = figure;
        selectedFigure.setStyle("-fx-background-color: lightblue;");
    }

    /**
     * returns board
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
