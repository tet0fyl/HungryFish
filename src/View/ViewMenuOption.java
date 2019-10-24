package View;

import Controller.ControllerMenuOption;
import Model.ModelMenuOption;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuOption {

    private Group root, grpFish;
    private Text txtTitle;
    private Text testText, selectSkin;
    private Button btnReturn, btnValider;
    private ImageView imgBackground;
    private ImageView fish1, fish2, fish3, fish4, fish5;

    ViewMenuOption(Group root){
        this.root = root;

        txtTitle = initText(150,"OPTION");
        txtTitle.setLayoutX(650);
        txtTitle.setLayoutY(220);

        testText = new Text(100,100,"On est dans la vue des options");


        btnValider = new Button("Valider");
        btnValider.getStyleClass().add("btn");
        btnValider.setLayoutX(750);
        btnValider.setLayoutY(800);

        btnReturn = new Button("Retour");
        btnReturn.getStyleClass().add("btn");
        btnReturn.setLayoutX(1000);
        btnReturn.setLayoutY(800);

        initBackground();

        selectSkin = new Text(800, 500, "Select your skin");
        selectSkin.setFont(Font.loadFont(ViewMenuOption.class.getResourceAsStream(Path.fontWavePool), 30));

        fish1 = initFish();
        fish1.setX(0);
        fish1.setY(0);
        fish2 = initFish();
        fish2.setX(150);
        fish2.setY(0);
        fish3 = initFish();
        fish3.setX(300);
        fish3.setY(0);
        fish4 = initFish();
        fish4.setX(450);
        fish4.setY(0);
        fish5 = initFish();
        fish5.setX(600);
        fish5.setY(0);

        grpFish = new Group();
        grpFish.getChildren().add(fish1);
        grpFish.getChildren().add(fish2);
        grpFish.getChildren().add(fish3);
        grpFish.getChildren().add(fish4);
        grpFish.getChildren().add(fish5);
        grpFish.setLayoutX(600);
        grpFish.setLayoutY(500);

        root.getChildren().clear();
        root.getChildren().add(imgBackground);
        root.getChildren().add(txtTitle);
        root.getChildren().add(testText);
        root.getChildren().add(selectSkin);
        root.getChildren().add(btnValider);
        root.getChildren().add(btnReturn);
        root.getChildren().add(grpFish);


    }

    public Text initText(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
        Rectangle2D psb = Screen.getPrimary().getBounds();
        imgBackground.setFitHeight(psb.getHeight());
        imgBackground.setFitWidth(psb.getWidth());
    }

    public ImageView initFish(){
        ImageView fish = new ImageView(Path.firstFish);
        fish.setFitWidth(100);
        fish.setFitHeight(100);
        return fish;
    }

    public void setEvents(ControllerMenuOption model){
        btnReturn.setOnMouseClicked(model);
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

}
