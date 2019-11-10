package Model;

import javafx.scene.Group;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Parallax {
    private ImageView panel1, panel2, panel3, panel4,panelForGround;
    private String url;
    private Group attacheRoot;
    private Group root = new Group();
    private double width,height;
    private String type;

    public static final String menu = "Menu";
    public static final String game = "Game";

    /** MACRO CONTROL */
    private int ratio = 110;
    private float coef1,coef2,coef3,coef4,coefForGround;
    ///////////////////

    public Parallax(String url, double width, double height, String type){
        this.url=url;
        this.type=type;

        panel1 = new ImageView(new Image(url + "parallax01.png"));
        panel2 = new ImageView(new Image(url + "parallax02.png"));
        panel3 = new ImageView(new Image(url + "parallax03.png"));
        panel4 = new ImageView(new Image(url + "parallax04.png"));
        this.width=width;
        this.height=height;

        setRatio(panel4,ratio);
        root.getChildren().add(panel4);
        setRatio(panel3,ratio);
        root.getChildren().add(panel3);
        setRatio(panel2,ratio);
        root.getChildren().add(panel2);
        setRatio(panel1,ratio);
        root.getChildren().add(panel1);


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
             coef1 = 0.1f;
             coef2 = 0.08f;
             coef3 = 0.03f;
             coef4 = 0.02f;
             coefForGround = 0.3f;
            ///////////////////
        }
    }

    public void initForGround(Group root){
        panelForGround = new ImageView(new Image(url + "forGround.png"));
        setRatio(panelForGround,ratio);
        this.attacheRoot=root;
        attacheRoot.getChildren().add(panelForGround);
    }

    public void setRatio(ImageView img, double percent){
        img.setFitWidth(width * percent / 100);
        if(type.equals(game)){
            img.setFitHeight(height);

        }else{
            img.setFitHeight(height * percent / 100);
        }
        img.setX((width - img.getFitWidth())/2);
        img.setY((height - img.getFitHeight())/2);
    }

    public void move(double x, double y){

        if(type.equals(menu)){
            panel1.setX((width - panel1.getFitWidth())/2-(x-width/2)*coef1);
            panel2.setX((width - panel2.getFitWidth())/2-(x-width/2)*coef2);
            panel3.setX((width - panel3.getFitWidth())/2-(x-width/2)*coef3);
            panel4.setX((width - panel4.getFitWidth())/2-(x-width/2)*coef4);
            panel1.setY((height - panel1.getFitHeight())/2-(y-height/2)*coef1);
            panel2.setY((height - panel2.getFitHeight())/2-(y-height/2)*coef2);
            panel3.setY((height - panel3.getFitHeight())/2-(y-height/2)*coef3);
            panel4.setY((height - panel4.getFitHeight())/2-(y-height/2)*coef4);
        }else{
            panel1.setX((Scroll.maxX - panel1.getFitWidth())/2-(x-width/2)*coef1);
            panel2.setX((Scroll.maxX - panel2.getFitWidth())/2-(x-width/2)*coef2);
            panel3.setX((Scroll.maxX - panel3.getFitWidth())/2-(x-width/2)*coef3);
            panel4.setX((Scroll.maxX - panel4.getFitWidth())/2-(x-width/2)*coef4);
            panelForGround.setX((Scroll.maxX - panelForGround.getFitWidth())/2-(x-Scroll.maxScrollX/2)*coefForGround);
            panelForGround.setViewOrder(-10.0);
        }
    }

    public Group getRoot() {
        return root;
    }
}
