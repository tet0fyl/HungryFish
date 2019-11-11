package Model;

import Model.Fish.PlayerFish;
import Tool.Cst;
import Tool.Path;
import View.ViewInGame;
import View.ViewMenuPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Hud {

    private double taille;
    private byte status = 0;
    private Scroll camera;
    private ViewInGame viewInGame;
    private PlayerFish player;
    private Label lblPoint, lblPointValue, lblStatus, lblStatusValue;
    private HBox hBox;
    private ArrayList<String> listOfStatus = new ArrayList<String>();

    public Hud(PlayerFish player, Scroll camera, ViewInGame viewInGame){
        this.player=player;
        taille = Math.round(player.getSize());
        this.camera=camera;
        this.viewInGame=viewInGame;

        initListOfStatut();
        initHubGUI();
    }

    public  void initHubGUI(){
        hBox = new HBox();
        hBox.setMinWidth(Cst.screenWidth);
        hBox.setAlignment(Pos.CENTER);
        hBox.getStyleClass().add("hud");
        hBox.setLayoutX(camera.getCamera().getLayoutX());
        hBox.setLayoutY(camera.getCamera().getLayoutY());
        hBox.setTranslateZ(camera.getCamera().getTranslateZ());

        lblPoint=initText("Taille:");
        lblPoint.setTextFill(Color.WHITE);
        lblPointValue=initText(taille + " Cm");
        lblStatus=initText("Status:");
        lblStatus.setTextFill(Color.WHITE);
        lblStatusValue=initText(listOfStatus.get(status));

        hBox.getChildren().add(lblPoint);
        hBox.getChildren().add(lblPointValue);
        hBox.getChildren().add(lblStatus);
        hBox.getChildren().add(lblStatusValue);

        viewInGame.getRoot().getChildren().add(hBox);
        hBox.setViewOrder(-10.0);
    }

    public void stickAndRefreshHud(){
        hBox.setLayoutX(camera.getCamera().getLayoutX());
        hBox.setLayoutY(camera.getCamera().getLayoutY());
        hBox.setTranslateZ(camera.getCamera().getTranslateZ());
        taille = Math.round(player.getSize());
        lblPointValue.setText(taille + "cm");
        checkStatus();
    }

    public Label initText(String textContent){
        Label l = new Label(textContent);
        l.setMinWidth(150);
        l.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), 20));
        return l;
    }

    public void initListOfStatut(){
        listOfStatus.add("Proie");
        listOfStatus.add("Ninja");
        listOfStatus.add("Combattant");
        listOfStatus.add("Predateur");
        listOfStatus.add("MonstreDesMers");
        listOfStatus.add("CreatureLegendaire");
    }

    public void checkStatus(){
       if(player.getSize()<Scroll.maxX/50){
           status = 0;
       }else if (player.getSize()<Scroll.maxX/30){
            status = 1;
        }else if (player.getSize()<Scroll.maxX/20){
            status = 2;
        }else if (player.getSize()<Scroll.maxX/10){
            status = 3;
        }else if (player.getSize()<Scroll.maxX/5){
            status = 4;
        }else{
            status = 5;
        }


        lblStatusValue.setText(listOfStatus.get(status));
    }
}
