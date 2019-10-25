package Model;


import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Fish {
    protected ImageView mainImg;
    protected int x;
    protected int y;
    protected int size;
    protected int speed;
    protected boolean isAlive;
    protected ArrayList spriteImg;
    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";




    public Fish(){

    }

    public Fish(String url, int size, int x, int y){
        mainImg = new ImageView(url);
        this.size = size;
        this.x=x;
        this.y=y;
        refreshImg(x,y);
        speed=20;
        mainImg.setFitHeight(size);
        mainImg.setFitWidth(size);


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
            x=x+speed;
        }
        if(direction.equals(moveLeft)) {
            x=x-speed;
        }
        if(direction.equals(moveUp)) {
            y=y-speed;
        }
        if(direction.equals(moveDown)) {
            y=y+speed;
        }
        refreshImg(x,y);

    }

    public ImageView getMainImg() {
        return mainImg;
    }
}
