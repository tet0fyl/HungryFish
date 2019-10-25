package Model;

import Tool.Path;
import javafx.scene.Group;
import javafx.stage.Screen;

import java.util.ArrayList;

public class ModelInGame {
    private PlayerFish player;
    private ArrayList<Fish> listFishPNJ = new ArrayList<Fish>();

    public ModelInGame(){
        player = new PlayerFish(Path.skinMainFish+"1.png",500,Screen.getPrimary().getBounds().getHeight()-200);
    }

    public void generateFish(Group root){
        for (int i = 0; i < 10 ; i++) {
            addFish(root);
        }
    }

    public void addFish(Group root){
        Fish newfish;
        int random = (int)(Math.random()* 20);
        double randomYStart = (Math.random()*Screen.getPrimary().getBounds().getHeight()-200);
        double randomXStart;
        if(random>10){
            randomXStart = Screen.getPrimary().getBounds().getWidth()+100;
        }else{
            randomXStart = -200;
        }
        if(random>18){
            newfish = new Shark(randomXStart,randomYStart);
        }else if (random>15){
            newfish = new BigFish(randomXStart,randomYStart);
        }else if(random>8){
            newfish = new MediumFish(randomXStart,randomYStart);
        }else{
            newfish = new SmallFish(randomXStart,randomYStart);
        }
        listFishPNJ.add(newfish);
        root.getChildren().add(newfish.getMainImg());
    }

    public PlayerFish getPlayer() {
        return player;
    }
}
