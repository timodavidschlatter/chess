package logic.helper;

import view.Position;

import java.util.ArrayList;
import java.util.List;

public class Movement {

    public static List<Position> moveUp(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() + 1;
        for(int i = firstRowNumberToMoveTo; i < 8; i++) {
            positions.add(new Position(i, position.getColumnNumber()));
        }
        return positions;
    }

    public static List<Position> moveDown(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstRowNumberToMoveTo = position.getRowNumber() - 1;
        for(int i = firstRowNumberToMoveTo; i >= 0; i--) {
            positions.add(new Position(i, position.getColumnNumber()));
        }
        return positions;
    }

    public static List<Position> moveRight(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstColumnNumberToMoveTo = position.getColumnNumber() + 1;
        for(int i = firstColumnNumberToMoveTo; i < 8; i++) {
            positions.add(new Position(position.getRowNumber(), i));
        }
        return positions;
    }

    public static List<Position> moveLeft(Position position) {
        List<Position> positions = new ArrayList<>();
        int firstColumnNumberToMoveTo = position.getColumnNumber() - 1;
        for(int i = firstColumnNumberToMoveTo; i >= 0; i--) {
            positions.add(new Position(position.getRowNumber(), i));
        }
        return positions;
    }

    public static List<Position> moveUpRight(Position position) {
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

    public static List<Position> moveUpLeft(Position position) {
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

    public static List<Position> moveDownLeft(Position position) {
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

    public static List<Position> moveDownRight(Position position) {
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
