package Model;

import Tool.Path;

public class Menu {

    public static final String FACILE = "facile";
    public static final String MOYEN = "medium";
    public static final String IMPOSSIBLE = "impossible";

    public static double VITESSE_PLAYER_FISH;
    public static double VITESSE_SMALL;
    public static double VITESSE_MEDIUM;
    public static double VITESSE_BIG;
    public static double VITESSE_SHARK;


    private String skin = Path.skinMainFish + 1 ;
    private static String difficulte = FACILE;

    public Menu(){
        updateDifficulte(difficulte);
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }

    public static String getDifficulte() {
        return difficulte;
    }

    public void updateDifficulte(String difficulte) {
        this.difficulte=difficulte;
        switch (difficulte){
            case FACILE:
                VITESSE_PLAYER_FISH=1.55;
                VITESSE_BIG=0.5;
                VITESSE_MEDIUM=0.9;
                VITESSE_SMALL=1.35;
                VITESSE_SHARK=1.5;
                break;
            case MOYEN:
                VITESSE_PLAYER_FISH=1.40;
                VITESSE_BIG=0.5;
                VITESSE_MEDIUM=0.9;
                VITESSE_SMALL=1.30;
                VITESSE_SHARK=1.5;
                break;
            case IMPOSSIBLE:
                VITESSE_PLAYER_FISH=2.3;
                VITESSE_BIG=1;
                VITESSE_MEDIUM=3;
                VITESSE_SMALL=2;
                VITESSE_SHARK= 5;
                break;
        }
    }
}
