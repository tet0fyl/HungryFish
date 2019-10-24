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

        model.bubbles.generateBubbleList(40,launcher.getVmp().getRoot());
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        model.bubbles.launchBubble(mouseEvent.getScreenX(),mouseEvent.getScreenY());
        model.parallax.move(mouseEvent.getScreenX(),mouseEvent.getScreenY());
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            if(mouseEvent.getSource().equals(launcher.getVmp().getBtnStart())){
                launcher.launchViewInGame();
            }
            if(mouseEvent.getSource().equals(launcher.getVmp().getBtnOption())){
                launcher.launchViewMenuOption();
            }
            if(mouseEvent.getSource().equals(launcher.getVmp().getBtnExit())){
                launcher.getPrimaryStage().close();
            }
        }
    }
}
