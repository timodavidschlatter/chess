package game;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Builder;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameViewBuilder implements Builder<Region> {

    private final GameFxmlController gameFxmlController = new GameFxmlController();


    @Override
    public Region build() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"), ResourceBundle.getBundle("Bundle", new Locale("en")));

        try {
            loader.setController(gameFxmlController);
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FXML-Resource not found. ");
            Platform.exit();
        }
        return new GridPane();
    }

    public void addTileToChessBoard(StackPane tileView, int x, int y) {
        gameFxmlController.addTileToChessBoard(tileView, x, y);
    }

    public void addFiguresToChessBoard(StackPane tileView, Region figureView) {
        gameFxmlController.addFiguresToChessBoard(tileView, figureView);
    }

    public void moveFigure(StackPane oldTile, StackPane newTile, Region figureView, Color colorOfMovingFigure) {
        gameFxmlController.moveFigure(oldTile, newTile, figureView, colorOfMovingFigure);
    }
}
