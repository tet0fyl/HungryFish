package Timeline;

import Controller.ControllerInGameKeyboard;
import Model.Fish.*;
import Model.Hud;
import Model.Scroll;
import View.ViewInGame;
import javafx.animation.AnimationTimer;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class JeuTL extends AnimationTimer {

    private ControllerInGameKeyboard controllerInGameKeyboard;
    private ArrayList<Fish> listFishPNJ = new ArrayList<Fish>();
    private PlayerFish player;
    private Scroll scroll;
    private Hud hud;
    private ViewInGame viewGame;


    public JeuTL (ControllerInGameKeyboard controllerInGameKeyboard){
        this.controllerInGameKeyboard = controllerInGameKeyboard;
        viewGame=controllerInGameKeyboard.getLauncher().getViewInGame();
        generateFish(viewGame.getRoot(),50);
        player = new PlayerFish();
        viewGame.getRoot().getChildren().add(player.getMainImg());
        scroll = new Scroll(viewGame.getImgBackground(),player,controllerInGameKeyboard.getLauncher().getScene());
        hud = new Hud(player,scroll,viewGame);
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

    public void gameOver(){
        controllerInGameKeyboard.getLauncher().getScene().setCursor(Cursor.DEFAULT);
        viewGame.getGameOverPopUp().setLayoutX(scroll.getCamera().getLayoutX());
        viewGame.getGameOverPopUp().setLayoutY(scroll.getCamera().getLayoutY());
        viewGame.getGameOverPopUp().setTranslateZ(scroll.getCamera().getTranslateZ());
        viewGame.getRoot().getChildren().add(viewGame.getGameOverPopUp());
        this.stop();

    }

    public void eraseListOfFish(){
        for (int i = 0; i < listFishPNJ.size(); i++) {
            ((FishPNJ) listFishPNJ.get(i)).animationStop();
        }

        listFishPNJ = null;
    }


    @Override
    public void handle(long now) {

        /** DEPLACEMENT DU PLAYER ET DU SCROLL */

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

            /**  REGLE DU JEU  : LES POISSONS MANGE D'AUTRE POISSON */

        for(int i = 0; i < listFishPNJ.size(); i++){
            if (!listFishPNJ.get(i).getIsAlive()){
                viewGame.getRoot().getChildren().remove(listFishPNJ.get(i).getMainImg());
                listFishPNJ.remove(listFishPNJ.get(i));
                generateFish(viewGame.getRoot(),1);
            }
        }

        /**  REGLE DU JEU  : LE PLAYER MANGE D'AUTRE POISSON OU SE FAIT MANGER PUIS GAME OVER */

        for(int i = 0; i < listFishPNJ.size(); i++){
            if(player.getMainImg().intersects(listFishPNJ.get(i).getMainImg().getBoundsInLocal()) && !listFishPNJ.get(i).getIsDying()){
                if(player.getSize() > listFishPNJ.get(i).getSize()) {
                    player.eat(listFishPNJ.get(i));
                    scroll.deZoom(listFishPNJ.get(i).getSize());
                }else{
                  listFishPNJ.get(i).eat(player);
                  gameOver();
                }
            }
        }

        /**  REGLE DU JEU  : SI UN POISSON MEURT IL EST ENLVER DE LA LISTE APRES SON ANIMATION */

        for (int i = 0; i < listFishPNJ.size(); i++){
            for (int j = 0; j < listFishPNJ.size(); j++) {
                if (listFishPNJ.get(i).getMainImg().intersects(listFishPNJ.get(j).getMainImg().getBoundsInLocal()) && !listFishPNJ.get(j).getIsDying()) {
                    if (listFishPNJ.get(i).getSize() > listFishPNJ.get(j).getSize() && !listFishPNJ.get(j).getClass().equals(Shark.class)) {
                        listFishPNJ.get(i).eat(listFishPNJ.get(j));
                    }
                }
            }
        }

        /**  ON MET A JOUR LE HUD */

        hud.stickAndRefreshHud();

        /**  TOUCHE EXIT PRESSED POUR QUITTER */

        if(controllerInGameKeyboard.getListKeyPressed().get(KeyCode.ESCAPE) != null && controllerInGameKeyboard.getListKeyPressed().get(KeyCode.ESCAPE)){
            controllerInGameKeyboard.getLauncher().getPrimaryStage().setFullScreen(true);
            controllerInGameKeyboard.getLauncher().getPrimaryStage().setResizable(false);
            this.stop();
            controllerInGameKeyboard.getLauncher().afficherMenuPrincipal();
        }

    }

    public Scroll getScroll() {
        return scroll;
    }

    public PlayerFish getPlayer() {
        return player;
    }
}
