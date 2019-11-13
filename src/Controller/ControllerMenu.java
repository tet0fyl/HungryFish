package Controller;

import Model.BubblePop;
import Model.Menu;
import Tool.Path;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private Menu model;
    private BubblePop bubblePop;


    public ControllerMenu(ViewHandler launcher, Menu model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerMenu(this);
        this.launcher.setEventHandlerOption(this);

    }

    public void initObject(){
        bubblePop = new BubblePop();
        bubblePop.generateBubbleList(20,launcher.getViewMenuPrincipal().getRoot());
    }

    public void destroyObject(){
        bubblePop = null;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if(bubblePop!=null){
            bubblePop.launchBubble(mouseEvent.getScreenX(),mouseEvent.getScreenY());
        }

        launcher.getViewMenuPrincipal().getParallax().move(mouseEvent.getScreenX(),mouseEvent.getScreenY());

        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            if(mouseEvent.getSource().equals(launcher.getViewMenuPrincipal().getBtnStart())){
                launcher.afficherJeu();
            }
            if(mouseEvent.getSource().equals(launcher.getViewMenuPrincipal().getBtnOption())){
                launcher.afficherMenuOption();
            }
            if(mouseEvent.getSource().equals(launcher.getViewMenuPrincipal().getBtnExit())){
                launcher.getPrimaryStage().close();
            }
            if (mouseEvent.getSource().equals(launcher.getViewMenuOption().getBtnReturn())) {
                launcher.afficherMenuPrincipal();
            }
            if (mouseEvent.getSource().equals(launcher.getViewMenuOption().getBtnValider())) {
                launcher.afficherMenuPrincipal();
            }
            if(mouseEvent.getSource().equals(launcher.getViewMenuOption().getBtnImpossible())){
                launcher.getViewMenuOption().getBtnImpossible().getStyleClass().add("btnOptionPressed");
                model.updateDifficulte(Menu.IMPOSSIBLE);

                launcher.getViewMenuOption().getBtnEasy().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnEasy().getStyleClass().add("btn-secondary");
                launcher.getViewMenuOption().getBtnMedium().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnMedium().getStyleClass().add("btn-secondary");
            }

            if(mouseEvent.getSource().equals(launcher.getViewMenuOption().getBtnEasy())){
                launcher.getViewMenuOption().getBtnEasy().getStyleClass().add("btnOptionPressed");
                model.updateDifficulte(Menu.FACILE);

                launcher.getViewMenuOption().getBtnImpossible().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnImpossible().getStyleClass().add("btn-secondary");
                launcher.getViewMenuOption().getBtnMedium().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnMedium().getStyleClass().add("btn-secondary");
            }

            if(mouseEvent.getSource().equals(launcher.getViewMenuOption().getBtnMedium())){
                launcher.getViewMenuOption().getBtnMedium().getStyleClass().add("btnOptionPressed");
                model.updateDifficulte(Menu.MOYEN);

                launcher.getViewMenuOption().getBtnEasy().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnEasy().getStyleClass().add("btn-secondary");
                launcher.getViewMenuOption().getBtnImpossible().getStyleClass().clear();
                launcher.getViewMenuOption().getBtnImpossible().getStyleClass().add("btn-secondary");
            }

            if(mouseEvent.getPickResult().getIntersectedNode().getId() != null){
                String nbDuSkin = mouseEvent.getPickResult().getIntersectedNode().getId();

                for (int i = 0; i < launcher.getViewMenuOption().getListSkin().size() ; i++) {
                    ImageView img = launcher.getViewMenuOption().getListSkin().get(i);
                    if(img.getId().equals(nbDuSkin)){
                        img.setOpacity(0.5);
                    }else{
                        img.setOpacity(1);
                    }

                }
                    model.setSkin(Path.skinMainFish + nbDuSkin);
            }
            }

    }
}
