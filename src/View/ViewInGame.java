package View;

import Controller.ControllerInGame;
import Controller.ControllerMenuOption;
import Model.ModelInGame;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewInGame {

    private Group root;
    private Text testText;
    private Button btnReturn;

    ViewInGame(Group root){
        this.root = root;

        testText = new Text(100,100,"On est dans la vue du Jeu");

        btnReturn = new Button("Retour");
        btnReturn.setLayoutX(200);
        btnReturn.setLayoutY(200);

        root.getChildren().clear();
        root.getChildren().add(testText);
        root.getChildren().add(btnReturn);
    }

    public void setEvents(ControllerInGame model){
        btnReturn.setOnMouseClicked(model);
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

}
