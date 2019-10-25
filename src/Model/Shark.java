package Model;

import Tool.Path;

public class Shark extends FishPNJ {
    public Shark(){
        size=175;
        speed=21;
        initPnj(Path.skinMainFish+"5",speed,size);
    }
}
