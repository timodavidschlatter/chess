package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Locale;
import java.util.ResourceBundle;

@ExtendWith(ApplicationExtension.class)
public class GameTest {

    private GameFxmlController gameFxmlController;

    @Start
    public void start(Stage stage) throws Exception {
        Game gameController = new Game();
        Scene scene = new Scene(gameController.getView());
        stage.setScene(scene);
        stage.show();
        stage.toFront();

        gameController.createBoard();
        gameController.createAndAddFigures();
    }

    @BeforeEach
    public void setUp () throws Exception {
    }

    @AfterEach
    public void tearDown (FxRobot robot) throws Exception {
        FxToolkit.hideStage();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    // TODO Test Naming Convention
    @Test
    public void movePawnForward(FxRobot robot) {

        /*
         * 1. Ich klicke auf einen Pawn.
         *   1.1 Ich brauche die Referenz auf einen Pawn. (robot.lookup)
         *   1.2 Ich klicke auf diesen Pawn. (robot.clickOn)
         * 2. Ich klicke auf ein Tile dass zwei Felder vornedran ist.
         *   2.1 Ich brauche die Referenz auf das richtige Tile.
         *   2.2 Analog 1.2
         * 3. Ich erwarte, dass sich die Figur erfolgreich bewegt.
         *   3.1 Old Tile hat keine Children mehr.
         *   3.2 New Tile hat als Child der obere Pawn.
         */

        // Given

        // When

        // Then
        //robot.clickOn("#blackBench");
    }
}
