package Model;

import Tool.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BigFish extends FishPNJ {
    public BigFish(double x, double y){
        super(250, x, y);
        mainImg.setImage(new Image(Path.skinMainFish+"2.png"));
    }
}
