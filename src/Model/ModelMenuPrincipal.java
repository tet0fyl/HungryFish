package Model;


import Tool.Path;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Group;

import java.util.ArrayList;

public class ModelMenuPrincipal {

    public BubblePop bubbles;
    public Parallax parallax;

    public ModelMenuPrincipal(){
        bubbles = new BubblePop();
        parallax = new Parallax(Path.urlParallaxMenuPrincipalBackgroundImg);
    }


}
