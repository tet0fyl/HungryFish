package Model;

public class FishPNJ extends Fish {
    protected int expEarn;
    protected int detectionArea;
    protected boolean playerDetected;

    public FishPNJ(){
        super();
    }

    public void setExpEarn(int expEarn) {
        this.expEarn = expEarn;
    }

    public void setDetectionArea(int detectionArea) {
        this.detectionArea = detectionArea;
    }

    public void setPlayerDetected(boolean playerDetected) {
        this.playerDetected = playerDetected;
    }

    public int getExpEarn() {
        return expEarn;
    }

    public int getDetectionArea() {
        return detectionArea;
    }

}
