package game.figure;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class FigureModel {

    private final String unicodeFigure;
    private final BooleanProperty isSelected = new SimpleBooleanProperty(false);

    public FigureModel(String unicodeFigure) {
        this.unicodeFigure = unicodeFigure;
    }

    public BooleanProperty isSelectedProperty() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected.set(isSelected);
    }
}
