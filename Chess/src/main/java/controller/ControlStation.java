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
    private final String baseName;


    public ControlStation(Stage stage) {
        this.stage = stage;
        this.baseName = "Bundle";
        this.locale = new Locale("en");
    }

    public void showStartView() {
        FXMLLoader loader = new FXMLLoader(ControlStation.class.getResource("/fxml/StartView.fxml"), ResourceBundle.getBundle(baseName, locale));
        try {
            loader.setController(new StartController(this));
            initAndShow(loader.load(), "Chess Game");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FXML-Resource not found. ");
        }
    }

    public void showGameView() {
        FXMLLoader loader = new FXMLLoader(ControlStation.class.getResource("/fxml/GameView.fxml"), ResourceBundle.getBundle(baseName, locale));
        try {
            loader.setController(new GameController(this));
            initAndShow(loader.load(), "Chess Game");
        } catch (IOException e) {
            System.out.println("FXML-Resource not found. ");
        }
    }

    private void initAndShow(Parent parent, String title) {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }


}
