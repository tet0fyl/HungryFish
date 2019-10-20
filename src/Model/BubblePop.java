package Model;

import Tool.Path;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;
import javafx.util.Duration;


public class BubblePop {

    private ImageView mainImg;
    private int minSize;
    private double scaleSize,translateY;
    private Timeline timeline;
    private Scale scale;
    private Image frame1;
    private Image frame2;
    private Image frame3;
    private Image frame4;
    private Image frame5;
    private Image frame6;
    private Image frame7;

    BubblePop(double x, double y){

        frame1 = new Image(Path.urlBubblePopDirectory + "01" + Path.imgTypePng);
        frame2 = new Image(Path.urlBubblePopDirectory + "02" + Path.imgTypePng);
        frame3 = new Image(Path.urlBubblePopDirectory + "03" + Path.imgTypePng);
        frame4 = new Image(Path.urlBubblePopDirectory + "04" + Path.imgTypePng);
        frame5 = new Image(Path.urlBubblePopDirectory + "05" + Path.imgTypePng);
        frame6 = new Image(Path.urlBubblePopDirectory + "06" + Path.imgTypePng);
        frame7 = new Image(Path.urlBubblePopDirectory + "07" + Path.imgTypePng);

        minSize = 30;
        scaleSize = 1.6;
        translateY = -30;

        timeline = new Timeline();
        mainImg = new ImageView(frame1);
        mainImg.setX(x);
        mainImg.setY(y);
        mainImg.setFitHeight(minSize);
        mainImg.setFitWidth(minSize);
        /*scale = new Scale();
        scale.setX(maxSize);
        scale.setY(maxSize);
        mainImg.getTransforms().add(scale);*/
    }

    public void startAnimation(){
        timeline.getKeyFrames().addAll(
                new KeyFrame(new Duration(500),new KeyValue(mainImg.scaleXProperty(), scaleSize), new KeyValue(mainImg.scaleYProperty(), scaleSize),new KeyValue(mainImg.translateYProperty(),translateY)),
                new KeyFrame(new Duration(500),new KeyValue(mainImg.imageProperty(),frame2)),
                new KeyFrame(new Duration(600),new KeyValue(mainImg.imageProperty(),frame3)),
                new KeyFrame(new Duration(700),new KeyValue(mainImg.imageProperty(),frame4)),
                new KeyFrame(new Duration(800),new KeyValue(mainImg.imageProperty(),frame5)),
                new KeyFrame(new Duration(900),new KeyValue(mainImg.imageProperty(),frame6)),
                new KeyFrame(new Duration(1000),new KeyValue(mainImg.imageProperty(),frame7)),
                new KeyFrame(new Duration(1100),new KeyValue(mainImg.imageProperty(),null))
                );
                timeline.setCycleCount(1);
                timeline.play();
    }

    public ImageView getMainImg(){
        return mainImg;
    }

}
