package Controller;

import Model.BubblePop;
import Model.Menu;
import Timeline.JeuTL;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Hashtable;

public class ControllerInGameKeyboard implements EventHandler<KeyEvent> {

    private JeuTL jeuTL;
    private ViewHandler launcher;
    private Menu model;
    private Hashtable<KeyCode,Boolean> listKeyPressed= new Hashtable<KeyCode,Boolean>();
    private BubblePop bubblePop;

    public ControllerInGameKeyboard(ViewHandler launcher, Menu model){
        this.model = model;
        this.launcher = launcher;
    }


    /** Fonction qui permet de demarer la timeline du jeu */
    public void startJeuTL(){
        launcher.getScene().setCursor(Cursor.NONE);
        jeuTL = new JeuTL(this);
        this.launcher.setEventHandlerInGameKeyboard(this);
        jeuTL.start();
        bubblePop = new BubblePop();
        bubblePop.generateBubbleList(10,launcher.getViewInGame().getRoot());
        launcher.getViewInGame().getRoot().requestFocus();
    }

    /** Fonction qui permet d'areter la timeline du jeu */
    public void stopJeuTL(){
        if(jeuTL!=null){
            /** On remet la camera a sa position initiale */
            jeuTL.getScroll().getCamera().setLayoutX(0);
            jeuTL.getScroll().getCamera().setLayoutY(0);
            jeuTL.getScroll().getCamera().setTranslateZ(0);
            /** On ecrase la liste des poisson et la varaible jeuTL (pour faire propre) */
            bubblePop = null;
            jeuTL.eraseListOfFish();
            jeuTL = null;
        }
    }


    @Override
    public void handle(KeyEvent event) {
        /** CONDITION QUI PERMET DEVITER UNE ERREUR AU LANCEMENT DE LAPPLICATION */
        if(jeuTL!=null){
            bubblePop.launchBubble(jeuTL.getPlayer().getX(),jeuTL.getPlayer().getY());
        }

        /** CONTROLE LA LISTE DE TOUCHE PRESSER OU RELACHER */

        if(event.getEventType() == KeyEvent.KEY_PRESSED){
            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),true);
            }else{
                listKeyPressed.put(event.getCode(),true);
            }
        }
        if (event.getEventType() == KeyEvent.KEY_RELEASED){

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),false);
            }else{
                listKeyPressed.put(event.getCode(),false);
            }
        }
    }

    public ViewHandler getLauncher() {
        return launcher;
    }

    public Hashtable<KeyCode, Boolean> getListKeyPressed() {
        return listKeyPressed;
    }
}