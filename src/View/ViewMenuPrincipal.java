package View;

import Controller.ControllerMenuPrincipal;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewMenuPrincipal {

    // TODO Rajouter des variable si besoin //
    private Group root;
    private Text txtTitle;
    private Button btnStart, btnOption, btnExit;


    ViewMenuPrincipal(Group root){
        this.root = root;


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

        root.getChildren().clear();
        root.getChildren().add(txtTitle);
        root.getChildren().add(btnStart);
        root.getChildren().add(btnOption);


        ////////////////////////////////////////////////////////////
    }


    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
    }

    public Text getTxtTitle(){
        return txtTitle ;
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

}
