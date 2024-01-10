package logic.figures;

import javafx.scene.paint.Color;

public class Rook extends Figure {

    private final static String UNICODE_BLACK = "\u265C";
    private final static String UNICODE_WHITE = "\u2656";

    public Rook(Color color, String position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Rook");
        //super.setLabelText(unicode_black, unicode_white);

    }

    //TODO
    @Override
    public void move() {

    }
}
