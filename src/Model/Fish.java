package Model;


import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Fish {
    protected ImageView mainImg;
    protected Image forImg, backImg;
    protected int x;
    protected int y;
    protected int size;
    protected int speed;
    protected boolean isAlive;
    protected ArrayList spriteImg;
    protected double inclinaison;
    protected int vitesseInclinaison;
    private int sens;
    private String state;
    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";




    public Fish(){

    }

    public Fish(String url, int size, int x, int y){
        forImg = new Image(url);
        backImg = new Image("Asset/img/skin/skinRiverse1.png");
        mainImg = new ImageView(forImg);
        this.size = size;
        this.x=x;
        this.y=y;
        sens=1;
        refreshImg(x,y);
        speed=20;
        mainImg.setFitHeight(size);
        mainImg.setFitWidth(size);
        inclinaison = 0;
        vitesseInclinaison = 5;
        state = "droite";

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setSpriteImg(ArrayList spriteImg) {
        this.spriteImg = spriteImg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public ArrayList getSpriteImg() {
        return spriteImg;
    }

    public void refreshImg(int x, int y){
        mainImg.setX(x);
        mainImg.setY(y);
    }

    public void eat(Fish fish){

    }

    public void move(String direction){
        if(direction.equals(moveRight)) {
            state="droite";
            x=x+speed;
            if(inclinaison >= 0){
                inclinaison=inclinaison-vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }else if(inclinaison <= 0){
                inclinaison=inclinaison+vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }
        }
        if(direction.equals(moveLeft)) {
            state="gauche";
            x=x-speed;
            mainImg.setImage(backImg);
            if(inclinaison >= 0){
                inclinaison=inclinaison-vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }else if(inclinaison <= 0){
                inclinaison=inclinaison+vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }
        }
        if(direction.equals(moveUp)) {
            y=y-speed;
            if(inclinaison >= -90 && state == "droite"){
            inclinaison=inclinaison-vitesseInclinaison;
            mainImg.setRotate(inclinaison);
            }else if(inclinaison <= -90 && state == "gauche"){
                inclinaison=inclinaison+vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }
        }
        if(direction.equals(moveDown)) {
            y=y+speed;
            if(inclinaison <= 90 && state == "droite"){
                inclinaison=inclinaison+vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }else if(inclinaison <= 90 && state == "gauche"){
                inclinaison=inclinaison-vitesseInclinaison;
                mainImg.setRotate(inclinaison);
            }

        }
        x=x+speed;
        y=y+speed;
        refreshImg(x,y);
        System.out.println("Je regarde vers le " + state);
    }

    public ImageView getMainImg() {
        return mainImg;
    }
}
