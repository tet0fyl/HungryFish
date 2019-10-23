package Model;


import Tool.Path;

public class ModelMenuPrincipal {

    public BubblePop bubbles;
    public Parallax parallax;

    public ModelMenuPrincipal(){
        bubbles = new BubblePop();
        parallax = new Parallax(Path.urlParallaxMenuPrincipalBackgroundImg);
    }


}
