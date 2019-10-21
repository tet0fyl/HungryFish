package Model;

import Tool.Path;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class BubblePop {

    private ImageView mainImg;
    private int minSize = 10;
    private int maxSize = 30;
    private double scaleSize = 1.6;
    private double translateY = -45;
    private int size;
    private double rotate = 80;
    private Timeline timeline;
    private Image frame1, frame2,frame3,frame4,frame5,frame6,frame7;

    BubblePop(){

        frame1 = new Image(Path.urlBubblePopDirectory + "01" + Path.imgTypePng);
        frame2 = new Image(Path.urlBubblePopDirectory + "02" + Path.imgTypePng);
        frame3 = new Image(Path.urlBubblePopDirectory + "03" + Path.imgTypePng);
        frame4 = new Image(Path.urlBubblePopDirectory + "04" + Path.imgTypePng);
        frame5 = new Image(Path.urlBubblePopDirectory + "05" + Path.imgTypePng);
        frame6 = new Image(Path.urlBubblePopDirectory + "06" + Path.imgTypePng);
        frame7 = new Image(Path.urlBubblePopDirectory + "07" + Path.imgTypePng);

        loadDefautConfig();

        timeline = new Timeline();

        prepareAnimation();
    }

    public void prepareAnimation(){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(mainImg.imageProperty(),frame1), new KeyValue(mainImg.scaleYProperty(),0),new KeyValue(mainImg.scaleXProperty(),0),new KeyValue(mainImg.translateYProperty(), 0),new KeyValue(mainImg.rotateProperty(), 0)),
                new KeyFrame(new Duration(500),new KeyValue(mainImg.scaleXProperty(), scaleSize), new KeyValue(mainImg.scaleYProperty(), scaleSize),new KeyValue(mainImg.translateYProperty(),translateY)),
                new KeyFrame(new Duration(500),new KeyValue(mainImg.imageProperty(),frame2)),
                new KeyFrame(new Duration(600),new KeyValue(mainImg.imageProperty(),frame3)),
                new KeyFrame(new Duration(700),new KeyValue(mainImg.imageProperty(),frame4)),
                new KeyFrame(new Duration(800),new KeyValue(mainImg.imageProperty(),frame5)),
                new KeyFrame(new Duration(900),new KeyValue(mainImg.imageProperty(),frame6)),
                new KeyFrame(new Duration(1000),new KeyValue(mainImg.imageProperty(),frame7),new KeyValue(mainImg.rotateProperty(),rotate)),
                new KeyFrame(new Duration(1100),new KeyValue(mainImg.imageProperty(),null)
                ));
                timeline.setCycleCount(1);
    }

    public void startAnimation(double x, double y){
        timeline.stop();
        mainImg.setY(y);
        mainImg.setX(x);
        timeline.play();
    }

    public ImageView getMainImg(){
        return mainImg;
    }

    public void loadDefautConfig(){
        int rand = (int) (Math.random()* maxSize) + minSize;
        size = rand;
        mainImg = new ImageView();
        mainImg.setFitHeight(size);
        mainImg.setFitWidth(size);
    }

}
