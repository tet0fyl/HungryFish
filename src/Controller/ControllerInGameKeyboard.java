package Controller;

import Model.ModelInGame;
import View.ViewHandler;
import javafx.event.EventHandler;
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
            System.out.println("Vous avez appuyer sur la touche " + event.getCode());
        }
    }
}