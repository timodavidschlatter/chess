package game.tile;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class TileModel {

    private final BooleanProperty hasFigure = new SimpleBooleanProperty(false);

    public BooleanProperty hasFigureProperty() {
        return hasFigure;
    }

    public boolean isHasFigure() {
        return hasFigure.get();
    }
}
