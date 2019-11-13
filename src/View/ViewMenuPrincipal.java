package View;

import Controller.ControllerMenu;
import Model.Menu;
import Model.Parallax;
import Tool.Cst;
import Tool.NodeIniter;
import Tool.Path;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class ViewMenuPrincipal{

    private Group root;
    private Menu model;
    private Label txtTitle;
    private Button btnStart, btnOption, btnExit;
    private VBox vBox;
    private Parallax parallax;

    ViewMenuPrincipal(Group root, Menu model){
        this.root = root;
        this.model = model;

        parallax = new Parallax(Path.urlParallaxMenuPrincipalBackgroundImg, Cst.screenWidth,Cst.screenHeight);


        txtTitle = NodeIniter.initTitle(100,"HUNGRY FISH");
        VBox.setMargin(txtTitle,new Insets(100,0,50,0));
        btnStart = NodeIniter.initBtn(20, "JOUER", "btn");
        btnOption = NodeIniter.initBtn(20,"OPTION","btn");
        btnExit = NodeIniter.initBtn(20, "QUITTER","btn");

        initVBox();

    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        root.getChildren().add(parallax.getRoot());
        root.getChildren().add(vBox);
    }

    public void initVBox(){
        vBox = new VBox();
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);

        vBox.getChildren().add(txtTitle);
        vBox.getChildren().add(btnStart);
        vBox.getChildren().add(btnOption);
        vBox.getChildren().add(btnExit);
    }

    void setEvents(ControllerMenu controllerMenu){
        btnStart.setOnMouseClicked(controllerMenu);
        btnOption.setOnMouseClicked(controllerMenu);
        btnExit.setOnMouseClicked(controllerMenu);

        for(Node node: vBox.getChildren()){
            node.setOnMouseMoved(controllerMenu);
        }

        vBox.setOnMouseMoved(controllerMenu);
        root.setOnMouseMoved(controllerMenu);
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Button getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

    public Parallax getParallax(){
        return parallax;
    }

}
