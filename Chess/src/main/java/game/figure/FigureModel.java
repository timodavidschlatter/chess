package game.figure;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FigureModel {

    private final BooleanProperty isSelected = new SimpleBooleanProperty(false);
    private final StringProperty fxmlId = new SimpleStringProperty("");

    public String getFxmlId() {
        return fxmlId.get();
    }

    public StringProperty fxmlIdProperty() {
        return fxmlId;
    }

    public void setFxmlId(String fxmlId) {
        this.fxmlId.set(fxmlId);
    }



    public BooleanProperty isSelectedProperty() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected.set(isSelected);
    }
}
