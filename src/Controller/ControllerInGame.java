package Controller;

import Model.ModelInGame;
import View.ViewHandler;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControllerInGame implements EventHandler {

    private ViewHandler launcher;
    private ModelInGame model;

    public ControllerInGame(ViewHandler launcher, ModelInGame model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGame(this);
    }

    @Override
    public void handle(Event event) {
        if(event.getSource().equals(launcher.getVig().getBtnReturn())){
            launcher.launchViewMenuPrincipal();
        }
    }
}
