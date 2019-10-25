package Model;

import Tool.Path;

public class SmallFish extends FishPNJ {
    public SmallFish(){
        size=75;
        speed=10;
        initPnj(Path.skinMainFish+"4",speed,size);
    }
}
