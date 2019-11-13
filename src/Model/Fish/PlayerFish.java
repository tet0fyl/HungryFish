package Model.Fish;

import Model.Menu;
import Model.ZoneDeJeu;

public class PlayerFish extends Fish {

    public PlayerFish(String url){
        super(url, Menu.VITESSE_PLAYER_FISH,7);
        x= ZoneDeJeu.maxX/2;
        y= ZoneDeJeu.maxY/2;
        refreshImg(x,y);
    }

    public void move(String direction){
        if(direction.equals(moveRight)) {
            sensX=1;
            x=x+(speed*sensX);
        }
        if(direction.equals(moveLeft)) {
            sensX=-1;
            x=x+(speed*sensX);

        }
        if(direction.equals(moveUp)) {
            y=y+(speed*-1);

        }
        if(direction.equals(moveDown)) {
            y=y+(speed*1);

        }
        colisionBoxX();
        colisionBoxY();
        refreshImg(x,y);
    }

}
