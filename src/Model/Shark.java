package Model;

import Tool.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shark extends FishPNJ {
    public Shark(double x,double y){
        super(200, x, y);
        mainImg.setImage(new Image(Path.skinMainFish+"5.png"));
    }
}
