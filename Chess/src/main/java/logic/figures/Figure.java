package logic.figures;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import logic.Game;
import view.Position;

import java.util.List;

public abstract class Figure extends Label {

    private Color color;
    private Position position;
    private String figureName;

    public Figure(String unicode_black, String unicode_white, Color color, Position position, String figureName) {
        super(color.equals(Color.BLACK) ? unicode_black : unicode_white);
        this.color = color;
        this.position = position;
        this.figureName = figureName;
        this.setOnMouseClicked(this::handleMouseClick); // Add event handler for mouse click
    }

    public abstract List<Position> move();

    /**
     * Handles a mouse click on the figure and executes the selectFigure() method of the Game object.
     * @param event The MouseEvent
     */
    private void handleMouseClick(MouseEvent event) {
        Game.selectFigure(this);
    }

    /**
     * Get color.
     * @return Color of Figure
     */
    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
