/*
 * Classname: Start
 *
 * Version information: 0.1
 *
 * Date: 01 June 2020
 *
 * Copyright notice: -
 */

package start;

import game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class extends application and therefore starts whole javafx application
 */
public class Start extends Application {

    /**
     * launch args
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Creates controlStation with parameter stage and shows start window
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        /*ControlStation controlStation = new ControlStation(stage);
        controlStation.showGameView();*/
        Game gameController = new Game();
        Scene scene = new Scene(gameController.getView());
        stage.setScene(scene);
        stage.show();
        stage.toFront();

        gameController.createBoard();
        gameController.createAndAddFigures();
    }
}
