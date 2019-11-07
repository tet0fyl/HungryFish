package View;

import Controller.ControllerMenuPrincipal;
import Model.ModelMenuPrincipal;
import Tool.Path;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
    private VBox vBox; // <== On declare la variable privé pour quelle soit accessible en dehors de la classe constructor (pour le setEvents plus bas)

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        //VBox vBox = new VBox();
        vBox = new VBox(); //<== On initialise la vBox
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth()); //<== Je donne une taille Minimun a ma vBox qui est la largueur de l´écran
        vBox.setAlignment(Pos.CENTER); //<== Je dis a met element de se mettre au centre de la vBox
        //vBox.setPadding(new Insets(10, 0, 50, 100));
        vBox.setSpacing(25); //<== J'ai baisser un peu le Padding mais tu peux le monter si tu preferes, y a pas de soucis :)

        txtTitle = initText(100, "HUNGRY FISH");
        vBox.getChildren().add(txtTitle);
        VBox.setMargin(txtTitle,new Insets(100,0,50,0)); // <== Je met une marge Top et Bottom a mon titre pour pas qu'elle depasse l'ecran ou quelle touche un bouton
        //vBox.setLayoutX(400);

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

        for(Node node: vBox.getChildren()){  // <== Je met un evenement sur le mouvement de la souris pour tout les element de la vBox pas perdre le focus du parallax quand je passe dessus
            node.setOnMouseMoved(mc);
        }

        vBox.setOnMouseMoved(mc); //<== Et je noublie pas de mettre un event sur le move de la souris pour la vBox sinon le parallax ne veut pas bouger du tout xD
        root.setOnMouseMoved(mc); // <== Et sur le root aussi sinon quand je passe la souris en bas de l'ecran sa ne bougera pas car la vBox ne prend pas toute la hauteur de l'ecran
        //model.parallax.getRoot().setOnMouseMoved(mc);
        //btnStart.setOnMouseMoved(mc);
        //btnOption.setOnMouseMoved(mc);
        //btnExit.setOnMouseMoved(mc);
        //txtTitle.setOnMouseMoved(mc);
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Button getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

}
