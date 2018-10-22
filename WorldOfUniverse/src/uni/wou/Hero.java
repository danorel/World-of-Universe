package uni.wou;

import java.io.*;
import java.util.ArrayList;

public class Hero implements Serializable {
    // Hero stats variables: Hero name, Hero specialisation, Hero power etc.
    private FileInputStream fileIStream;
    private ObjectOutputStream os;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> specs = new ArrayList<>();
    private ArrayList<Integer> powers = new ArrayList<>();
    private ArrayList<Integer> hps = new ArrayList<>();
    private int currentHero = 0;
    private int currentSpec = 0;
    transient private Weapon weapons = new Weapon();
    transient private String weaponsList = weapons.toString();
    transient private String currentWeapon;
    transient private int currentWeaponNumber = 0;

    // Constructor, which creates a hero
    public Hero(String name, String spec) {
        /*
            Adding specialisations for creating your hero.
            - Warrior - attacks with weapons of type swords. Health level starts from 200hp. Power level starts from 10pts. Level of mastering swords: 1lvl.
            - Wizard - attacks with casting spells. Starting spell - fire. Health level: 80hp. Power level starts from 2pts. Level of mastering wizard knives: 1lvl.
         */

        // Hero's specialisation
        specs.add("Elf");
        specs.add("Warrior");
        specs.add("Druid");
        specs.add("Wizard");
        specs.add("Rogue");

        // HP Hero's level
        hps.add(155);
        hps.add(200);
        hps.add(130);
        hps.add(80);
        hps.add(140);

        // Hero's power level
        powers.add(5);
        powers.add(10);
        powers.add(3);
        powers.add(2);
        powers.add(8);

        boolean correctSpec = false;
        boolean correctName = false;
        try {
            int specCounter = 0;
            do{
                if(spec.equals(this.specs.get(specCounter))){
                    correctSpec = true;
                    this.currentSpec = specCounter;
                    int nameCounter = 0;
                    if(this.names.size() == 0){
                        names.add(name);
                        correctName = true;
                    } else {
                        do{
                            if(name.equals(this.names.get(nameCounter))){
                                System.err.println("This name is already exists! Try another one!");
                                correctName = false;
                                break;
                            } else{
                                correctName = true;
                            }
                        } while(nameCounter != this.names.size());
                    }
                    break;
                }
                specCounter++;
            } while(specCounter != this.specs.size());
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            if(!correctSpec || !correctName){
                System.err.println("Re-assign specialisation or name of your hero!");
            } else {
                System.out.println("Assignment went successfully!");
            }
        }
    }

    // Hero opportunities
    public String getWeapon(int counter){
        return this.weapons.toString();
    }

    public void useWeapon(int counter){
        this.currentWeaponNumber = counter;
    }

    private int getPower(){
        return this.powers.get(currentHero);
    }

    private String getName(){
        return this.names.get(currentHero);
    }

    private String getSpecialisation(){
        return this.specs.get(currentHero);
    }

    public void changeHero(int currentHero, String name){
        try{
            int counter = 0;
            do{
                if(name.equals(this.names.get(currentHero))){
                    this.currentHero = currentHero;
                    break;
                }
                counter++;
            } while(counter != this.names.size());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void getHeroStats(){
        System.out.println("Stats:");
        System.out.println("Name: " + this.names.get(this.currentHero));
        System.out.println("Spec: " + this.specs.get(this.currentSpec));
        System.out.println("HP: " + this.hps.get(currentSpec));
        System.out.println("Power: " + this.powers.get(currentSpec));
    }

    /*
        Methods, which are saving all data about all personages in the game.
     */

    public void SaveHeroObject(Hero hero) throws IOException {
        os = new ObjectOutputStream(new FileOutputStream("MyGame.ser"));
        os.writeObject(hero);
        os.close();
    }

    public Hero RecoverHeroObject() {
        try{
            fileIStream = new FileInputStream("MyGame.ser");
            ObjectInputStream is = new ObjectInputStream(fileIStream);
            Object obj = is.readObject();
            Hero recoveredHero = (Hero) obj;

            return recoveredHero;
        } catch(Exception ex) {
            System.err.println(ex);
            return new Hero(null, null);
        }
    }
}
