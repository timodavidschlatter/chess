package game;

import game.figure.Figure;
import game.tile.TileView;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
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

    @Test
    public void shouldMovePawnForwardAfterUserClick(FxRobot robot) {

        // Given
        TileView oldTile = robot.lookup("#tile-36").query();
        TileView newTile = robot.lookup("#tile-34").query();
        Region figure = robot.lookup("#whitePawn-3").query();

        Assertions.assertThat(newTile.getChildren().isEmpty()).isTrue();
        Assertions.assertThat(oldTile.getChildren().size()).isNotNull();
        Assertions.assertThat(oldTile.getChildren().get(0).equals(figure)).isTrue();

        // When
        robot.clickOn(figure);
        robot.clickOn(newTile);

        // Then
        Assertions.assertThat(oldTile.getChildren().isEmpty()).isTrue();
        Assertions.assertThat(newTile.getChildren().size()).isNotNull();
        // TODO Because a figure each time it moves is built new by the FigureViewBuilder I cannot do
        //      Assertions.assertThat(newTile.getChildren().get(0).equals(figure)).isTrue();
        //      Maybe FigureViewBuilder does not make sense for the figure? Because it is rebuilt each time it moves...
        Assertions.assertThat(newTile.getChildren().get(0).getId().equals("whitePawn-3")).isTrue();
    }
}
