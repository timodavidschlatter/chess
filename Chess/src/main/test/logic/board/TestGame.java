package logic.board;

import game.figure.Figure;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestGame {

    @Test
    public void selectFigure_ParameterIsNull_NullPointerException() {
        // Given
        Figure figure = null;

        // When and Then
        assertThatNullPointerException().isThrownBy(() -> {
            //GameOld.selectFigure(figure);
        });
    }
}
