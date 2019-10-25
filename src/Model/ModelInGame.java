package Model;

import Tool.Path;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class ModelInGame {
    private PlayerFish player;

    public ModelInGame(){
        player = new PlayerFish(Path.skinMainFish+"1.png", 100, 50, 500);
    }

    public ImageView getPlayerImg() {
        return player.getMainImg();
    }

    public PlayerFish getPlayer() {
        return player;
    }
}
