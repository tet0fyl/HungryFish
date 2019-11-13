package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Controller.ControllerMenu;
import Model.Menu;
import Tool.Path;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal viewMenuPrincipal;
    private ViewInGame viewInGame;
    private ViewMenuOption viewMenuOption;
    private Menu model;
    private ControllerMenu controllerMenu;
    private ControllerInGameMouse controllerInGameMouse;
    private ControllerInGameKeyboard controllerInGameKeyboard;
    private Group root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        scene = new Scene(root,800,800, Color.CORNFLOWERBLUE);

        this.primaryStage = primaryStage;

        /** ON INITIALISE LE MODEL MVC */

        model = new Menu();
        viewMenuPrincipal = new ViewMenuPrincipal(root, model);
        viewMenuOption = new ViewMenuOption(root,model);
        viewInGame = new ViewInGame(root,model);
        controllerInGameKeyboard = new ControllerInGameKeyboard(this,model);
        controllerInGameMouse = new ControllerInGameMouse(this, model);
        controllerMenu = new ControllerMenu(this, model);

        /** ON AFFICHE PAR DEFAULT LE MENU PRINCIPAL */

        afficherMenuPrincipal();

        /** ON EDITE LA SCENE */
        root.getStylesheets().add(Path.urlStyleshet);
        primaryStage.setTitle("HungryFish");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        viewMenuPrincipal.setEvents(cm);
    }

    public void setEventHandlerOption(ControllerMenu cm) {
        viewMenuOption.setEvents(cm);
    }

    public void setEventHandlerInGame(ControllerInGameMouse cig){ viewInGame.setEvents(cig);}

    public void setEventHandlerInGameKeyboard(ControllerInGameKeyboard cigk){
        viewInGame.setEvents(cigk);
    }

    public ViewMenuPrincipal getViewMenuPrincipal() {
        return viewMenuPrincipal;
    }

    public ViewMenuOption getViewMenuOption() {
        return viewMenuOption;
    }

    public ViewInGame getViewInGame(){return viewInGame;}

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public Scene getScene() {
        return scene;
    }

    /** LES METHODES SUIVANTES INITIALISE LE ROOT DE CHAQUE VUE EN DETRUISANT DES VALEURS */
    public void afficherMenuPrincipal(){
        scene.setCursor(Cursor.DEFAULT);
        viewMenuPrincipal.clearAndInitRoot();
        controllerInGameKeyboard.stopJeuTL();
        controllerMenu.initObject();
    }

    public void afficherJeu(){
        scene.setCursor(Cursor.NONE);
        viewInGame.clearAndInitRoot();
        controllerMenu.destroyObject();
        controllerInGameKeyboard.startJeuTL();
    }

    public void afficherMenuOption(){
        viewMenuOption.clearAndInitRoot();
        controllerMenu.destroyObject();
    }

}
