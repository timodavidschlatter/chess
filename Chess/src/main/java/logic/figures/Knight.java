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
    }

    //TODO
    @Override
    public List<Position> move() {
        Position position = this.getPosition();
        List<Position> positions = new ArrayList<>();

        positions.add(new Position(position.getRowNumber() + 2, position.getColumnNumber() + 1)); // TwoUpRight
        positions.add(new Position(position.getRowNumber() + 2, position.getColumnNumber() - 1)); // TwoUpLeft
        positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber() - 2)); // TwoLeftUp
        positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber() - 2)); // TwoLeftDown
        positions.add(new Position(position.getRowNumber() - 2, position.getColumnNumber() - 1)); // TwoDownLeft
        positions.add(new Position(position.getRowNumber() - 2, position.getColumnNumber() + 1)); // TwoDownRight
        positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber() + 2)); // TwoRightDown
        positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber() + 2)); // TwoRightUp

        return positions;
    }
}
