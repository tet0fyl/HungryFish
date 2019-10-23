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
    private Button btnStart, btnOption, btnExit;
    private ImageView imgBg;

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        //Tu géres l'affichage ici //
        //TODO ajouter les boutons restant (btnExit) et faire la mise en forme du Menu ICI //

        txtTitle = initText(50,"HUNGRY FISH");
        txtTitle.setLayoutX(100);
        txtTitle.setLayoutY(100);

        btnStart = initButton("JOUER");
        btnStart.setLayoutX(100);
        btnStart.setLayoutY(200);

        btnOption = initButton("OPTION");
        btnOption.setLayoutX(100);
        btnOption.setLayoutY(300);

        btnExit = initButton("QUITTER");
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

    private void initBackground() {
        imgBg = new ImageView(Path.urlBackgroundImgMenuPrincipal);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    public static Button initButton( String texteDuBouton) {
        Button b = new Button();
        b.setText(texteDuBouton);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.marioFont),25));
        b.getStyleClass().add("btn");
        return b;

    }

    public Text initText(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.marioFont), fontSize));
        return t;
    }

    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
        model.parallax.getRoot().setOnMouseMoved(mc);
        btnExit.setOnMouseClicked(mc);
    }

    public Text getTxtTitle(){
        return txtTitle ;
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Button getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

}
