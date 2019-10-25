package Model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

import java.util.ArrayList;

public abstract class Fish {
    protected ImageView mainImg;
    protected Image forImg,backImg;
    protected double x;
    protected double y;
    protected double size;
    protected double speed;
    protected boolean isAlive;
    protected ArrayList spriteImg;
    protected int sensX=1;
    protected int memorySensX;
    protected int sensY=0;
    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";


    public Fish(){
        //this.speed = (float)(1/this.size)*300;
    }

    public void init(String url, double x, double y, double speed, double size){
        mainImg = new ImageView();
        forImg = new Image(url +".png");
        backImg = new Image(url+"backward.png");
        mainImg.setImage(forImg);
        this.size = size;
        this.speed=speed;
        refreshImg(x,y);
        memorySensX = sensX;
    }

    public void refreshImg(double x, double y){
        if(sensX == 1){
            mainImg.setImage(forImg);
        }else{
            mainImg.setImage(backImg);
        }
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
