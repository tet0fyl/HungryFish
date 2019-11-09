package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Model.Menu;
import Model.Parallax;
import Model.Scroll;
import Tool.Cst;
import Tool.Path;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ViewInGame {

    private Group root;
    private Menu model;
    private Button btnReturn;
    private ImageView imgBackground;
    private Label lblGameOver;
    private VBox vBoxGameOverPopUp;
    private Parallax parallax;


    ViewInGame(Group root, Menu model){
        this.root = root;
        this.model = model;
        vBoxGameOverPopUp = initvBoxGameOverPopUp();


        btnReturn = initBtnRightOrLeft(20,"RETOUR","left");
        btnReturn.setLayoutY(25);

    }

    public  void clearAndInitRoot(){

        //initBackground();
        parallax = new Parallax(Path.urlParallaxLevelBackgroundImg, Scroll.maxX,Scroll.maxY,Parallax.game);
        root.getChildren().clear();
        //root.getChildren().add(imgBackground);
        root.getChildren().add(parallax.getRoot());
        root.getChildren().add(btnReturn);
    }


    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
    }

    public VBox initvBoxGameOverPopUp(){
        VBox vBox = new VBox();
        vBox.setMinWidth(Cst.screenWidth);
        vBox.setAlignment(Pos.CENTER);
        lblGameOver = initText(90,"GAME OVER");
        vBox.getChildren().add(lblGameOver);
        return vBox;
    }

    public Label initText(int fontSize, String textContent){
        Label t = new Label();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public Button initBtnRightOrLeft(int fontSize, String textContent,String position){
        Button b = new Button(textContent);
        double width = 150;
        double middle;
        b.setMinWidth(width);
        if(position.equals("right")){
            middle = (Screen.getPrimary().getBounds().getWidth()/5)*4 - (width/2);
        }
        else if (position.equals("left")){
            middle = (Screen.getPrimary().getBounds().getWidth()/5) - (width/2);
        }else{
            middle = (Screen.getPrimary().getBounds().getWidth()/2) - (width/2);
        }
        b.setLayoutX(middle);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        b.getStyleClass().add("btn-secondary");
        return b;
    }

    public void setEvents(ControllerInGameMouse controller){
        btnReturn.setOnMouseClicked(controller);

    }

    public void setEvents(ControllerInGameKeyboard controller){
        root.setOnKeyPressed(controller);
        root.setOnKeyReleased(controller);
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

    public Group getRoot() {
        return root;
    }

    public Parallax getParallax() {
        return parallax;
    }

    public ImageView getImgBackground() {
        return imgBackground;
    }
}
