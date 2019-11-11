package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerInGameMouse implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private Menu model;

    public ControllerInGameMouse(ViewHandler launcher, Menu model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGame(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getViewInGame().getBtnReturnMenu())){
            launcher.afficherMenuPrincipal();
        }
    }
}
