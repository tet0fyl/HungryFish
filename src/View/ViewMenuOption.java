package View;

import Controller.ControllerMenuOption;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;

public class ViewMenuOption {

    private Group root;
    private Group grpFish = new Group();
    private Text txtTitle;
    private Text txtSelectSkin, txtSelectDifficulty, textHowToPlay;
    private Button btnReturn, btnValider, btnEasy, btnMedium, btnImpossible, btnHowToPlay;
    private ImageView imgBackground, skin1,skin2,skin3,skin4,skin5;
    private ArrayList<ImageView> listSkin = new ArrayList<ImageView>();

    ViewMenuOption(Group root){
        this.root = root;

        listSkin.add(skin1);
        listSkin.add(skin2);
        listSkin.add(skin3);
        listSkin.add(skin4);
        listSkin.add(skin5);


        txtTitle = initTitleCenter(150,"OPTION");
        txtTitle.setLayoutY(150);

        txtSelectSkin = initTxtRightOrLeft(40,"ChoisiTonSkin:","left");
        txtSelectSkin.setLayoutY(200);

        initGrpOfFishAndCenterIt();
        grpFish.setLayoutY(225);

        txtSelectDifficulty = initTxtRightOrLeft(40,"Difficulté:","left");
        txtSelectDifficulty.setLayoutY(375);

        btnEasy = initBtnRightOrLeft(20,"Facile","left");
        btnEasy.setLayoutY(400);

        btnMedium = initBtnRightOrLeft(20,"Moyen","middle");
        btnMedium.setLayoutY(400);

        btnImpossible = initBtnRightOrLeft(20,"Impossible","right");
        btnImpossible.setLayoutY(400);

        textHowToPlay = initTxtRightOrLeft(40,"CommentJouer:","left");
        textHowToPlay.setLayoutY(575);

        btnHowToPlay = initBtnRightOrLeft(20,"?","middle");
        btnHowToPlay.setLayoutY(525);

        btnValider = initBtnRightOrLeft(20,"VALIDER","right");
        btnValider.setLayoutY(700);

        btnReturn = initBtnRightOrLeft(20,"RETOUR","left");
        btnReturn.setLayoutY(700);

        initBackground();

        root.getChildren().clear();
        root.getChildren().add(imgBackground);
        root.getChildren().add(txtTitle);
        root.getChildren().add(txtSelectSkin);
        root.getChildren().add(grpFish);
        root.getChildren().add(txtSelectDifficulty);
        root.getChildren().add(btnEasy);
        root.getChildren().add(btnMedium);
        root.getChildren().add(btnImpossible);
        root.getChildren().add(textHowToPlay);
        root.getChildren().add(btnHowToPlay);
        root.getChildren().add(btnValider);
        root.getChildren().add(btnReturn);


    }

    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
        Rectangle2D psb = Screen.getPrimary().getBounds();
        imgBackground.setFitHeight(psb.getHeight());
        imgBackground.setFitWidth(psb.getWidth());
    }

    public ImageView initFish(int size,int numSkin){
        ImageView fish = new ImageView(Path.skinMainFish +(numSkin)+".png");
        fish.setFitWidth(size);
        fish.setFitHeight(size);
        fish.getStyleClass().add("selectedSkin");
        return fish;
    }

    public void initGrpOfFishAndCenterIt(){
        int marginBetweenFish = 20;
        int sizeOfFish = 100;
        int widthOfTheGrp = 0;
        for(int i = 0; i < listSkin.size(); i++) {
            ImageView fish = initFish(sizeOfFish,(i+1));
            fish.setX(i*(marginBetweenFish+sizeOfFish));
            fish.setY(0);
            grpFish.getChildren().add(fish);
        }
        widthOfTheGrp = widthOfTheGrp + listSkin.size() *(sizeOfFish + marginBetweenFish);
        double middle = (Screen.getPrimary().getBounds().getWidth()/2) - (widthOfTheGrp/2);
        grpFish.setLayoutX(middle);
    }

    public Text initTitleCenter(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        double width = 450;
        t.setWrappingWidth(width);
        double middle = (Screen.getPrimary().getBounds().getWidth()/2) - (width/2);
        t.setLayoutX(middle);
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
            middle = (Screen.getPrimary().getBounds().getWidth()/3)*2 - (width/2);
        }
        else if (position.equals("left")){
            middle = (Screen.getPrimary().getBounds().getWidth()/3) - (width/2);
        }else{
            middle = (Screen.getPrimary().getBounds().getWidth()/2) - (width/2);
        }
        b.setLayoutX(middle);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        if(textContent.equals("VALIDER")){
            b.getStyleClass().add("btn");
        }else{
            b.getStyleClass().add("btn-secondary");
        }
        return b;
    }

    public Text initTxtRightOrLeft(int fontSize, String textContent,String position){
        Text t = new Text(textContent);
        double width = 300;
        double middle;
        t.setWrappingWidth(width);
        if(position.equals("right")){
            middle = (Screen.getPrimary().getBounds().getWidth()/4)*3 - (width/2);
        }
        else{
            middle = (Screen.getPrimary().getBounds().getWidth()/4) - (width/2);
        }
        t.setLayoutX(middle);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        t.getStyleClass().add("btn");
        return t;
    }



    public void setEvents(ControllerMenuOption model){
        btnReturn.setOnMouseClicked(model);
    }

    public Button getBtnReturn() {
        return btnReturn;
    }
}
