package Model;

import Tool.Path;
import javafx.scene.Group;
import javafx.stage.Screen;

import java.util.ArrayList;

public class ModelInGame {
    private PlayerFish player;
    private ArrayList<Fish> listFishPNJ = new ArrayList<Fish>();

    public ModelInGame(){
        player = new PlayerFish();
    }

    public void generateFish(Group root){
        for (int i = 0; i < 10 ; i++) {
            addFish(root);
        }
    }

    public void addFish(Group root){
        Fish newfish;
        int random = (int)(Math.random()* 20);
        if(random>18){
            newfish = new Shark();
        }else if (random>15){
            newfish = new BigFish();
        }else if(random>8){
            newfish = new MediumFish();
        }else{
            newfish = new SmallFish();
        }
        listFishPNJ.add(newfish);
        root.getChildren().add(newfish.getMainImg());
    }

    public PlayerFish getPlayer() {
        return player;
    }
}
