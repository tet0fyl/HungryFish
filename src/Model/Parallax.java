package Model;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

/**
                                        ! HOW TO USE IT (IN MVC)!
                                        -------------------------
                1. Create an object Parallax in the concerned Model. The constructor must contain an url
                pointing on a directory with 4 PNG file (named parallax01, parallax02, parallax03 and parallax04 )
                2. Add the previous created object to the a Group in a View with the method getRoot()
                like root.getChildren().add(model.parallax.getRoot())
                3. Call the method move with the target position X Y in parameter to the Controller View.
                like model.parallax.move(mouseEvent.getScreenX(),mouseEvent.getScreenY());
                4. And That's it !! :)
                                            © copyright all right reserved to Theophile&Co.
 */


public class Parallax {
    private ImageView panel1, panel2, panel3, panel4;
    private Rectangle2D primaryScreenBounds;
    private double screenHeight, screenWidth;
    private Group root = new Group();
    private double relX,relY;

    // MACRO CONTROL //
    private int ratio = 110;
    private float coef1 = 0.065f;
    private float coef2 = 0.04f;
    private float coef3 = 0.02f;
    private float coef4 = 0.01f;
    ///////////////////

    public Parallax(String url){

        primaryScreenBounds = Screen.getPrimary().getBounds();
        screenHeight = primaryScreenBounds.getHeight();
        screenWidth = primaryScreenBounds.getWidth();

        panel1 = new ImageView(new Image(url + "parallax01.png"));
        panel2 = new ImageView(new Image(url + "parallax02.png"));
        panel3 = new ImageView(new Image(url + "parallax03.png"));
        panel4 = new ImageView(new Image(url + "parallax04.png"));
        setRatio(panel4,ratio);
        setRatio(panel3,ratio);
        setRatio(panel2,ratio);
        setRatio(panel1,ratio);
    }

    public void setRatio(ImageView img, double percent){
        img.setFitWidth(screenWidth * percent / 100);
        img.setFitHeight(screenHeight * percent / 100);
        relX = screenWidth/2 - img.getFitWidth()/2;
        relY = screenHeight/2 - img.getFitHeight()/2;
        img.setX(relX);
        img.setY(relY);
        root.getChildren().add(img);
    }

    public void move(double x, double y){
        panel1.setX((relX/2 - x)*coef1);
        panel1.setY((relY/2 - y)*coef1);
        panel2.setX((relX/2 - x)*coef2);
        panel2.setY((relY/2 - y)*coef2);
        panel3.setX((relX/2 - x)*coef3);
        panel3.setY((relY/2 - y)*coef3);
        panel4.setX((relX/2 - x)*coef4);
        panel4.setY((relY/2 - y)*coef4);

    }

    public Group getRoot() {
        return root;
    }
}
