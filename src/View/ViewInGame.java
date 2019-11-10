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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ViewInGame {

    private Group root;
    private Menu model;
    private ImageView imgBackground;
    private Label lblGameOver,lblScore,lblScoreValue;
    private Button btnRetourMenu;
    private VBox vBoxGameOverPopUp;
    private Parallax parallax;


    ViewInGame(Group root, Menu model){
        this.root = root;
        this.model = model;
        initvBoxGameOverPopUp();

    }

    public  void clearAndInitRoot(){

        //initBackground();
        parallax = new Parallax(Path.urlParallaxLevelBackgroundImg, Scroll.maxScrollX,Scroll.maxY,Parallax.game);
        root.getChildren().clear();
        //root.getChildren().add(imgBackground);
        root.getChildren().add(parallax.getRoot());
    }


    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
    }

    public void initvBoxGameOverPopUp(){
        vBoxGameOverPopUp = new VBox();
        vBoxGameOverPopUp.setMinWidth(Cst.screenWidth);
        vBoxGameOverPopUp.setMinHeight(Cst.screenHeight);
        vBoxGameOverPopUp.setAlignment(Pos.CENTER);
        lblGameOver = initTitle(50,"GAME OVER");

        HBox hBox = new HBox();
        hBox.setMinWidth(Cst.screenWidth);
        lblScore = initText(20,"Score:");
        lblScoreValue = initText(20, "0000");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(lblScore);
        hBox.getChildren().add(lblScoreValue);

        btnRetourMenu = initBtn(20,"Retour");

        vBoxGameOverPopUp.getChildren().add(lblGameOver);
        vBoxGameOverPopUp.getChildren().add(hBox);
        vBoxGameOverPopUp.getChildren().add(btnRetourMenu);


    }

    public Label initTitle(int fontSize, String textContent){
        Label t = new Label();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public Label initText(int fontSize, String textContent){
        Label l = new Label(textContent);
        l.setMinWidth(150);
        l.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        return l;
    }


    public Button initBtn(int fontSize, String textContent){
        Button b = new Button(textContent);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        b.getStyleClass().add("btn");
        return b;
    }

    public void setEvents(ControllerInGameMouse controller){
        btnRetourMenu.setOnMouseClicked(controller);
    }

    public void setEvents(ControllerInGameKeyboard controller){
        root.setOnKeyPressed(controller);
        root.setOnKeyReleased(controller);
    }

    public Button getBtnReturnMenu() {
        return btnRetourMenu;
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

    public VBox getvBoxGameOverPopUp() {
        return vBoxGameOverPopUp;
    }
}
