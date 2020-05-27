package controller;

public abstract class Controller {

    protected ControlStation controlStation;

    public Controller(ControlStation controlStation) {
        this.controlStation = controlStation;
    }

    public ControlStation getControlStation() {
        return controlStation;
    }
}
