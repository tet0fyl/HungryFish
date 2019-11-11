package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Model.Menu;
import Tool.Cst;
import Tool.Path;
import javafx.geometry.Insets;
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
    private VBox vBoxGameOverPopUp, vBoxContentPopUp;
    private HBox hBox;


    ViewInGame(Group root, Menu model){
        this.root = root;
        this.model = model;

        initvBoxGameOverPopUp();

    }

    public  void clearAndInitRoot(){
        initBackground();
        root.getChildren().clear();
        root.getChildren().add(imgBackground);
    }


    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
    }

    public void initvBoxGameOverPopUp(){
        vBoxGameOverPopUp = new VBox();
        vBoxContentPopUp= new VBox();
        hBox = new HBox();

        vBoxGameOverPopUp.setMinHeight(Cst.screenHeight);
        vBoxGameOverPopUp.setMinWidth(Cst.screenWidth);
        vBoxGameOverPopUp.setAlignment(Pos.CENTER);

        vBoxContentPopUp.setSpacing(50);
        vBoxContentPopUp.setAlignment(Pos.CENTER);
        vBoxContentPopUp.setMinWidth(Cst.screenWidth/2);
        vBoxContentPopUp.getStyleClass().add("popUp");

        lblGameOver = initTitle(100,"GAME OVER");
        VBox.setMargin(lblGameOver,new Insets(100,0,0,0));

        hBox.setAlignment(Pos.CENTER);

        lblScore = initText(25,"Score:");
        lblScoreValue = initText(25, "0000");
        hBox.getChildren().add(lblScore);
        hBox.getChildren().add(lblScoreValue);
        vBoxGameOverPopUp.setAlignment(Pos.CENTER);
        hBox.setMinWidth(Cst.screenWidth/2);


        btnRetourMenu = initBtn(25,"Retour");

        vBoxContentPopUp.getChildren().add(lblGameOver);
        vBoxContentPopUp.getChildren().add(hBox);
        vBoxContentPopUp.getChildren().add(btnRetourMenu);
        vBoxGameOverPopUp.getChildren().add(vBoxContentPopUp);

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

    public ImageView getImgBackground() {
        return imgBackground;
    }

    public VBox getGameOverPopUp() {
        return vBoxGameOverPopUp;
    }

    public HBox gethBox() {
        return hBox;
    }
}
