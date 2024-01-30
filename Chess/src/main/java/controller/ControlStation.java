/*
 * Classname: ControlStation
 *
 * Version information: 0.1
 *
 * Date: 26 May 2020
 *
 * Copyright notice: -
 */

package controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class ControlStation is mainly used to switch scenes on the stage
 */
public class ControlStation {

    private Stage stage;
    private Locale locale;
    // private GameOld gameOld;
    private final String baseName;
    private final String title;

    /**
     * Initializes controlStation with stage info, language bundle name and locale, and title
     * @param stage
     */
    public ControlStation(Stage stage) {
        this.stage = stage;
        this.baseName = "Bundle";
        this.locale = new Locale("en");
        this.title = "Chess";
    }

    /**
     * Shows start view
     */
    public void showStartView() {
        showView("/fxml/StartView.fxml", new StartController(this));
    }

    /**
     * Shows game view
     */
    public void showGameView() {
        /*showView("/fxml/GameView.fxml", new GameView(this, gameOld, this::onTileClick))*/;
    }

    /**
     * Shows given view with path to file and given parameter controller
     * @param filePath
     * @param controller
     */
    private void showView(String filePath, FXMLController controller) {
        FXMLLoader loader = new FXMLLoader(ControlStation.class.getResource(filePath), ResourceBundle.getBundle(baseName, locale));
        try {
            loader.setController(controller);
            initAndShow(loader.load(), title);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FXML-Resource not found. ");
            Platform.exit();
        }
    }

    /**
     * Initializes and shows stage with scene on it
     * @param parent
     * @param title
     */
    private void initAndShow(Parent parent, String title) {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /**
     * Sets the game after starting it (in StartController)
     * @param gameOld
     */
    /*public void setGame(GameOld gameOld) {
        this.gameOld = gameOld;
    }*/

}
