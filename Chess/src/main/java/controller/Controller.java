/*
 * Classname: Controller
 *
 * Version information: 0.1
 *
 * Date: 01 June 2020
 *
 * Copyright notice: -
 */

package controller;

/**
 * Base abstract class controller
 */
public abstract class Controller {

    protected ControlStation controlStation;

    /**
     * Initialize controller with reference to controlStation
     * @param controlStation
     */
    public Controller(ControlStation controlStation) {
        this.controlStation = controlStation;
    }
}
