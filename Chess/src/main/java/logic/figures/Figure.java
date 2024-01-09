package logic.figures;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import logic.board.Game;

public abstract class Figure extends Label {

    private Color color;
    private String position;
    private String figureName;

    public Figure(String unicode_black, String unicode_white, Color color, String position, String figureName) {
        super(color.equals(Color.BLACK) ? unicode_black : unicode_white);
        this.color = color;
        this.position = position;
        this.figureName = figureName;

        this.setOnMouseClicked(this::handleFigureClick); // Add event handler for mouse click
    }

    protected abstract void move();

    protected void handleFigureClick(MouseEvent event) {
        Game.figureSelected(this); // Notify the Game class that this figure is selected
    }


    /*protected void setLabelText(String unicode_black, String unicode_white) {
        String unicode = color.equals(Color.BLACK) ? unicode_black : unicode_white;
        super.setText(unicode);
    }*/
}
