package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Start.class.getResource("/fxml/GameView.fxml"), ResourceBundle.getBundle("Bundle", new Locale("en")));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Chess");
        stage.show();
    }
}
