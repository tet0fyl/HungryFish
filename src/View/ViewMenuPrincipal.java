package View;

import Controller.ControllerMenuPrincipal;
import Model.ModelMenuPrincipal;
import Tool.Path;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewMenuPrincipal{

    private Group root;
    private ModelMenuPrincipal model;
    private Label txtTitle;
    private Button btnStart, btnOption, btnExit;

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 0, 50, 100));
        vBox.setSpacing(70);

        txtTitle = initText(90, "HUNGRY FISH");
        vBox.getChildren().add(txtTitle);
        vBox.setLayoutX(400);

        btnStart = initBtn(20, "JOUER");
        vBox.getChildren().add(btnStart);

        btnOption = initBtn(20, "OPTION");
        vBox.getChildren().add(btnOption);

        btnExit = initBtn(20, "QUITTER");
        vBox.getChildren().add(btnExit);

        root.getChildren().clear();
        root.getChildren().add(model.parallax.getRoot());
        root.getChildren().add(vBox);


        ////////////////////////////////////////////////////////////
    }

    public Label initText(int fontSize, String textContent){
        Label t = new Label();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public Button initBtn(int fontSize, String textContent){
        Button b = new Button(textContent);
        b.setMinWidth(150);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        b.getStyleClass().add("btn");
        return b;
    }

    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
        btnExit.setOnMouseClicked(mc);
        model.parallax.getRoot().setOnMouseMoved(mc);
        btnStart.setOnMouseMoved(mc);
        btnOption.setOnMouseMoved(mc);
        btnExit.setOnMouseMoved(mc);
        txtTitle.setOnMouseMoved(mc);
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Button getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

}
