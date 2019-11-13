package Model.Fish;


import Model.Menu;
import Model.Scroll;
import Tool.Cst;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Fish {

    protected ImageView mainImg;
    protected Image forImg,backImg;
    protected double x;
    protected double y;
    protected double size;
    protected double speed;
    protected boolean isAlive,isDying;
    protected int sensX=1;
    protected int sensY=0;
    protected int memorySensX;
    protected Timeline timeline;

    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public Fish(String url, double speed, double size){
        mainImg = new ImageView();
        forImg = new Image(url +".png");
        backImg = new Image(url+"backward.png");
        mainImg.setImage(forImg);
        mainImg.setPreserveRatio(true);
        this.size=(size* Cst.screenWidth/100);
        this.speed=(speed* Cst.screenWidth/100);
        memorySensX = sensX;
        isAlive=true;
        isDying=false;
        dieAnimationprepare();
    }

    public void refreshImg(double x, double y){
        if(sensX == 1){
            mainImg.setImage(forImg);
        }else{
            mainImg.setImage(backImg);
        }
        mainImg.setFitWidth(size);
        mainImg.setX(x);
        mainImg.setY(y);
    }

    public void refreshImg(){
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
        if (y>(Scroll.maxY - mainImg.getBoundsInLocal().getHeight())){
            y=Scroll.maxY - mainImg.getBoundsInLocal().getHeight();
        }
        if(y<0){
            y=0;
        }
    }

    public void eat(Fish fish){
        fish.setDying(true);
        grow(fish);
        fish.getTimeline().play();
    }

    public void dieAnimationprepare(){
        timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(new Duration(500),new KeyValue(mainImg.rotateProperty(), 90), new KeyValue(mainImg.scaleYProperty(), 0),new KeyValue(mainImg.scaleXProperty(),0))
                );
        timeline.setCycleCount(1);
        timeline.setOnFinished((e)->{
            isAlive=false;
        });
    }

    public void grow(Fish fish){
            size=size+fish.getSize()/3.9;
            refreshImg();
        }

    public ImageView getMainImg() {
        return mainImg;
    }

    public boolean getIsAlive(){
        return isAlive;
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

    public Timeline getTimeline() {
        return timeline;
    }

    public void setDying(boolean dying) {
        isDying = dying;
    }

    public boolean getIsDying(){
        return  isDying;
    }

    public double getSize(){
        return size;
    }
}

