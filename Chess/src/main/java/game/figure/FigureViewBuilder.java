package game.figure;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.function.Consumer;


public class FigureViewBuilder implements Builder<Region> {

    private final FigureModel figureModel;
    private final String unicodeFigure;
    private final Consumer<Runnable> clickFigure;

    public FigureViewBuilder(FigureModel figureModel, String unicodeFigure, Consumer<Runnable> clickFigure) {
        this.figureModel = figureModel;
        this.unicodeFigure = unicodeFigure;
        this.clickFigure = clickFigure;
    }

    @Override
    public Region build() {
        Label figureView = new Label(unicodeFigure);

        figureView.setOnMouseClicked(evt ->  {
            clickFigure.accept(() -> {
                System.out.println("Figure " + figureModel.getFxmlId() + " was clicked. ");
            });
        });

        /* Sets styling for the selected Figure. */
        figureModel.isSelectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                figureView.setStyle("-fx-background-color: lightblue;");
            } else {
                figureView.setStyle("");
            }
        });

        figureView.idProperty().bind(figureModel.fxmlIdProperty());

        return figureView;
    }
}
