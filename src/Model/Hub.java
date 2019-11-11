package Model;

import Model.Fish.PlayerFish;
import Tool.Cst;
import Tool.Path;
import View.ViewInGame;
import View.ViewMenuPrincipal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Hub {

    private double point;
    private byte status = 0;
    private Scroll camera;
    private ViewInGame viewInGame;
    private PlayerFish player;
    private Label lblPoint, lblPointValue, lblStatus, lblStatusValue;
    private HBox hBox;
    private ArrayList<String> listOfStatus = new ArrayList<String>();

    public Hub(PlayerFish player, Scroll camera, ViewInGame viewInGame){
        this.player=player;
        point = Math.round(player.getSize());
        this.camera=camera;
        this.viewInGame=viewInGame;

        initListOfStatut();
        initHubGUI();
    }

    public  void initHubGUI(){
        hBox = new HBox();
        hBox.setMinWidth(Cst.screenWidth);
        hBox.setAlignment(Pos.CENTER);
        hBox.getStyleClass().add("hub");
        hBox.setLayoutX(camera.getCamera().getLayoutX());
        hBox.setLayoutY(camera.getCamera().getLayoutY());
        hBox.setTranslateZ(camera.getCamera().getTranslateZ());

        lblPoint=initText("Point:");
        lblPointValue=initText(point + " Cm");
        lblStatus=initText("Status:");
        lblStatusValue=initText(listOfStatus.get(status));

        hBox.getChildren().add(lblPoint);
        hBox.getChildren().add(lblPointValue);
        hBox.getChildren().add(lblStatus);
        hBox.getChildren().add(lblStatusValue);

        viewInGame.getRoot().getChildren().add(hBox);
        hBox.setViewOrder(-10.0);
    }

    public void stickAndRefreshHub(){
        hBox.setLayoutX(camera.getCamera().getLayoutX());
        hBox.setLayoutY(camera.getCamera().getLayoutY());
        hBox.setTranslateZ(camera.getCamera().getTranslateZ());
        point = Math.round(player.getSize());
        lblPointValue.setText(point + "cm");
        checkStatus();
    }

    public Label initText(String textContent){
        Label l = new Label(textContent);
        l.setMinWidth(150);
        l.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), 35));
        return l;
    }

    public void initListOfStatut(){
        listOfStatus.add("Proie");
        listOfStatus.add("Ninja");
        listOfStatus.add("Combattant");
        listOfStatus.add("Predateur");
        listOfStatus.add("Monstre Des Mers");
        listOfStatus.add("Creature Legendaire");
    }

    public void checkStatus(){
       if(player.getSize()<Scroll.maxX/50){
           status = 0;
       }else if (player.getSize()<Scroll.maxX/30){
            status = 1;
        }else if (player.getSize()<Scroll.maxX/20){
            status = 2;
        }else if (player.getSize()<Scroll.maxX/15){
            status = 3;
        }else if (player.getSize()<Scroll.maxX/10){
            status = 4;
        }else{
            status = 5;
        }


        lblStatusValue.setText(listOfStatus.get(status));
    }
}
