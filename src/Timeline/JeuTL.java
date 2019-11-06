package Timeline;

import Controller.ControllerInGameKeyboard;
import Model.Fish;
import javafx.animation.AnimationTimer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JeuTL extends AnimationTimer {

    private ControllerInGameKeyboard controllerInGameKeyboard;

    public JeuTL (ControllerInGameKeyboard controllerInGameKeyboard){
        this.controllerInGameKeyboard = controllerInGameKeyboard;
        this.controllerInGameKeyboard.getModel().generateFish(this.controllerInGameKeyboard.getLauncher().getVig().getRoot(),15);

        this.start();
    }

    @Override
    public void handle(long now) {
        ArrayList<Fish> listOfFish = controllerInGameKeyboard.getModel().getListFishPNJ();
        for(int i = 0; i < listOfFish.size(); i++){
            if(controllerInGameKeyboard.getModel().getPlayer().getMainImg().intersects(listOfFish.get(i).getMainImg().getBoundsInLocal())){
                controllerInGameKeyboard.getModel().getPlayer().eat(listOfFish.get(i));
                //System.out.println(fish.getIsAlive());
            }

            if (!listOfFish.get(i).getIsAlive()){
                controllerInGameKeyboard.getLauncher().getVig().getRoot().getChildren().remove(listOfFish.get(i).getMainImg());
                controllerInGameKeyboard.getModel().getListFishPNJ().remove(listOfFish.get(i));
                controllerInGameKeyboard.getModel().generateFish(this.controllerInGameKeyboard.getLauncher().getVig().getRoot(),1);
                //System.out.println("Un poisson a été manger");
            }
        }

    }
}
