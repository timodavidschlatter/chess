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

public class TileViewBuilder implements Builder<StackPane> {

    private final TileModel tileModel;
    private final Color color;
    private final Consumer<Runnable> clickTile;


    public TileViewBuilder(TileModel tileModel, Color color, Consumer<Runnable> clickTile) {
        this.tileModel = tileModel;
        this.color = color;
        this.clickTile = clickTile;

    }

    // TODO: Vorteil vom Builder gegenüber direkt dem "extends StackPane"? Warum sollte ich das so machen wie ich es jetzt mache?
    @Override
    public StackPane build() {
        // TODO Das wird jedes mal neu gebildet. Das Tile muss wissen, welche Figur sie als Kind element hat.
        StackPane tileView = new StackPane();
        tileView.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        tileView.setOnMouseClicked(evt -> clickTile.accept(() -> {})); // TODO Wahrscheinlich brauche ich kein Runnable hier
        tileModel.hasFigureProperty().bind(Bindings.isNotEmpty(tileView.getChildren()));
        Bindings.bindContentBidirectional(tileView.getChildren(), tileModel.testProperty());

        //tileView.getChildren().add(new Label(tileModel.getUnicodeOfFigure()));


        /*if (tileView.getChildren().size() > 0) {
            Node node = tileView.getChildren().get(0);
            System.out.println(" Does this work? " + node.getAccessibleText());
        }*/

        return tileView;
    }
}
