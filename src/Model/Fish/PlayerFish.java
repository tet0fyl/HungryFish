package Model.Fish;

import Tool.Cst;
import Tool.Path;

public class PlayerFish extends Fish {

    public PlayerFish(){
        super(Path.skinMainFish+"4",15,100);
        x= Cst.screenWidth/2 - size/2;
        y= Cst.screenHeight - size;
        refreshImg(x,y);
    }

    public void move(String direction){
        if(sensX != memorySensX){
            memorySensX=sensX;
        }
        if(direction.equals(moveRight)) {
            sensX=1;
            sensY=0;
        }
        if(direction.equals(moveLeft)) {
            sensX=-1;
            sensY=0;
        }
        if(direction.equals(moveUp)) {
            sensY=-1;
            sensX=0;
        }
        if(direction.equals(moveDown)) {
            sensY=1;
            sensX=0;
        }
        x=x+(speed*sensX);
        y=y+(speed*sensY);
        colisionBoxX();
        colisionBoxY();
        refreshImg(x,y);
    }
}
