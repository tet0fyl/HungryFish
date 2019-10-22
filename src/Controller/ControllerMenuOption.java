package Controller;

import Model.ModelMenuOption;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenuOption implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private ModelMenuOption model;

    public ControllerMenuOption(ViewHandler launcher, ModelMenuOption model){
        this.launcher = launcher;
        this.model = model;
        this.launcher.setEventHandlerMenuOption(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {


    }
}
