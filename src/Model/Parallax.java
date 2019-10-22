package Model;

import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;


public class Parallax {
    private ImageView panel1, panel2, panel3, panel4,panel5;
    private Rectangle2D primaryScreenBounds;
    private double screenHeight, screenWidth;
    private Group root = new Group();
    private double relX,relY;
    private int ratio = 110;
    private float coef1 = 0.08f;
    private float coef2 = 0.04f;
    private float coef3 = 0.02f;
    private float coef4 = 0.01f;

    public Parallax(String url){

        primaryScreenBounds = Screen.getPrimary().getBounds();
        screenHeight = primaryScreenBounds.getHeight();
        screenWidth = primaryScreenBounds.getWidth();

        panel1 = new ImageView(new Image(url + "01" + Path.imgTypePng));
        panel2 = new ImageView(new Image(url + "02" + Path.imgTypePng));
        panel3 = new ImageView(new Image(url + "03" + Path.imgTypePng));
        panel4 = new ImageView(new Image(url + "04" + Path.imgTypePng));
        panel5 = new ImageView(new Image(url + "05" + Path.imgTypePng));
        setRatio(panel5,ratio);
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
