/*
 * Classname: Game
 *
 * Version information: 0.1
 *
 * Date: 26 May 2020
 *
 * Copyright notice: -
 */

package logic;

import javafx.scene.paint.Color;
import game.figure.Figure;
import game.tile.Tile;

/**
 * Class displays in game scenario
 * TODO Do I need instances of 'Game' or can it be static?
 * TODO Can I remove static altogether?
 */
public class GameOld {

    private static Figure selectedFigure;
    private static Color turn = Color.WHITE;

    /**
     * Initalizes the game with its board
     */
    public GameOld() {

    }

    /**
     * This checks if the clicked figure can be selected and adds styling to it.
     * @param figure The figure which was clicked by the player.
     */
//    public static void selectFigure(Figure figure) {
//
//        try {
//
//            // Deselect the previously selected figure if any
//            if (selectedFigure != null) {
//                selectedFigure.setStyle(""); // Remove any styling you might have applied
//            }
//
//            selectedFigure = figure;
//            selectedFigure.setStyle("-fx-background-color: lightblue;");
//
//        } catch (NullPointerException exception) {
//            System.err.println("Unexpected error. The figure selected by the player is null.");
//            exception.printStackTrace();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }

    /**
     * Does various necessary checks if the figure is even allowed to move
     * to the clicked tile. If it is, it actually moves the figure to the new position.
     * @param clickedTile The clicked tile by the player.
     */
    public static void moveFigure(Tile clickedTile) {
/*
        try {

            if (clickedTile.getChildren().size() > 1) {
                System.err.println("Unexpected error: There are more than one figure on the same tile.");
                return;
            }

            *//* The figure cannot move on a figure of the same color. *//*
            if (isClickedTileBlockedBySameColor(clickedTile)) {
                return;
            }

            *//* The figure cannot move on the clicked tile. *//*
            if (!canFigureMoveOnClickedTile(clickedTile)) {
                return;
            }

            *//* The knight is allowed to jump over figures *//*
            if (!(selectedFigure instanceof Knight)) {
                *//* The figure cannot move to the selected tile because
                 * the tiles in between are blocked by other figures. *//*
                if (!areTilesInBetweenEmpty(selectedFigure.getPosition(), clickedTile.getPosition())) {
                    return;
                }
            }

            *//* The actual movement *//*
            Tile tileOfSelectedFigure = board.getTile(selectedFigure.getPosition());
            tileOfSelectedFigure.getChildren().clear(); // Remove the figure from the start tile.
            clickedTile.getChildren().add(selectedFigure); // Add the figure to the clicked tile.
            selectedFigure.setPosition(clickedTile.getPosition()); // Set the new position to the moved figure.

        } catch(NullPointerException exception) {
            System.err.println("Unexpected error: The clicked tile by the player is null.");
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }*/
    }

    /**
     * Checks if the clicked tile is blocked by the same color.
     * @param clickedTile The clicked tile by the player.
     * @return true if the clicked tile is blocked by a figure of the same color, false otherwise
     */
    /*private static boolean isClickedTileBlockedBySameColor(Tile clickedTile) {
        List<Node> children = clickedTile.getChildren();

        if (!children.isEmpty()) {
            Figure figure = (Figure) children.get(0); // TODO without casting?
            return figure.getColor().equals(turn);
        }
        return false;
    }*/


}
