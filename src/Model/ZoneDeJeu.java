package Model;


import Model.Fish.Fish;
import Tool.Cst;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class ZoneDeJeu {

    private ImageView imgBg;
    private double sensX,sensY,x,y,speed,subjectX,subjectY;
    private PerspectiveCamera camera;
    private boolean waitTheSubjectXRight = false;
    private boolean waitTheSubjectXLeft = false;
    private boolean waitTheSubjectYUp = false;
    private boolean waitTheSubjectYDown = false;
    private Fish subject;
    private int deZoom=-500;


    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public static final double maxX = Screen.getPrimary().getBounds().getWidth()*10;
    public static final double maxY = Screen.getPrimary().getBounds().getWidth()*6;

    public ZoneDeJeu(ImageView imgBg, Fish subject, Scene scene){
        this.imgBg=imgBg;
        this.imgBg.setFitWidth(maxX);
        this.imgBg.setFitHeight(maxY);
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

    /** METHODE POUR QUE LA CAMERA BOUGE */
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

    /** VERIFIE SI LA CAMERA DOIT BOUGER */
    public void isTheSubjectInTheCenter(){
        if(subject.getX()-x>(Cst.screenWidth-subject.getSize())/2){
            waitTheSubjectXRight = false;
            waitTheSubjectXLeft = true;
        }else{
            waitTheSubjectXRight = true;
            waitTheSubjectXLeft = false;
        }

        if(subject.getY()-y<(Cst.screenHeight-subject.getSize())/2){
            waitTheSubjectYUp = false;
            waitTheSubjectYDown = true;
        }else{
            waitTheSubjectYUp = true;
            waitTheSubjectYDown = false;
        }

    }

    /**GESTION DES COLISION DE LA CAMERA*/
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

    public void deZoom(double deZoomValue){
        deZoom =deZoom-(int)deZoomValue;
        camera.setTranslateZ(deZoom);
    }

    public PerspectiveCamera getCamera() {
        return camera;
    }

}
