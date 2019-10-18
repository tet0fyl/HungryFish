package View;

import Controller.ControllerMenu;
import Model.Menu;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewMenuPrincipal {
    // mettre les variable de classe //
    private Group root;
    private Menu model;
    private Text txtTitle;


    ///////////////////////////////

    ViewMenuPrincipal(Menu model, Group root){
        this.root = root;
        this.model = model;


        //Tu géres l'affichage ici //

        txtTitle = new Text(100,100,"Exemple de Titre");
        txtTitle.setFont(Font.font (40));


        root.getChildren().clear();
        root.getChildren().add(txtTitle);


        ///////////////////////////////
    }


    void setEvents(ControllerMenu mc){

    }

    public Text getTxtTitle(){
        return txtTitle ;
    }
}
