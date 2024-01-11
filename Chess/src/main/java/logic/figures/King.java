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
