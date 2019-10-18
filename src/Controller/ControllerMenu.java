package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private Menu model;

    public ControllerMenu(ViewHandler launcher, Menu model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerMenu(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

    }

}
