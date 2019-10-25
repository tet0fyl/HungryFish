package Model;

import javafx.animation.AnimationTimer;
import javafx.stage.Screen;

public abstract class FishPNJ extends Fish {
    protected int expEarn;
    protected int detectionArea;
    protected boolean playerDetected;
    protected int randomX, randomY, targetDirectionY, targetDirectionX;
    protected AnimationTimer animation;
    protected double a;
    protected double b;

    public FishPNJ(int size, double x, double y){
        super(size,x,y);
        defineADestination();
        moveToTarget();
        sensX=1;
        sensY=1;
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
        randomX = (int) (Math.random()* 50) + 200;
        randomY = (int) (Math.random()* 10) + 100;

        if(sensX==1){
            targetDirectionX = (int)Screen.getPrimary().getBounds().getWidth() + randomX;
        }else{
            targetDirectionX = -1*randomX;
        }
        targetDirectionY = (int)y + sensY*randomY;

        a = ((y - targetDirectionY)/(x - targetDirectionX));
        b = ((targetDirectionX*y)-(x*targetDirectionY))/(targetDirectionX-x);

    }

    public void moveToTarget(){
        animation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                    x=x+(speed * sensX);
                    y=a*x+b;

                    colisionBoxY();
                    refreshImg(x,y);

                   if((x >= targetDirectionX && sensX == 1) || (x<= targetDirectionX && sensX == -1)){
                       int random = (int)(Math.random()* 20);
                       if(random > 13){
                           sensX = sensX * -1;

                       }
                       sensY = sensY * -1;

                       defineADestination();
                   }
            }
        };
        animation.start();
    }


}
