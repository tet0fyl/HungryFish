package Model;

import java.util.ArrayList;

public class Fish {
    protected int x;
    protected int y;
    protected int size;
    protected int speed;
    protected boolean isAlive;
    protected ArrayList spriteImg;

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

    public void eat(Fish fish){

    }

    public void move(){

    }

}
