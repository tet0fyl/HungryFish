package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class PlayerFish extends Fish {
    protected int exp;
    protected int level;

    public PlayerFish(String url,double x,double y){
        super(125,x,y);
        mainImg.setImage(new Image(url));
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public void grown(){

    }

    public void chekLevel(){

    }


    public void move(String direction){
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
