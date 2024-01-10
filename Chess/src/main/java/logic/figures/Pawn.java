package logic.figures;

import javafx.scene.paint.Color;

public class Pawn extends Figure {

    private final static String UNICODE_BLACK = "\u265F";
    private final static String UNICODE_WHITE = "\u2659";

    public Pawn(Color color, String position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Pawn");
        //super.setLabelText(unicode_black, unicode_white);
    }

    //TODO
    @Override
    public void move() {

    }
}
