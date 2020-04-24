module Chess {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    opens start; //Need to open your javafx package bc of controls
}