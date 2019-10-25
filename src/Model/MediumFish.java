package Model;

import Tool.Path;

public class MediumFish extends FishPNJ {
    public MediumFish(){
        size=125;
        speed=7;
        initPnj(Path.skinMainFish+"3",speed,size);
    }
}
