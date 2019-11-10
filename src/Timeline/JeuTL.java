package Timeline;

import Controller.ControllerInGameKeyboard;
import Model.Fish.*;
import Model.Scroll;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Hashtable;

public class JeuTL extends AnimationTimer {

    private ControllerInGameKeyboard controllerInGameKeyboard;
    private ArrayList<Fish> listFishPNJ = new ArrayList<Fish>();
    private PlayerFish player;
    private Scroll scroll;
    private boolean gameOver;

    public JeuTL (ControllerInGameKeyboard controllerInGameKeyboard){
        gameOver=false;
        this.controllerInGameKeyboard = controllerInGameKeyboard;
        generateFish(this.controllerInGameKeyboard.getLauncher().getViewInGame().getRoot(),20);
        player = new PlayerFish();
        this.controllerInGameKeyboard.getLauncher().getViewInGame().getRoot().getChildren().add(player.getMainImg());
        scroll = new Scroll(this.controllerInGameKeyboard.getLauncher().getViewInGame().getParallax(),player,controllerInGameKeyboard.getLauncher().getScene());
        scroll.getParallax().initForGround(this.controllerInGameKeyboard.getLauncher().getViewInGame().getRoot());
        scroll.getParallax().move(scroll.getCamera().getLayoutX(),scroll.getCamera().getLayoutY());
    }

    public void generateFish(Group root , int nbFish){
        for (int i = 0; i < nbFish ; i++) {
            addFish(root);
        }
    }

    public void addFish(Group root){
        Fish newfish;
        int random = (int)(Math.random()* 20);
        if(random>18){
            newfish = new Shark();
        }else if (random>15){
            newfish = new BigFish();
        }else if(random>8){
            newfish = new MediumFish();
        }else{
            newfish = new SmallFish();
        }
        listFishPNJ.add(newfish);
        root.getChildren().add(newfish.getMainImg());
    }


    @Override
    public void handle(long now) {
        if(controllerInGameKeyboard.getListKeyPressed().get(KeyCode.RIGHT) != null && controllerInGameKeyboard.getListKeyPressed().get(KeyCode.RIGHT)){
            player.move(Fish.moveRight);
            scroll.move(Scroll.moveRight);
        }else if(controllerInGameKeyboard.getListKeyPressed().get(KeyCode.LEFT) != null && controllerInGameKeyboard.getListKeyPressed().get(KeyCode.LEFT)){
            player.move(Fish.moveLeft);
            scroll.move(Scroll.moveLeft);
        }

        if(controllerInGameKeyboard.getListKeyPressed().get(KeyCode.UP) != null && controllerInGameKeyboard.getListKeyPressed().get(KeyCode.UP)){
            player.move(Fish.moveUp);
            scroll.move(Scroll.moveUp);
        }else if(controllerInGameKeyboard.getListKeyPressed().get(KeyCode.DOWN) != null && controllerInGameKeyboard.getListKeyPressed().get(KeyCode.DOWN)){
            player.move(Fish.moveDown);
            scroll.move(Scroll.moveDown);
        }

        for(int i = 0; i < listFishPNJ.size(); i++){
            if (!listFishPNJ.get(i).getIsAlive()){
                controllerInGameKeyboard.getLauncher().getViewInGame().getRoot().getChildren().remove(listFishPNJ.get(i).getMainImg());
                listFishPNJ.remove(listFishPNJ.get(i));
                generateFish(this.controllerInGameKeyboard.getLauncher().getViewInGame().getRoot(),1);
            }
        }


        for(int i = 0; i < listFishPNJ.size(); i++){
            if(player.getMainImg().intersects(listFishPNJ.get(i).getMainImg().getBoundsInLocal()) && !listFishPNJ.get(i).getIsDying()){
                if(player.getSize() > listFishPNJ.get(i).getSize()) {
                    player.eat(listFishPNJ.get(i));
                    scroll.deZoom();
                }else{
                  listFishPNJ.get(i).eat(player);
                  gameOver=true;
                  this.stop();
              }
            }
        }

        for (int i = 0; i < listFishPNJ.size(); i++){
            for (int j = 0; j < listFishPNJ.size(); j++) {
                if (listFishPNJ.get(i).getMainImg().intersects(listFishPNJ.get(j).getMainImg().getBoundsInLocal()) && !listFishPNJ.get(j).getIsDying()) {
                    if (listFishPNJ.get(i).getSize() > listFishPNJ.get(j).getSize() && !listFishPNJ.get(j).getClass().equals(Shark.class)) {
                        listFishPNJ.get(i).eat(listFishPNJ.get(j));
                    }
                }
            }
        }

    }

    public Scroll getScroll() {
        return scroll;
    }

    public boolean getGameOver(){
        return gameOver;
    }
}
