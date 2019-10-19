package Controller;

import Model.ModelMenuPrincipal;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenuPrincipal implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private ModelMenuPrincipal model;

    public ControllerMenuPrincipal(ViewHandler launcher, ModelMenuPrincipal model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerMenu(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(launcher.getVmp().getBtnStart())){
            launcher.launchViewInGame();
        }
        if(mouseEvent.getSource().equals(launcher.getVmp().getBtnOption())){
            System.out.println("Click click");
            launcher.launcViewMenuOption();
        }
    }

}
