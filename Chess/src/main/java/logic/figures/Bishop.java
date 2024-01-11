package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

public class Bishop extends Figure {

    private final static String UNICODE_BLACK = "\u265D";
    private final static String UNICODE_WHITE = "\u2657";

    public Bishop(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Bishop");
        //super.setLabelText(unicode_black, unicode_white);
    }

    //TODO
    @Override
    public void move() {

    }
}
