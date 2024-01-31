package game.tile;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Builder;

import java.util.function.Consumer;

public class TileViewBuilder implements Builder<StackPane> {

    private final TileModel tileModel;
    private final Color color;
    private final Consumer<Runnable> clickTile;


    public TileViewBuilder(TileModel tileModel, Color color, Consumer<Runnable> clickTile) {
        this.tileModel = tileModel;
        this.color = color;
        this.clickTile = clickTile;

    }

    @Override
    public StackPane build() {
        // TODO Das wird jedes mal neu gebildet. Das Tile muss wissen, welche Figur sie als Kind element hat.
        StackPane tileView = new StackPane();
        tileView.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        tileView.setOnMouseClicked(evt -> clickTile.accept(() -> {})); // TODO Wahrscheinlich brauche ich kein Runnable hier
        tileModel.hasFigureProperty().bind(Bindings.isNotEmpty(tileView.getChildren()));
        return tileView;
    }
}
