package Model;


import javafx.scene.image.ImageView;

public class Scroll {

    private ImageView img;
    private double maxY;
    private double maxX;
    private int sensX,sensY,x,y,speed;


    public static final String moveRight = "droite";
    public static final String moveLeft = "gauche";
    public static final String moveUp = "haut";
    public static final String moveDown = "bas";

    public Scroll(ImageView scrollBg, int subjectSpeed){
        img=scrollBg;
        speed=subjectSpeed;
        maxX = scrollBg.getFitWidth();
        maxY = scrollBg.getFitHeight();
        y=0;
        x=0;
        img.setX(x);
        img.setY(y);

    }

    public void move(String direction){
        if(direction.equals(moveRight)) {
            sensX=1;
            sensY=0;
        }
        if(direction.equals(moveLeft)) {
            sensX=-1;
            sensY=0;
        }
        if(direction.equals(moveUp)) {
            sensY=-1;
            sensX=0;
        }
        if(direction.equals(moveDown)) {
            sensY=1;
            sensX=0;
        }
        x=x+(speed*sensX);
        y=y+(speed*sensY);
        //colisionBoxX();
        //colisionBoxY();
        img.setX(x);
        img.setY(y);

    }
}
