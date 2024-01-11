package logic.board;

import java.util.Objects;

public class Position {

    private int rowNumber;
    private int columnNumber;

    public Position(int x, int y) {
        this.rowNumber = x;
        this.columnNumber = y;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + rowNumber +
                ", column=" + columnNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rowNumber == position.rowNumber && columnNumber == position.columnNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNumber, columnNumber);
    }
}
