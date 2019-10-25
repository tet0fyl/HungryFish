package View;

import Controller.ControllerInGameKeyboard;
import Controller.ControllerInGameMouse;
import Model.ModelInGame;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ViewInGame {

    private Group root;
    private ModelInGame model;
    private Button btnReturn;
    private ImageView imgBackground;

    ViewInGame(Group root, ModelInGame model){
        this.root = root;
        this.model = model;

        btnReturn = initBtnRightOrLeft(20,"RETOUR","left");
        btnReturn.setLayoutY(25);

        initBackground();

        root.getChildren().clear();
        root.getChildren().add(imgBackground);
        root.getChildren().add(model.getPlayerImg());
        root.getChildren().add(btnReturn);
    }


    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
        Rectangle2D psb = Screen.getPrimary().getBounds();
        imgBackground.setFitHeight(psb.getHeight());
        imgBackground.setFitWidth(psb.getWidth());
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
}
