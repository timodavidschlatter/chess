package game.figure;

import javafx.scene.paint.Color;
import logic.helper.Position;
import logic.helper.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Queen extends Figure {

    private final static String UNICODE_BLACK = "\u265B";
    private final static String UNICODE_WHITE = "\u2655";

    public Queen(Color color, Position position, Consumer<Figure>  selectFigure, String fxmlId) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, selectFigure, fxmlId);
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
