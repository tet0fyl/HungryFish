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

        this.start();
    }

    @Override
    public void handle(KeyEvent event) {

        if(event.getEventType() == KeyEvent.KEY_PRESSED){
            System.out.println("On presse");

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),true);
            }else{
                listKeyPressed.put(event.getCode(),true);
            }
        }

        if (event.getEventType() == KeyEvent.KEY_RELEASED){
            System.out.println("On release");

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),false);
            }else{
                listKeyPressed.put(event.getCode(),false);
            }
        }



    }

    @Override
    public void handle(long l) {
        if(listKeyPressed.get(KeyCode.RIGHT) != null && listKeyPressed.get(KeyCode.RIGHT).booleanValue()){
            model.getPlayer().move(Fish.moveRight);
        }

        if(listKeyPressed.get(KeyCode.LEFT) != null && listKeyPressed.get(KeyCode.LEFT).booleanValue()){
            model.getPlayer().move(Fish.moveLeft);
        }

        if(listKeyPressed.get(KeyCode.UP) != null && listKeyPressed.get(KeyCode.UP).booleanValue()){
            model.getPlayer().move(Fish.moveUp);
        }

        if(listKeyPressed.get(KeyCode.DOWN) != null && listKeyPressed.get(KeyCode.DOWN).booleanValue()){
            model.getPlayer().move(Fish.moveDown);
        }
    }
}