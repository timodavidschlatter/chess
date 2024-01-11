package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;
import logic.helper.Movement;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Figure {

    private final static String UNICODE_BLACK = "\u265C";
    private final static String UNICODE_WHITE = "\u2656";

    public Rook(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Rook");
    }

    //TODO
    @Override
    public List<Position> move() {
        Position position = this.getPosition();
        List<Position> allPositionsToMoveTo = new ArrayList<>();
        allPositionsToMoveTo.addAll(Movement.moveUp(position));
        allPositionsToMoveTo.addAll(Movement.moveDown(position));
        allPositionsToMoveTo.addAll(Movement.moveRight(position));
        allPositionsToMoveTo.addAll(Movement.moveLeft(position));
        return allPositionsToMoveTo;
    }
}
