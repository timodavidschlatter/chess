package game.tile;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Builder;

import java.util.function.Consumer;

public class TileView extends StackPane {

    // TODO make TileViewBuilder out of it
    public TileView(TileModel model, Color color, Consumer<Runnable> clickTile) {
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        model.hasFigureProperty().bind(Bindings.isNotEmpty(this.getChildren()));

        setOnMouseClicked(evt -> {
            clickTile.accept(() -> {
                System.out.println("Tile " + this.getId() + " was clicked.");
            });
        });

    }
}
