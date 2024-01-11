package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

public class Queen extends Figure {

    private final static String UNICODE_BLACK = "\u265B";
    private final static String UNICODE_WHITE = "\u2655";

    public Queen(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Queen");
        //super.setLabelText(unicode_black, unicode_white);

    }

    //TODO
    @Override
    public void move() {

    }
}
