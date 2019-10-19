package View;

import Controller.ControllerInGame;
import Model.InGame;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class ViewInGame {

    private InGame model;
    private Group root;
    private Text testText;

    ViewInGame(InGame model,Group root){
        this.root = root;
        this.model = model;

        testText = new Text(100,100,"On est dans la vue du Jeu");

        root.getChildren().clear();
        root.getChildren().add(testText);

    }


    public void setEvents(ControllerInGame cig){
        //Gestion des events InGame
    }

}
