package Model;


import java.util.ArrayList;

public class ModelMenuPrincipal {

    private ArrayList<BubblePop> listBubblePop = new ArrayList<BubblePop>();
    private BubblePop bubble;

    public BubblePop createBubble(double x, double y){
        bubble = new BubblePop(x,y);
        bubble.startAnimation();
        return bubble;
    }
}
