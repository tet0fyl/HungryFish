package Model.Fish;

import Model.Scroll;
import javafx.animation.AnimationTimer;

public abstract class FishPNJ extends Fish {
    protected int randomX, randomY, targetDirectionY, targetDirectionX;
    protected int boxX = (int)Scroll.maxX;
    protected int boxY = (int)Scroll.maxY;

    protected AnimationTimer animation;
    protected double a;
    protected double b;


    public FishPNJ(String url, double speed, double size){
        super(url,speed,size);
        startMoving();
    }

    public void startMoving(){
        int random = randomize(20,0);
        double randomYStart = randomize(boxY -300,0);
        double randomXStart;
        if(random>10){
            randomXStart = randomize(boxX+500,boxX+200);
        }else{
            randomXStart = -1*randomize(500,100);
        }
        this.x = randomXStart;
        this.y= randomYStart;
        refreshImg(x,y);
        defineADestination();
        moveToTarget();
    }

    public int randomize(int max,int min){
        return (int) (Math.random()* max) + min;
    }

    public void defineADestination(){
        randomX = randomize(500,300);
        randomY = randomize(200,100);

        if(sensX==1){
            targetDirectionX = boxX + randomX;
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

    @Override
    public void grow(Fish fish) {
        size=size+(fish.getSize()/4);
    }

    public void animationStop(){
        animation.stop();
    }
}
