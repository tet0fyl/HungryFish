package View;

import Controller.ControllerMenu;
import Model.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private Menu model;
    private ControllerMenu cm;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);

        model = new Menu();

        mp = new ViewMenuPrincipal(model,root);
        cm = new ControllerMenu(this,model);
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

    public ViewMenuPrincipal getMp() {
        return mp;
    }

}
