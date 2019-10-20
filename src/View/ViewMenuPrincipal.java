package View;

import Controller.ControllerMenuPrincipal;
import Model.BubblePop;
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
    private BubblePop bubble;

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        //Tu géres l'affichage ici //
        //TODO ajouter les boutons restant (btnOption et btnExit), des images et faire la mise en forme du Menu ICI //

        txtTitle = new Text();
        txtTitle.setText("ExempleDeText");
        txtTitle.setLayoutX(100);
        txtTitle.setLayoutY(100);
        txtTitle.setFont(Font.font(30));

        btnStart = new Button();
        btnStart.setText("JOUER");
        btnStart.setLayoutX(100);
        btnStart.setLayoutY(200);

        btnOption = new Button();
        btnOption.setText("OPTION");
        btnOption.setLayoutX(100);
        btnOption.setLayoutY(300);

        initBackground();

        root.getChildren().clear();
        root.getChildren().add(imgBg);
        root.getChildren().add(txtTitle);
        root.getChildren().add(btnStart);
        root.getChildren().add(btnOption);

        ////////////////////////////////////////////////////////////
    }

    private void initBackground() {
        imgBg = new ImageView(Path.urlBackgroundImgMenuPrincipal);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }


    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
        imgBg.setOnMouseMoved(mc);
    }

    public Text getTxtTitle(){
        return txtTitle ;
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Group getRoot(){return root;}

}
