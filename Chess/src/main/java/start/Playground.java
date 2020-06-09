package start;

import controller.ControlStation;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Playground extends Application {

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
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        HBox g = new HBox();
        Label l = new Label("This is a Text!");
        Button b = new Button("make bigger");
        g.getChildren().addAll(l,b);
        double d = 10;
        b.setOnAction((e) -> {

            l.setFont(Font.font(d));
        });
        Scene scene = new Scene(g, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
