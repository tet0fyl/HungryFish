package Model;

import Tool.Path;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayList;

/**
                                        ! HOW TO USE IT (IN MVC)!
                                        -------------------------
      1. Create an object Bubble in the concerned Model.
      2. Call the model in the proper controller constructor with the method model.bubble.generateBubble(int,Group)
      with the number of bubble to generate and the group who must belong to in parameter.
      3. Call the model in your Controller eventListener with the method model.launchBubble(target x : double,target y : double)
      with the X Y position of target in parameter.
      4. ENJOY !!
                                                        © copyright all right reserved to Theophile&Co.
 */

public class BubblePop {

    private ImageView mainImg;
    private ArrayList<BubblePop> listBubblePop = new ArrayList<BubblePop>();
    private BubblePop bubble;
    private Double mouseMemoryX = null;
    private Double mouseMemoryY = null;
    private double randomDeltaMousePosition;
    private int randomSize;
    private int currentBubbleKey;
    private Timeline timeline;
    private Image frame1, frame2,frame3,frame4,frame5,frame6,frame7;
    private MediaPlayer bubbleSound;

    /** MACRO CONTROL */
    private double deltaMin = 20;
    private double deltaMax = 300;
    private int minSize = 10;
    private int maxSize = 30;
    private double scaleSize = 1.6;
    private double translateY = -45;
    private double rotate = 80;
    ////////////////////

    /**
     *The constructor prepare the images and init The Animation timelime by the method prepareAnimation
     */
    public BubblePop(){
        bubbleSound = new MediaPlayer(new Media(Paths.get(Path.soundBubblePop).toUri().toString()));

        frame1 = new Image(Path.urlBubblePopDirectory + "01" + Path.imgTypePng);
        frame2 = new Image(Path.urlBubblePopDirectory + "02" + Path.imgTypePng);
        frame3 = new Image(Path.urlBubblePopDirectory + "03" + Path.imgTypePng);
        frame4 = new Image(Path.urlBubblePopDirectory + "04" + Path.imgTypePng);
        frame5 = new Image(Path.urlBubblePopDirectory + "05" + Path.imgTypePng);
        frame6 = new Image(Path.urlBubblePopDirectory + "06" + Path.imgTypePng);
        frame7 = new Image(Path.urlBubblePopDirectory + "07" + Path.imgTypePng);

        timeline = new Timeline();

        prepareAnimation();
    }

    /**
     * Describe the animation and init the timeline object, only once in the constructor method
     */
    public void prepareAnimation(){
        randomizeThing();

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

    /**
     * Start the animation of the bubble at the right position. Use in launchBubble methode.
     * @param x the x position of the target where the bubble start
     * @param y the x position of the target where the bubble start
     */
    public void startAnimation(double x, double y){
        timeline.stop();
        mainImg.setY(y);
        mainImg.setX(x);
        timeline.play();
    }

    /**
     * Get the main box image to fix it on the group. Use in the generateBubbleList method
     * @return The main image of the bubble
     */
    public ImageView getMainImg(){
        return mainImg;
    }


    /**
     * Randomize value for more natural comportment of the bubble (size and when there are launch)
     */
    public void randomizeThing(){
        randomDeltaMousePosition = (Math.random()* deltaMax) + deltaMin;
        randomSize = (int) (Math.random()* maxSize) + minSize;
        mainImg = new ImageView();
        mainImg.setFitHeight(randomSize);
        mainImg.setFitWidth(randomSize);
    }

    /**
     * Method to use in the Controller model to generate list of bubble and attache it to a View Group
     * @param nbBubbleToGenerate nombre of bubble to generate
     * @param root  the View Group
     */
    public void generateBubbleList(int nbBubbleToGenerate, Group root){
        for (int i = 0; i < nbBubbleToGenerate ; i++) {
            listBubblePop.add(new BubblePop());
            root.getChildren().add(listBubblePop.get(i).getMainImg());
        }
    }

    /**
     * Method to use in the Controller EventListener to launch bubble in the the right position and right timing  .
     * @param x the x position of the target where the bubble start
     * @param y the x position of the target where the bubble start
     */
    public void launchBubble(double x, double y){
        if(mouseMemoryY == null || x>mouseMemoryX+randomDeltaMousePosition || x<mouseMemoryX-randomDeltaMousePosition || y>mouseMemoryY + randomDeltaMousePosition || y<mouseMemoryY - randomDeltaMousePosition){
            bubble = listBubblePop.get(currentBubbleKey);
            listBubblePop.get(((currentBubbleKey+1)*2)%(listBubblePop.size()-1)).bubbleSound.stop();
            bubble.bubbleSound.play();
            randomizeThing();
            bubble.startAnimation(x,y);
            currentBubbleKey++;
            if(currentBubbleKey >= listBubblePop.size()){
                currentBubbleKey=0;
            }
            mouseMemoryX = x;
            mouseMemoryY = y;
        }
    }
}
