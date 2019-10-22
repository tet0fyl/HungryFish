package View;

import Controller.ControllerMenuOption;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class ViewMenuOption {

    private Group root;
    private Text testText;

    ViewMenuOption(Group root){
        this.root = root;

        testText = new Text(100,100,"On est dans la vue des options");

        root.getChildren().clear();
        root.getChildren().add(testText);
    }

    public void setEvents(ControllerMenuOption model){

    }

}
