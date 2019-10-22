package View;

import Controller.ControllerInGame;
import Model.ModelInGame;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class ViewInGame {

    private Group root;
    private Text testText;

    ViewInGame(Group root){
        this.root = root;

        testText = new Text(100,100,"On est dans la vue du Jeu");

        root.getChildren().clear();
        root.getChildren().add(testText);

    }


    public void setEvents(ControllerInGame cig){
        //Gestion des events InGame
    }

}
