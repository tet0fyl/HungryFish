package Model.Fish;

import Model.Fish.FishPNJ;
import Model.Menu;
import Tool.Path;

public class MediumFish extends FishPNJ {
    public MediumFish(){
        super(Path.skinMainFish+"3", Menu.VITESSE_MEDIUM,9);
    }
}
