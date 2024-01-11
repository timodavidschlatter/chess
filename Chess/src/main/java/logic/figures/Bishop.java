package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;
import logic.helper.Movement;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure {

    private final static String UNICODE_BLACK = "\u265D";
    private final static String UNICODE_WHITE = "\u2657";

    public Bishop(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Bishop");
    }

    //TODO
    @Override
    public List<Position> move() {
        Position position = this.getPosition();
        List<Position> allPositionsToMoveTo = new ArrayList<>();
        allPositionsToMoveTo.addAll(Movement.moveUpRight(position));
        allPositionsToMoveTo.addAll(Movement.moveUpLeft(position));
        allPositionsToMoveTo.addAll(Movement.moveDownLeft(position));
        allPositionsToMoveTo.addAll(Movement.moveDownRight(position));
        return allPositionsToMoveTo;
    }
}
