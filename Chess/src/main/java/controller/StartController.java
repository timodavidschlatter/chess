/*
 * Classname: StartController
 *
 * Version information: 0.1
 *
 * Date: 26 May 2020
 *
 * Copyright notice: -
 */

package controller;

import javafx.fxml.FXML;
import logic.Game;

/**
 * Class responsible for all functions on StartView.fxml
 */
public class StartController extends Controller {

    /**
     * Initializes StartController with reference to controlStation
     * @param controlStation
     */
    public StartController(ControlStation controlStation) {
        super(controlStation);
    }

    /**
     * Shows game view
     */
    @FXML
    public void startGame() {
        Game game = new Game();
        controlStation.setGame(game);
        controlStation.showGameView();
    }
}
