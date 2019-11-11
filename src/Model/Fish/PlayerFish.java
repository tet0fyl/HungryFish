package Model.Fish;

import Model.Scroll;
import Tool.Cst;
import Tool.Path;

public class PlayerFish extends Fish {
    private String status;

    public PlayerFish(){
        super(Path.skinMainFish+"1",15,7);
        x= Scroll.maxX/2;
        y= Scroll.maxY/2;
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

    public String getStatus() {
        return status;
    }
}
