package logic.figures;

import javafx.scene.paint.Color;
import view.Position;
import logic.helper.Movement;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Figure {

    private final static String UNICODE_BLACK = "\u265B";
    private final static String UNICODE_WHITE = "\u2655";

    public Queen(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Queen");
    }

    @Override
    public List<Position> move() {
        Position position = this.getPosition();
        List<Position> allPositionsToMoveTo = new ArrayList<>();
        allPositionsToMoveTo.addAll(Movement.moveUp(position));
        allPositionsToMoveTo.addAll(Movement.moveDown(position));
        allPositionsToMoveTo.addAll(Movement.moveRight(position));
        allPositionsToMoveTo.addAll(Movement.moveLeft(position));
        allPositionsToMoveTo.addAll(Movement.moveUpRight(position));
        allPositionsToMoveTo.addAll(Movement.moveUpLeft(position));
        allPositionsToMoveTo.addAll(Movement.moveDownLeft(position));
        allPositionsToMoveTo.addAll(Movement.moveDownRight(position));
        return allPositionsToMoveTo;
    }
}
