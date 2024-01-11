package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {

    private final static String UNICODE_BLACK = "\u265F";
    private final static String UNICODE_WHITE = "\u2659";

    public Pawn(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Pawn");
        //super.setLabelText(unicode_black, unicode_white);
    }

    //TODO
    @Override
    public List<Position> move() {
        return new ArrayList<Position>();
    }
}
