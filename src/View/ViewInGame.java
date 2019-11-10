package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Model.Menu;
import Model.Scroll;
import Tool.Cst;
import Tool.Path;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ViewInGame {

    private Group root;
    private Menu model;
    private ImageView imgBackground;
    private Label lblGameOver,lblScore,lblScoreValue;
    private Button btnRetourMenu;
    private Group grpPanePopUp;
    private HBox vBoxGameOverPopUp;
    private HBox hBox;


    ViewInGame(Group root, Menu model){
        this.root = root;
        this.model = model;
        this.root.minWidth(Scroll.maxX);
        this.root.minHeight(Scroll.maxY);

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
        grpPanePopUp = new Group();
        vBoxGameOverPopUp = new HBox();
        lblGameOver = initTitle(100,"GAME OVER");

        hBox = new HBox();
        lblScore = initText(20,"Score:");
        lblScoreValue = initText(20, "0000");
        hBox.getChildren().add(lblScore);
        hBox.getChildren().add(lblScoreValue);

        btnRetourMenu = initBtn(20,"Retour");

        vBoxGameOverPopUp.getChildren().add(lblGameOver);
        vBoxGameOverPopUp.getChildren().add(hBox);
        vBoxGameOverPopUp.getChildren().add(btnRetourMenu);
        grpPanePopUp.getChildren().add(vBoxGameOverPopUp);

    }

    public void stick(){
        vBoxGameOverPopUp.setAlignment(Pos.CENTER);
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

    public Group getGameOverPopUp() {
        return grpPanePopUp;
    }

    public HBox gethBox() {
        return hBox;
    }
}
