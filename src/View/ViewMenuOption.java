package View;

import Controller.ControllerMenu;
import Tool.NodeIniter;
import Tool.Path;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import java.util.ArrayList;

public class ViewMenuOption {

    private Group root;
    private Label txtTitle,txtSelectSkin, txtSelectDifficulty, textHowToPlay;
    private Button btnReturn, btnValider, btnEasy, btnMedium, btnImpossible, btnHowToPlay;
    private ImageView imgBackground, skin1,skin2,skin3,skin4,skin5;
    private ArrayList<ImageView> listSkin = new ArrayList<ImageView>();
    private VBox vBox;
    private HBox hboxDifficulty, hBoxSkin, hboxHowTo, hBoxBtnRetourValider;

    ViewMenuOption(Group root){
        this.root = root;

        listSkin.add(skin1);
        listSkin.add(skin2);
        listSkin.add(skin3);
        listSkin.add(skin4);
        listSkin.add(skin5);

        txtTitle = NodeIniter.initTitle(90, "OPTION");
        txtSelectSkin = NodeIniter.initText(40,"ChoisiTonSkin:");
        txtSelectDifficulty = NodeIniter.initText(40,"Difficulté:");
        btnEasy = NodeIniter.initBtn(20,"Facile","btnOptionPressed");
        btnMedium = NodeIniter.initBtn(20,"Moyen","btn-secondary");
        btnImpossible = NodeIniter.initBtn(20,"Impossible","btn-secondary");
        textHowToPlay = NodeIniter.initText(40,"CommentJouer:");
        btnHowToPlay = NodeIniter.initBtn(20,"?","btn-secondary");
        btnValider = NodeIniter.initBtn(20,"VALIDER","btn-validation");
        btnReturn = NodeIniter.initBtn(20,"RETOUR","btn-secondary");

        initVBoxAndHBox();

    }

    public void clearAndInitRoot(){
        root.getChildren().clear();
        initBackground();
        root.getChildren().add(vBox);
    }

    public void initVBoxAndHBox(){
        vBox = new VBox();
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);

        initHBoxSkin();

        hboxDifficulty = initHBox();
        hboxDifficulty.getChildren().add(btnEasy);
        hboxDifficulty.getChildren().add(btnMedium);
        hboxDifficulty.getChildren().add(btnImpossible);

        hboxHowTo = initHBox();
        hboxHowTo.getChildren().add(textHowToPlay);
        hboxHowTo.getChildren().add(btnHowToPlay);

        hBoxBtnRetourValider = initHBox();
        hBoxBtnRetourValider.getChildren().add(btnReturn);
        hBoxBtnRetourValider.getChildren().add(btnValider);

        vBox.getChildren().add(txtTitle);
        VBox.setMargin(txtTitle, new Insets(30,0,0,0));
        vBox.getChildren().add(txtSelectSkin);
        vBox.getChildren().add(hBoxSkin);
        vBox.getChildren().add(txtSelectDifficulty);
        vBox.getChildren().add(hboxDifficulty);
        vBox.getChildren().add(hboxHowTo);
        vBox.getChildren().add(hBoxBtnRetourValider);

    }

    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
        imgBackground.setFitHeight(Screen.getPrimary().getBounds().getHeight());
        imgBackground.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        root.getChildren().add(imgBackground);
    }

    public void initHBoxSkin(){
        hBoxSkin = initHBox();
        for(int i = 0; i < listSkin.size(); i++) {
            ImageView v = new ImageView(Path.skinMainFish +(i+1)+".png");
            v.setId("skin");
            v.setFitWidth(100);
            v.setPreserveRatio(true);
            v.getStyleClass().add("selectedSkin");
            hBoxSkin.getChildren().add(v);
            listSkin.set(i,v);
        }
    }

    public HBox initHBox(){
        HBox hbox = new HBox();
        hbox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(25);
        return hbox;
    }

    public void setEvents(ControllerMenu controllerMenu){
        btnReturn.setOnMouseClicked(controllerMenu);
        btnValider.setOnMouseClicked(controllerMenu);

        btnEasy.setOnMouseClicked(controllerMenu);
        btnMedium.setOnMouseClicked(controllerMenu);
        btnImpossible.setOnMouseClicked(controllerMenu);

        for(ImageView img : listSkin){
            img.setOnMouseClicked(controllerMenu);
        }
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

    public Button getBtnValider(){return btnValider;}

    public Button getBtnEasy() {
        return btnEasy;
    }

    public Button getBtnMedium() {
        return btnMedium;
    }

    public Button getBtnImpossible() {
        return btnImpossible;
    }
}
