package logic.board;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Tile extends StackPane {

    private Color color;
    private String position;

    public Tile(Color color, String position) {
        this.color = color;
        this.position = position;
    }

}
