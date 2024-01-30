package game.tile;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class TileView extends StackPane {

    // TODO make TileViewBuilder out of it
    public TileView(TileModel model, Color color, Consumer<Runnable> clickTile) {
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        model.hasFigureProperty().bind(Bindings.isNotEmpty(this.getChildren()));

        setOnMouseClicked(evt -> {

            clickTile.accept(() -> {});// TODO Wahrscheinlich brauche ich kein Runnable hier

        });
    }
}
