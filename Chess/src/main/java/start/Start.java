package start;

import controller.ControlStation;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        ControlStation controlStation = new ControlStation(stage);
        controlStation.showStartView();
    }
}
