package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.assertj.core.api.Assertions;
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

    @Start
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"), ResourceBundle.getBundle("Bundle", new Locale("en")));
        GameFxmlController gameFxmlController = new GameFxmlController();
        loader.setController(gameFxmlController);
        Parent mainNode = loader.load();

        //Parent mainNode = FXMLLoader.load(getClass().getResource("/fxml/GameView.fxml"));

        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
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

    @Test
    public void testEnglishInput(FxRobot robot) {
        robot.clickOn("#blackBench");
    }
}
