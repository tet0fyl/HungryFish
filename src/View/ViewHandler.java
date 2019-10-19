package View;

import Controller.ControllerInGame;
import Controller.ControllerMenu;
import Model.InGame;
import Model.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewInGame ig;
    private Menu mm;
    private InGame mig;
    private ControllerMenu cm;
    private ControllerInGame cig;
    private Group root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new Group();
        scene = new Scene(root);

        mm = new Menu();
        mig = new InGame();

        mp = new ViewMenuPrincipal(mm,root);

        cm = new ControllerMenu(this, mm);
        cig = new ControllerInGame(this, mig);

        primaryStage.setTitle("HungryFish");
        //primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
    }

    public void setEventHandlerInGame(ControllerInGame cig){ig.setEvents(cig);}

    public ViewMenuPrincipal getMp() {
        return mp;
    }

    public ViewInGame getIg(){return ig;}

    public void setIg(ViewInGame ig){this.ig=ig;}

    public void launchViewInGame(){this.ig= new ViewInGame(mig,this.root);}

}
