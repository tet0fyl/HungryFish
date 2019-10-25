package Controller;

import Model.ModelInGame;
import View.ViewHandler;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControllerInGameMouse implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private ModelInGame model;

    public ControllerInGameMouse(ViewHandler launcher, ModelInGame model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGame(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getVig().getBtnReturn())){
            launcher.getVig().getBtnReturn().disarm();
            launcher.launchViewMenuPrincipal();
        }
    }
}
