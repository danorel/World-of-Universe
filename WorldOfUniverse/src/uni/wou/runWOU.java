package uni.wou;

import java.io.*;

public class runWOU implements Serializable {
    public static void main(String[] args) {
        try {
            Hero hero1 = new Hero("Commander", "Warrior");
            hero1.getHeroStats();
            System.out.println();
            Hero hero2 = new Hero("Hunter", "Rogue");
            hero2.getHeroStats();

//            hero1.SaveHeroObject(hero1);
//
//            hero2.SaveHeroObject(hero2);
//            System.out.println();
//
//            Hero hero2Recovered = hero2.RecoverHeroObject();
//            hero2Recovered.getHeroStats();
//            System.out.println();
//            Hero hero1Recovered = hero1.RecoverHeroObject();
//            hero2Recovered.getHeroStats();


        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
