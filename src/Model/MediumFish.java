package Model;

import Tool.Path;
import javafx.scene.image.Image;

public class MediumFish extends FishPNJ {
    public MediumFish(double x, double y){
        super(150,x,y);
        mainImg.setImage(new Image(Path.skinMainFish+"3.png"));
    }
}
