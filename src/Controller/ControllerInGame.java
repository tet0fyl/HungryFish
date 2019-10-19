package Controller;

import Model.InGame;
import View.ViewHandler;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControllerInGame implements EventHandler {

    private ViewHandler launcher;
    private InGame model;

    public ControllerInGame(ViewHandler launcher, InGame model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGame(this);
    }

    @Override
    public void handle(Event event) {

    }
}
