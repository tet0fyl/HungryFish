package Model;

import Tool.Path;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.stage.Screen;

public class PlayerFish extends Fish {
    protected int exp;
    protected int level;
    protected AnimationTimer eatThread;

    public PlayerFish(){
        size=100;
        speed=15;
        x= Screen.getPrimary().getBounds().getWidth()/2 - size/2;
        y= Screen.getPrimary().getBounds().getHeight() - size;
        init(Path.skinMainFish+"1",x,y,speed,size);
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
