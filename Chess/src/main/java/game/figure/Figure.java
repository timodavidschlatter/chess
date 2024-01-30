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

    public Figure(String unicodeBlack, String unicodeWhite, Color color, Position position, Consumer<Figure> selectFigure) {
        this.color = color;
        String unicodeFigure = color.equals(Color.BLACK) ? unicodeBlack : unicodeWhite;
        this.figureModel = new FigureModel(unicodeFigure);
        this.figureViewBuilder = new FigureViewBuilder(figureModel, unicodeFigure, this::onMouseClickSelectFigure);
        this.position = position;
        this.selectFigure = selectFigure;
    }

    /**
     * This checks if the clicked figure can be selected and adds styling to it.
     * @param figure The figure which was clicked by the player.
     */
    private void onMouseClickSelectFigure(Runnable runnable) {
        try {
            System.out.println("Figure was clicked.");
            selectFigure.accept(this);
        } catch (NullPointerException exception) {
            System.err.println("Unexpected error. The figure selected by the player is null.");
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public abstract List<Position> move();

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
