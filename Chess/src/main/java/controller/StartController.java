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
import logic.GameOld;

/**
 * Class responsible for all functions on StartView.fxml
 */
public class StartController extends FXMLController {

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
        GameOld gameOld = new GameOld();
        controlStation.setGame(gameOld);
        controlStation.showGameView();
    }
}
