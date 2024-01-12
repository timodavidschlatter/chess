package logic.figures;

import javafx.scene.paint.Color;
import logic.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {

    private final static String UNICODE_BLACK = "\u265F";
    private final static String UNICODE_WHITE = "\u2659";

    public Pawn(Color color, Position position) {
        super(UNICODE_BLACK, UNICODE_WHITE, color, position, "Pawn");
    }

    @Override
    public List<Position> move() {
        /*
         * TODO 3. Spezialregel en passant
         * 4. Kill diagonal
         */
        List<Position> positions = new ArrayList<>();
        Position position = this.getPosition();
        Color color = this.getColor();

        if (color.equals(Color.WHITE)) {
            positions.add(new Position(position.getRowNumber() + 1, position.getColumnNumber()));

            // Pawns can move two fields from start position
            if (position.getRowNumber() == 1) {
                positions.add(new Position(position.getRowNumber() + 2, position.getColumnNumber()));
            }
        } else if (color.equals(Color.BLACK)) {
            positions.add(new Position(position.getRowNumber() - 1, position.getColumnNumber()));

            // Pawns can move two fields from start position
            if (position.getRowNumber() == 6) {
                positions.add(new Position(position.getRowNumber() - 2, position.getColumnNumber()));
            }
        }

        return positions;
    }
}
