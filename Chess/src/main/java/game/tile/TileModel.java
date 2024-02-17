package game.tile;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class TileModel {

    private final BooleanProperty hasFigure = new SimpleBooleanProperty(false);
    private final StringProperty unicodeOfFigure = new SimpleStringProperty(null);
    private final ListProperty<Node> test = new SimpleListProperty<Node>(FXCollections.observableArrayList());

    public BooleanProperty hasFigureProperty() {
        return hasFigure;
    }

    public boolean isHasFigure() {
        return hasFigure.get();
    }

    public String getUnicodeOfFigure() {
        return unicodeOfFigure.get();
    }

    public StringProperty unicodeOfFigureProperty() {
        return unicodeOfFigure;
    }

    public void setUnicodeOfFigure(String unicodeOfFigure) {
        this.unicodeOfFigure.set(unicodeOfFigure);
    }

    public ObservableList<Node> getTest() {
        return test.get();
    }

    public ListProperty<Node> testProperty() {
        return test;
    }
}
