package Model;

import Tool.Path;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class ModelInGame {
    private PlayerFish player;
    private SmallFish smallFish;

    public ModelInGame(){
        player = new PlayerFish(Path.skinMainFish+"1.png", 100, 50, 500);
        smallFish = new SmallFish(Path.skinMainFish +"4.png",50,40,100);
    }

    public ImageView getPlayerImg() {
        return player.getMainImg();
    }

    public PlayerFish getPlayer() {
        return player;
    }

    public SmallFish getSmallFish() {
        return smallFish;
    }

    public ImageView getSmallFishImg() {
        return smallFish.getMainImg();
    }
}
