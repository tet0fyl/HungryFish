package Model;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Parallax {
    private ImageView panel1, panel2, panel3, panel4;
    private Group root = new Group();
    private double width,height;
    private String type;

    public static final String menu = "Menu";
    public static final String game = "Game";

    /** MACRO CONTROL */
    private int ratio = 110;
    private float coef1;
    private float coef2;
    private float coef3;
    private float coef4;
    ///////////////////

    public Parallax(String url, double width, double height, String type){

        panel1 = new ImageView(new Image(url + "parallax01.png"));
        panel2 = new ImageView(new Image(url + "parallax02.png"));
        panel3 = new ImageView(new Image(url + "parallax03.png"));
        panel4 = new ImageView(new Image(url + "parallax04.png"));
        this.width=width;
        this.height=height;
        setRatio(panel4,ratio);
        setRatio(panel3,ratio);
        setRatio(panel2,ratio);
        setRatio(panel1,ratio);
        this.type=type;

        if(type.equals(menu)){

            /** MACRO CONTROL MENU*/
            coef1 = 0.065f;
             coef2 = 0.04f;
             coef3 = 0.02f;
             coef4 = 0.01f;
            ///////////////////
        }else {
            /** MACRO CONTROL GAME*/
            ratio = 120;
             coef1 = 0.2f;
             coef2 = 0.08f;
             coef3 = 0.03f;
             coef4 = 0.02f;
            ///////////////////
        }

    }

    public void setRatio(ImageView img, double percent){
        img.setFitWidth(width * percent / 100);
        img.setFitHeight(height * percent / 100);
        img.setX((width - img.getFitWidth())/2);
        img.setY((height - img.getFitHeight())/2);
        root.getChildren().add(img);
    }

    public void move(double x, double y){
        panel1.setX((width - panel1.getFitWidth())/2-(x-width/2)*coef1);

        panel2.setX((width - panel2.getFitWidth())/2-(x-width/2)*coef2);

        panel3.setX((width - panel3.getFitWidth())/2-(x-width/2)*coef3);

        panel4.setX((width - panel4.getFitWidth())/2-(x-width/2)*coef4);

        if(type.equals(menu)){
            panel1.setY((height - panel1.getFitHeight())/2-(y-height/2)*coef1);

            panel2.setY((height - panel2.getFitHeight())/2-(y-height/2)*coef2);

            panel3.setY((height - panel3.getFitHeight())/2-(y-height/2)*coef3);

            panel4.setY((height - panel4.getFitHeight())/2-(y-height/2)*coef4);

        }
    }

    public Group getRoot() {
        return root;
    }
}
