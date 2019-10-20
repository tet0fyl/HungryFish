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
    private double deltaMousePosition = 80;
    private int currentBubbleKey;
    private int nbDeBubbleEnCacheBeforeRunning = 100;
    private int nbBubbleCacheInRun = 50;
    private Group root;

    public ModelMenuPrincipal(){

    }

    public void prepareBubble(int nbBubbleToGenerate, Group root){
        for (int i = 0; i < nbBubbleToGenerate ; i++) {
            listBubblePop.add(new BubblePop());
            root.getChildren().add(listBubblePop.get(i).getMainImg());
        }
    }

    public void reloadBubble(){
        int i = currentBubbleKey + (nbDeBubbleEnCacheBeforeRunning/2);
        for (; i < currentBubbleKey ; i++) {
            listBubblePop.get(i).loadDefautConfig();
        }
    }


    public void launchBubble(double x, double y){
        if(mouseMemoryY == null || x>mouseMemoryX+deltaMousePosition || x<mouseMemoryX-deltaMousePosition || y>mouseMemoryY + deltaMousePosition || y<mouseMemoryY - deltaMousePosition){
            bubble = listBubblePop.get(currentBubbleKey);
            bubble.startAnimation(x,y);
            currentBubbleKey++;
            System.out.println(currentBubbleKey);
            if(currentBubbleKey == 100){
                currentBubbleKey=0;
            }
            if(currentBubbleKey % nbBubbleCacheInRun == 0){
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
