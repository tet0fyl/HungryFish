package View;

import Controller.ControllerMenu;
import Model.InGame;
import Model.Menu;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewMenuPrincipal {
    // mettre les variable de classe //
    private Group root;
    private Menu model;
    private InGame mig;
    private ViewInGame ig;
    private Text txtTitle;
    private Button btnStart, btnOption, btnExit;


    ///////////////////////////////

    ViewMenuPrincipal(Menu model, Group root){
        this.root = root;
        this.model = model;


        //Tu géres l'affichage ici //
        //TODO ajouter les boutons restant (btnOption et btnExit) et faire la mise en forme du Menu //

        txtTitle = new Text();
        txtTitle.setText("ExempleDeText");
        txtTitle.setLayoutX(100);
        txtTitle.setLayoutY(100);
        txtTitle.setFont(Font.font(30));

        btnStart = new Button();
        btnStart.setText("JOUER");
        btnStart.setLayoutX(100);
        btnStart.setLayoutY(200);

        root.getChildren().clear();
        root.getChildren().add(txtTitle);
        root.getChildren().add(btnStart);


        ///////////////////////////////
    }


    void setEvents(ControllerMenu mc){
        btnStart.setOnMouseClicked(mc);
    }

    public Text getTxtTitle(){
        return txtTitle ;
    }

    public Button getBtnStart(){return btnStart;}

}
