package game.figure;

import javafx.scene.paint.Color;
import logic.helper.Position;
import logic.helper.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Rook extends Figure {

    private final static String UNICODE_BLACK = "\u265C";
    private final static String UNICODE_WHITE = "\u2656";

    public Rook(Color color, Position position, Consumer<Figure> selectFigure) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, selectFigure);
    }

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
