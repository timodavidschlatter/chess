package logic.figures;

import javafx.scene.paint.Color;

public class Queen extends Figure {

    private final static String UNICODE_BLACK = "\u265B";
    private final static String UNICODE_WHITE = "\u2655";

    public Queen(Color color, String position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Queen");
        //super.setLabelText(unicode_black, unicode_white);

    }

    //TODO
    @Override
    public void move() {

    }
}
