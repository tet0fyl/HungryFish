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

    public FishPNJ(){
    }

    public void initPnj(String url, double speed, double size){
        int random = (int)(Math.random()* 20);
        double randomYStart = (Math.random()*Screen.getPrimary().getBounds().getHeight());
        System.out.println(randomYStart);
        double randomXStart;
        if(random>10){
            randomXStart = Screen.getPrimary().getBounds().getWidth()+(Math.random()*300)-100;
        }else{
            randomXStart = (Math.random()*300)-100;
        }
        init(url,randomXStart,randomYStart,speed,size);
        defineADestination();
        moveToTarget();
        sensX=1;
        sensY=1;
    }

    public void defineADestination(){
        randomX = (int) (Math.random()* 200) + 50;
        randomY = (int) (Math.random()* 100) + 10;

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
                    y=10*Math.cos(a*x+b) + a*x+b;

                    /*if(speed>=20){
                        y=a*x+b + 10*Math.cos(30*x);
                    }else if(speed>=10){
                        y=a*x+b + 10*Math.cos(10*x);
                    }else if (speed>=7){
                        y=a*x+b + 10*Math.cos(5/4*x);
                    }else{
                        y=a*x+b + 10*Math.cos(1/3*x);
                    }*/

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
