package logic.figures;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public abstract class Figure extends Label {

    private Color color;
    private String position;
    private String figureName;

    public Figure(String unicode, Color color, String position, String figureName) {
        super(unicode);
        this.color = color;
        this.position = position;
        this.figureName = figureName;
    }

    protected abstract void move();
}
