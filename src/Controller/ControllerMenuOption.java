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
        if (mouseEvent.getSource().equals(launcher.getVmo().getBtnReturn())) {
            launcher.getVmo().getBtnReturn().disarm();
            launcher.launchViewMenuPrincipal();
        }
        if (mouseEvent.getSource().equals(launcher.getVmo().getBtnValider())) {
            launcher.getVmo().getBtnValider().disarm();
            launcher.launchViewMenuPrincipal();
        }
        if(mouseEvent.getSource().equals(launcher.getVmo().getBtnImpossible())){
            launcher.getVmo().getBtnImpossible().getStyleClass().add("btnOptionPressed");

            launcher.getVmo().getBtnEasy().getStyleClass().clear();
            launcher.getVmo().getBtnEasy().getStyleClass().add("btn-secondary");
            launcher.getVmo().getBtnMedium().getStyleClass().clear();
            launcher.getVmo().getBtnMedium().getStyleClass().add("btn-secondary");
        }

        if(mouseEvent.getSource().equals(launcher.getVmo().getBtnEasy())){
            launcher.getVmo().getBtnEasy().getStyleClass().add("btnOptionPressed");

            launcher.getVmo().getBtnImpossible().getStyleClass().clear();
            launcher.getVmo().getBtnImpossible().getStyleClass().add("btn-secondary");
            launcher.getVmo().getBtnMedium().getStyleClass().clear();
            launcher.getVmo().getBtnMedium().getStyleClass().add("btn-secondary");
        }

        if(mouseEvent.getSource().equals(launcher.getVmo().getBtnMedium())){
            launcher.getVmo().getBtnMedium().getStyleClass().add("btnOptionPressed");

            launcher.getVmo().getBtnEasy().getStyleClass().clear();
            launcher.getVmo().getBtnEasy().getStyleClass().add("btn-secondary");
            launcher.getVmo().getBtnImpossible().getStyleClass().clear();
            launcher.getVmo().getBtnImpossible().getStyleClass().add("btn-secondary");
        }
    }
}
