package Model;

import javafx.animation.AnimationTimer;
import javafx.stage.Screen;

public abstract class FishPNJ extends Fish {
    protected int expEarn;
    protected int detectionArea;
    protected boolean playerDetected;
    protected double randomX, randomY, targetDirectionY, targetDirectionX;
    protected AnimationTimer animation;
    protected int pente;


    public FishPNJ(){};

    public FishPNJ(String url, int size, int x, int y){
        super(url,size,x,y);
        defineADestination();
        moveToTarget();
    }

    public void setExpEarn(int expEarn) {
        this.expEarn = expEarn;
    }

    public void setDetectionArea(int detectionArea) {
        this.detectionArea = detectionArea;
    }

    public void setPlayerDetected(boolean playerDetected) {
        this.playerDetected = playerDetected;
    }

    public int getExpEarn() {
        return expEarn;
    }

    public int getDetectionArea() {
        return detectionArea;
    }

    public void defineADestination(){
        randomX = (int) (Math.random()* 400) + 200;
        randomY = (int) (Math.random()* 10) + 20;

        targetDirectionX = Screen.getPrimary().getBounds().getWidth() - randomX;
        targetDirectionY = Screen.getPrimary().getBounds().getHeight() - randomY;

        pente = (int)((y - targetDirectionY)/(x - targetDirectionX));
    }

    public void moveToTarget(){
        animation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                   x=(x+speed)*pente;
                   y=(y+speed)*pente;
                   mainImg.setX(x);
                   mainImg.setY(y);
            }
        };
        animation.start();
    }

}
