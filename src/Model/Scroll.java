package Model;


import Model.Fish.Fish;
import Tool.Cst;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class Scroll {

    private ImageView img;
    private double sensX,sensY,x,y,speed,subjectX,subjectY;
    private PerspectiveCamera camera;
    private boolean waitTheSubjectXRight = false;
    private boolean waitTheSubjectXLeft = false;
    private boolean waitTheSubjectYUp = false;
    private boolean waitTheSubjectYDown = false;
    private Fish subject;


    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public static final double maxX = Screen.getPrimary().getBounds().getWidth()*2;
    public static final double maxY = Screen.getPrimary().getBounds().getWidth()*2;

    public Scroll(ImageView scrollBg, Fish subject, Scene scene){
        img=scrollBg;
        img.setFitHeight(maxY);
        img.setFitWidth(maxX);
        speed=subject.getSpeed();
        camera = new PerspectiveCamera();
        scene.setCamera(camera);
        y=camera.getLayoutY();
        x=camera.getLayoutX();
        this.subject=subject;
        subjectX=subject.getX();
        subjectY=subject.getY();
        img.setX(x);
        img.setY(y);

    }

    public void move(String direction){
        sensX=0;
        sensY=0;

        isTheSubjectInTheCenter();

        if(direction.equals(moveRight) && !waitTheSubjectXRight) {
            sensX=1;
            sensY=0;
        }
        if(direction.equals(moveLeft) && !waitTheSubjectXLeft) {
            sensX=-1;
            sensY=0;
        }
        if(direction.equals(moveUp) && !waitTheSubjectYUp) {
            sensY=-1;
            sensX=0;
        }
        if(direction.equals(moveDown) && !waitTheSubjectYDown) {
            sensY=1;
            sensX=0;
        }

        x=x+(speed*sensX);
        y=y+(speed*sensY);
        colisionBoxX();
        colisionBoxY();
        camera.setLayoutX(x);
        camera.setLayoutY(y);

    }

    public void colisionBoxX(){
        if (x>maxX - Cst.screenWidth){
            x=maxX - Cst.screenWidth;
        }
        if(x<0){
            x=0;
        }
    }

    public void colisionBoxY(){
        if (y>(maxY- Cst.screenHeight)){
            y=maxY - Cst.screenHeight;
        }
        if(y<0){
            y=0;
        }
    }

    public void isTheSubjectInTheCenter(){
        if(subject.getX()-x>Cst.screenWidth/2){
            waitTheSubjectXRight = false;
            waitTheSubjectXLeft = true;
        }else{
            waitTheSubjectXRight = true;
            waitTheSubjectXLeft = false;
        }

        if(subject.getY()-y<Cst.screenHeight/2){
            waitTheSubjectYUp = false;
            waitTheSubjectYDown = true;
        }else{
            waitTheSubjectYUp = true;
            waitTheSubjectYDown = false;
        }

    }

}
