package Model;


import javafx.scene.image.ImageView;
import javafx.stage.Screen;

import java.util.ArrayList;

public abstract class Fish {
    protected ImageView mainImg;
    protected double x;
    protected double y;
    protected double size;
    protected double speed;
    protected boolean isAlive;
    protected ArrayList spriteImg;
    protected int sensX=0;
    protected int sensY=0;
    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";


    public Fish(int size, double x, double y){
        //this.speed = (float)(1/this.size)*300;
        speed=4;
        mainImg = new ImageView();
        this.size=size;
        this.x=x;
        this.y=y;
        refreshImg(x,y);
    }

    public void refreshImg(double x, double y){
        mainImg.setFitHeight(size);
        mainImg.setFitWidth(size);
        mainImg.setX(x);
        mainImg.setY(y);
    }

    public void eat(Fish fish){

    }

    public void colisionBoxX(){
        if (x>(Screen.getPrimary().getBounds().getWidth()-size)){
            x=Screen.getPrimary().getBounds().getWidth()-size;
        }
        if(x<0){
            x=0;
        }
    }

    public void colisionBoxY(){
        if (y>(Screen.getPrimary().getBounds().getHeight()-size)){
            y=Screen.getPrimary().getBounds().getHeight()-size;
        }
        if(y<0){
            y=0;
        }
    }

    public ImageView getMainImg() {
        return mainImg;
    }
}
