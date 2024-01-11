package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

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
        /*
         * 1. Was ist meine Position?
         * 2. Ich kann mich nach vorne bewegen (rowNumber erhöhen) 01 11 21 31 bis max. zur 7
         * 3. Ich kann mich zurückbewegen (rowNumber) tiefer bis max. 0
         * 4. Nach rechts (ColumnNumber) erhöhen 01 02 03 04 05 bis max. zur 7
         * 5. analog
         * 6. Diagonal nach rechts oben. ColumnNumber + RowNumber erhöhen
         */
        Position position = this.getPosition();
        List<Position> allPositionsToMoveTo = new ArrayList<>();
        allPositionsToMoveTo.addAll(moveUp(position));
        allPositionsToMoveTo.addAll(moveDown(position));
        allPositionsToMoveTo.addAll(moveRight(position));
        allPositionsToMoveTo.addAll(moveLeft(position));
        allPositionsToMoveTo.addAll(moveUpRight(position));
        allPositionsToMoveTo.addAll(moveUpLeft(position));
        allPositionsToMoveTo.addAll(moveDownLeft(position));
        allPositionsToMoveTo.addAll(moveDownRight(position));
        return allPositionsToMoveTo;
    }

    private List<Position> moveUp(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() + 1;
        for(int i = firstRowNumberToMoveTo; i < 8; i++) {
            positions.add(new Position(i, position.getColumnNumber()));
        }
        return positions;
    }

    private List<Position> moveDown(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() - 1;
        for(int i = firstRowNumberToMoveTo; i >= 0; i--) {
            positions.add(new Position(i, position.getColumnNumber()));
        }
        return positions;
    }

    private List<Position> moveRight(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstColumnNumberToMoveTo = position.getColumnNumber() + 1;
        for(int i = firstColumnNumberToMoveTo; i < 8; i++) {
            positions.add(new Position(position.getRowNumber(), i));
        }
        return positions;
    }

    private List<Position> moveLeft(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstColumnNumberToMoveTo = position.getColumnNumber() - 1;
        for(int i = firstColumnNumberToMoveTo; i >= 0; i--) {
            positions.add(new Position(position.getRowNumber(), i));
        }
        return positions;
    }

    private List<Position> moveUpRight(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() + 1;
        int columnNumber = position.getColumnNumber() + 1;
        for(int i = firstRowNumberToMoveTo; i < 8; i++) {

            // Break the loop if the columnNumber is outside of the game
            if (columnNumber > 7) {
                break;
            }
            positions.add(new Position(i, columnNumber));
            columnNumber += 1;
        }
        return positions;
    }

    private List<Position> moveUpLeft(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() + 1;
        int columnNumber = position.getColumnNumber() - 1;
        for(int i = firstRowNumberToMoveTo; i < 8; i++) {
            // Break the loop if the columnNumber is outside of the game
            if (columnNumber < 0) {
                break;
            }
            positions.add(new Position(i, columnNumber));
            columnNumber -= 1;
        }
        return positions;
    }

    private List<Position> moveDownLeft(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() - 1;
        int columnNumber = position.getColumnNumber() - 1;
        for(int i = firstRowNumberToMoveTo; i >= 0; i--) {
            // Break the loop if the columnNumber is outside of the game
            if (columnNumber < 0) {
                break;
            }
            positions.add(new Position(i, columnNumber));
            columnNumber -= 1;
        }
        return positions;
    }

    private List<Position> moveDownRight(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() - 1;
        int columnNumber = position.getColumnNumber() + 1;
        for(int i = firstRowNumberToMoveTo; i >= 0; i--) {

            // Break the loop if the columnNumber is outside of the game
            if (columnNumber > 7) {
                break;
            }
            positions.add(new Position(i, columnNumber));
            columnNumber += 1;
        }
        return positions;
    }

}
