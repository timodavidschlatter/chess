package game.figure;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import logic.helper.Position;

import java.util.List;
import java.util.function.Consumer;

public abstract class Figure {

    private final Color color;
    private final FigureModel figureModel;
    private final FigureViewBuilder figureViewBuilder;
    private Position position;
    private final Consumer<Figure> selectFigure;

    public Figure(String unicodeBlack, String unicodeWhite, Color color, Position position, Consumer<Figure> selectFigure, String fxmlId) {
        this.color = color;
        String unicodeFigure = color.equals(Color.BLACK) ? unicodeBlack : unicodeWhite;
        this.figureModel = new FigureModel();
        figureModel.setFxmlId(fxmlId);
        this.figureViewBuilder = new FigureViewBuilder(figureModel, unicodeFigure, this::onMouseClickSelectFigure);
        this.position = position;
        this.selectFigure = selectFigure;
    }

    /**
     * Executes the {@link #selectFigure}
     * @param runnable
     */
    private void onMouseClickSelectFigure(Runnable runnable) {
        runnable.run();
        selectFigure.accept(this);
    }

    /**
     * Returns the possible movements. No checks are made in this case (e.g. if a figure blocks the path).
     * @return A list of all the possible positions the figure can move to.
     */
    public abstract List<Position> move();

    /**
     * Returns the built figure view as a Region (for more interchangeability).
     * @return Figure view built by the FigureViewBuilder.
     */
    public Region getView() {
        return figureViewBuilder.build();
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void selectFigure(boolean isSelected) {
        figureModel.setIsSelected(isSelected);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color=" + color +
                ", figureModel=" + figureModel +
                ", figureViewBuilder=" + figureViewBuilder +
                ", position=" + position +
                ", selectFigure=" + selectFigure +
                '}';
    }
}
