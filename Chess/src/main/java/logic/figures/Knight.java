package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Figure {

    private final static String UNICODE_BLACK = "\u265E";
    private final static String UNICODE_WHITE = "\u2658";

    public Knight(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Knight");
        //super.setLabelText(unicode_black, unicode_white);
    }

    //TODO
    @Override
    public List<Position> move() {
        return new ArrayList<Position>();
    }
}
