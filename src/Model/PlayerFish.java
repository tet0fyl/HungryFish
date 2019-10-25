package Model;

public class PlayerFish extends Fish {
    protected int exp;
    protected int level;

    public PlayerFish(String url, int size, int x, int y){
        super(url,size,x,y);
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public void grown(){

    }

    public void chekLevel(){

    }

}
