package View;

import Controller.ControllerMenuPrincipal;
import Model.ModelMenuPrincipal;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuPrincipal {

    // TODO Rajouter des variable si besoin //
    private Group root;
    private ModelMenuPrincipal model;
    private Text txtTitle;
    private Text btnStart, btnOption, btnExit;
    private ImageView imgBg;

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        //Tu géres l'affichage ici //
        //TODO ajouter les boutons restant (btnExit) et faire la mise en forme du Menu ICI //

        txtTitle = initText(80,"HUNGRY FISH");
        txtTitle.setLayoutX(100);
        txtTitle.setLayoutY(100);

        btnStart = initTextBtn(30,"JOUER");
        btnStart.setLayoutX(100);
        btnStart.setLayoutY(200);

        btnOption = initTextBtn(30,"OPTION");
        btnOption.setLayoutX(100);
        btnOption.setLayoutY(300);

        btnExit = initTextBtn(30,"QUITTER");
        btnExit.setLayoutX(100);
        btnExit.setLayoutY(400);

        root.getChildren().clear();
        root.getChildren().add(model.parallax.getRoot());
        root.getChildren().add(txtTitle);
        root.getChildren().add(btnStart);
        root.getChildren().add(btnOption);
        root.getChildren().add(btnExit);

        ////////////////////////////////////////////////////////////
    }

    public Text initText(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontPoloBubble), fontSize));
        return t;
    }

    public Text initTextBtn(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontUniversal), fontSize));
        t.getStyleClass().add("text-btn");
        return t;
    }

    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
        btnExit.setOnMouseClicked(mc);
        this.root.setOnMouseMoved(mc);

    }

    public Text getTxtTitle(){
        return txtTitle ;
    }

    public Text getBtnStart(){return btnStart;}

    public Text getBtnOption(){return btnOption;}

    public Text getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

}
