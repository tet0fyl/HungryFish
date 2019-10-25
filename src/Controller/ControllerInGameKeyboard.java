package Controller;

import Model.Fish;
import Model.ModelInGame;
import View.ViewHandler;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Hashtable;

public class ControllerInGameKeyboard extends AnimationTimer implements EventHandler<KeyEvent> {

    private ViewHandler launcher;
    private ModelInGame model;
    private Hashtable<KeyCode,Boolean> listKeyPressed= new Hashtable<KeyCode,Boolean>();

    public ControllerInGameKeyboard(ViewHandler launcher, ModelInGame model){
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerInGameKeyboard(this);

        model.generateFish(launcher.getVig().getRoot());

        this.start();
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_RELEASED){

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),false);
            }else{
                listKeyPressed.put(event.getCode(),false);
            }
        }
        if(event.getEventType() == KeyEvent.KEY_PRESSED){

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),true);
            }else{
                listKeyPressed.put(event.getCode(),true);
            }
        }
    }

    @Override
    public void handle(long l) {
        if(listKeyPressed.get(KeyCode.RIGHT) != null && listKeyPressed.get(KeyCode.RIGHT).booleanValue() || listKeyPressed.get(KeyCode.D) != null && listKeyPressed.get(KeyCode.D).booleanValue()){
            model.getPlayer().move(Fish.moveRight);
        }

        if(listKeyPressed.get(KeyCode.LEFT) != null && listKeyPressed.get(KeyCode.LEFT).booleanValue() || listKeyPressed.get(KeyCode.A) != null && listKeyPressed.get(KeyCode.A).booleanValue()){
            model.getPlayer().move(Fish.moveLeft);
        }

        if(listKeyPressed.get(KeyCode.UP) != null && listKeyPressed.get(KeyCode.UP).booleanValue() || listKeyPressed.get(KeyCode.W) != null && listKeyPressed.get(KeyCode.W).booleanValue()){
            model.getPlayer().move(Fish.moveUp);
        }

        if(listKeyPressed.get(KeyCode.DOWN) != null && listKeyPressed.get(KeyCode.DOWN).booleanValue() || listKeyPressed.get(KeyCode.S) != null && listKeyPressed.get(KeyCode.S).booleanValue() ){
            model.getPlayer().move(Fish.moveDown);
        }
    }
}