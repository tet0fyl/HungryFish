package Model.Fish;


import Model.Scroll;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Fish {

    protected ImageView mainImg;
    protected Image forImg,backImg;
    protected double x;
    protected double y;
    protected double size;
    protected double speed;
    protected boolean isAlive;
    protected int sensX=1;
    protected int sensY=0;
    protected int memorySensX;

    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public Fish(String url, double speed, double size){
        mainImg = new ImageView();
        forImg = new Image(url +".png");
        backImg = new Image(url+"backward.png");
        mainImg.setImage(forImg);
        this.size = size;
        this.speed=speed;
        memorySensX = sensX;
        isAlive=true;
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

    public void refreshImg(){
        mainImg.setFitHeight(size);
        mainImg.setFitWidth(size);
    }

    public void colisionBoxX(){
        if (x>(Scroll.maxX-size)){
            x=Scroll.maxX-size;
        }
        if(x<0){
            x=0;
        }
    }

    public void colisionBoxY(){
        if (y>(Scroll.maxY -size)){
            y=Scroll.maxY-size;
        }
        if(y<0){
            y=0;
        }
    }

    public void eat(Fish fish){
        fish.setIsAlive(false);
        grow();

    }

    public void grow(){
        size++;
        refreshImg();
    }

    public ImageView getMainImg() {
        return mainImg;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public double getSpeed() {
        return speed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

