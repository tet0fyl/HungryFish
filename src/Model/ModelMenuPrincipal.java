package Model;


import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Group;

import java.util.ArrayList;

public class ModelMenuPrincipal {

    private ArrayList<BubblePop> listBubblePop = new ArrayList<BubblePop>();
    private BubblePop bubble;
    private Double mouseMemoryX = null;
    private Double mouseMemoryY = null;
    private double deltaMin = 20;
    private double deltaMax = 150;
    private double randomDeltaMousePosition;
    private int currentBubbleKey;
    private int nbBubbleLoadBeforeRunning;

    public ModelMenuPrincipal(){
        randomDeltaMousePosition = (Math.random()* deltaMax) + deltaMin;
    }

    public void prepareBubble(int nbBubbleToGenerate, Group root){
        nbBubbleLoadBeforeRunning = nbBubbleToGenerate;
        for (int i = 0; i < nbBubbleToGenerate ; i++) {
            listBubblePop.add(new BubblePop());
            root.getChildren().add(listBubblePop.get(i).getMainImg());
        }
    }

    public void reloadBubble(){
        int i = currentBubbleKey + (nbBubbleLoadBeforeRunning /2);
        for (; i < currentBubbleKey ; i++) {
            listBubblePop.get(i).loadDefautConfig();
        }
    }


    public void launchBubble(double x, double y){
        if(mouseMemoryY == null || x>mouseMemoryX+randomDeltaMousePosition || x<mouseMemoryX-randomDeltaMousePosition || y>mouseMemoryY + randomDeltaMousePosition || y<mouseMemoryY - randomDeltaMousePosition){
            randomDeltaMousePosition = (Math.random()* deltaMax) + deltaMin;
            bubble = listBubblePop.get(currentBubbleKey);
            bubble.startAnimation(x,y);
            currentBubbleKey++;
            System.out.println(currentBubbleKey);
            if(currentBubbleKey == nbBubbleLoadBeforeRunning){
                currentBubbleKey=0;
            }
            if(currentBubbleKey % (nbBubbleLoadBeforeRunning/2) == 0){
                final Service<Void> calculateService = new Service<Void>() {

                    @Override
                    protected Task<Void> createTask() {
                        return new Task<Void>() {

                            @Override
                            protected Void call() throws Exception {
                                reloadBubble();
                                return null;
                            }
                        };
                    }
                };
                calculateService.start();
            }

            mouseMemoryX = x;
            mouseMemoryY = y;
        }
    }
}
