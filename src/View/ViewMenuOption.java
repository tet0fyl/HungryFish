package View;

import Controller.ControllerMenuOption;
import Model.ModelMenuOption;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuOption {

    private Group root;
    private Text txtTitle;
    private Text testText;
    private Button btnReturn;
    private ImageView imgBackground;

    ViewMenuOption(Group root){
        this.root = root;

        txtTitle = initText(150,"OPTION");
        txtTitle.setLayoutX(650);
        txtTitle.setLayoutY(220);

        testText = new Text(100,100,"On est dans la vue des options");

        btnReturn = new Button("Retour");
        btnReturn.setLayoutX(200);
        btnReturn.setLayoutY(200);

        initBackground();

        root.getChildren().clear();
        root.getChildren().add(imgBackground);
        root.getChildren().add(testText);
        root.getChildren().add(btnReturn);
    }

    public Text initText(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public void initBackground(){
        imgBackground = new ImageView(Path.urlBackgroundOption);
        Rectangle2D psb = Screen.getPrimary().getBounds();
        imgBackground.setFitHeight(psb.getHeight());
        imgBackground.setFitWidth(psb.getWidth());
    }

    public void setEvents(ControllerMenuOption model){
        btnReturn.setOnMouseClicked(model);
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

}
