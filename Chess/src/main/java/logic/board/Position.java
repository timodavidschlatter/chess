package logic.board;

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
}
