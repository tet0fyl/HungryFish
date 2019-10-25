package Model;

import Tool.Path;

public class BigFish extends FishPNJ {
    public BigFish(){
        size=225;
        speed=3;
        initPnj(Path.skinMainFish+"2",speed,size);
    }
}
