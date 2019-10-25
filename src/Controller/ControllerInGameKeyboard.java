package Controller;

import Model.Fish;
import Model.ModelInGame;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerInGameKeyboard implements EventHandler<KeyEvent> {

    private ViewHandler launcher;
    private ModelInGame model;

    public ControllerInGameKeyboard(ViewHandler launcher, ModelInGame model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGameKeyboard(this);
    }

    @Override
    public void handle(KeyEvent event) {
        if(event.getEventType().equals(KeyEvent.KEY_PRESSED)){
            if(event.getCode().equals(KeyCode.RIGHT)){
                model.getPlayer().move(Fish.moveRight);
            }
            if(event.getCode().equals(KeyCode.LEFT)){
                model.getPlayer().move(Fish.moveLeft);
            }
            if(event.getCode().equals(KeyCode.UP)){
                model.getPlayer().move(Fish.moveUp);
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                model.getPlayer().move(Fish.moveDown);
            }
        }else if (event.getEventType() == KeyEvent.KEY_RELEASED){

        }
    }
}