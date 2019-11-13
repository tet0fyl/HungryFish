package Model.Fish;

import Model.Menu;
import Tool.Path;

public class Shark extends FishPNJ {
    public Shark(){
        super(Path.skinMainFish+"5", Menu.VITESSE_SHARK,15);
    }

    @Override
    public void grow(Fish fish) {
        if(Menu.getDifficulte().equals(Menu.FACILE)){
            size=size+fish.getSize()/2.5;
            refreshImg();
        }else if(Menu.getDifficulte().equals(Menu.MOYEN) || Menu.getDifficulte().equals(Menu.IMPOSSIBLE)){
            size=size+fish.getSize()/1.5;
            refreshImg();
        }
    }
}
