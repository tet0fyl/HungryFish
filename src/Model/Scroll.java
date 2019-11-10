package Model;


import Model.Fish.Fish;
import Tool.Cst;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Screen;

public class Scroll {

    private Parallax parallax;
    private double sensX,sensY,x,y,speed,subjectX,subjectY;
    private PerspectiveCamera camera;
    private boolean waitTheSubjectXRight = false;
    private boolean waitTheSubjectXLeft = false;
    private boolean waitTheSubjectYUp = false;
    private boolean waitTheSubjectYDown = false;
    private Fish subject;
    private int deZoom=-1000;


    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public static final double maxX = Screen.getPrimary().getBounds().getWidth()*5;
    public static final double maxScrollX = Screen.getPrimary().getBounds().getWidth()*6;
    public static final double maxY = Screen.getPrimary().getBounds().getWidth()*2;

    public Scroll(Parallax parallax, Fish subject, Scene scene){
        this.parallax=parallax;
        speed=subject.getSpeed();
        camera = new PerspectiveCamera();
        scene.setCamera(camera);
        y=maxY/2-Cst.screenHeight/2;
        x=maxX/2-Cst.screenWidth/2;
        this.subject=subject;
        subjectX=subject.getX();
        subjectY=subject.getY();
        camera.setLayoutX(x);
        camera.setLayoutY(y);
        camera.setTranslateZ(deZoom);
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
        parallax.move(x,y);
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
        if (y>(maxY- Cst.screenHeight + deZoom/3)){
            y=maxY - Cst.screenHeight + deZoom/3;
        }
        if(y<0-deZoom/3){
            y=0-deZoom/3;
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

    public void deZoom(){
        camera.setTranslateZ(deZoom--);
    }

    public Parallax getParallax() {
        return parallax;
    }

    public PerspectiveCamera getCamera() {
        return camera;
    }

    public int getDeZoom() {
        return deZoom;
    }
}
