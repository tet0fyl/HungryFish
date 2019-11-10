package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Controller.ControllerMenu;
import Model.Menu;
import Tool.Path;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        scene = new Scene(root, 800, 1000);

        this.primaryStage = primaryStage;


        model = new Menu();
        viewMenuPrincipal = new ViewMenuPrincipal(root, model);
        viewMenuOption = new ViewMenuOption(root);
        viewInGame = new ViewInGame(root,model);
        controllerInGameMouse = new ControllerInGameMouse(this, model);
        controllerInGameKeyboard = new ControllerInGameKeyboard(this,model);


        controllerMenu = new ControllerMenu(this, model);

        afficherMenuPrincipal();


        primaryStage.setTitle("HungryFish");
        root.getStylesheets().add(Path.urlStyleshet);
        //primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
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

    public void afficherMenuPrincipal(){
        controllerInGameKeyboard.stopJeuTL();
        viewMenuPrincipal.clearAndInitRoot();
        controllerMenu.initObject();
    }

    public void afficherJeu(){
        viewInGame.clearAndInitRoot();
        controllerMenu.destroyObject();
        controllerInGameKeyboard.startJeuTL();
    }

    public void afficherMenuOption(){
        viewMenuOption.clearAndInitRoot();
        controllerMenu.destroyObject();
    }

}
