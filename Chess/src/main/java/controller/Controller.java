/*
 * Classname: Controller
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
import start.Start;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class controls
 */
public class Controller {

    private Stage stage;

    public Controller(Stage stage) {
        this.stage = stage;
    }


    public void showStartView() {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("/fxml/StartView.fxml"),
                ResourceBundle.getBundle("Bundle", new Locale("en")));
        try {
            loader.setController(new StartController());
            initAndShow(loader.load(), "Chess Game");

        } catch (IOException e) {
            System.out.println("FXML-Resource not found. ");
        }
    }

    public void initAndShow(Parent parent, String title) {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }


}
