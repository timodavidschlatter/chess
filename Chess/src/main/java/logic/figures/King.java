package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {

    private final static String UNICODE_BLACK = "\u265A";
    private final static String UNICODE_WHITE = "\u2654";

    public King(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "King");
        //super.setLabelText(unicode_black, unicode_white);
    }

    //TODO
    @Override
    public List<Position> move() {
        return new ArrayList<Position>();
    }
}
