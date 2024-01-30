package logic.figures;

import game.figure.Figure;
import javafx.scene.paint.Color;
import logic.helper.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class King extends Figure {

    private final static String UNICODE_BLACK = "\u265A";
    private final static String UNICODE_WHITE = "\u2654";

    public King(Color color, Position position, Consumer<Figure> selectFigure) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, selectFigure);
    }

    //TODO
    @Override
    public List<Position> move() {
        Position position = this.getPosition();
        List<Position> positions = new ArrayList<>();

        positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber())); // moveUp
        positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber())); // moveDown
        positions.add(new Position(position.getRowNumber(), position.getColumnNumber() + 1)); // moveRight
        positions.add(new Position(position.getRowNumber(), position.getColumnNumber() - 1)); // moveLeft
        positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber() + 1)); // moveUpRight
        positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber() - 1)); // moveUpLeft
        positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber() + 1)); // moveDownRight
        positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber() - 1)); // moveDownLeft

        return positions;
    }
}
