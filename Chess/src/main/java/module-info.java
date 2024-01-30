module Chess {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    opens start to javafx.fxml, javafx.graphics; //Need to open your javafx package bc of controls
    opens controller to javafx.fxml, javafx.graphics;
    opens game to javafx.fxml, javafx.graphics;
    opens game.tile to javafx.fxml, javafx.graphics;
}