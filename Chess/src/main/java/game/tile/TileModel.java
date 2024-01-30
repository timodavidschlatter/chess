package game.tile;

import game.figure.Figure;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TileModel {

    private final BooleanProperty hasFigure = new SimpleBooleanProperty(false);

    public BooleanProperty hasFigureProperty() {
        return hasFigure;
    }

    public boolean isHasFigure() {
        return hasFigure.get();
    }

    public void setHasFigure(boolean hasFigure) {
        this.hasFigure.set(hasFigure);
    }
}
