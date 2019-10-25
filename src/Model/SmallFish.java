package Model;

import Tool.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SmallFish extends FishPNJ {
    public SmallFish(double x, double y){
        super(75,x,y);
        mainImg.setImage(new Image(Path.skinMainFish+"4.png"));
    }
}
