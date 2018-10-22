package uni.wou;

import java.io.Serializable;

public class Weapon implements Serializable {
    /*
        Will be completed after class Hero
     */
    transient private int[] weaponID = new int[10];
    private int numberOfWeapons = 0;
    // Arrays of weapon stats
    private String[] weapons = new String[10];
    private int[] powers = new int[10];
    private String[] types = new String[10];

    public void createWeapon(String name, String type, int power) {
        weapons[numberOfWeapons] = name;
        powers[numberOfWeapons] = power;
        types[numberOfWeapons] = type;
        weaponID[numberOfWeapons] = numberOfWeapons + 1;
        numberOfWeapons += 1;
    }

    public void getStatsOfWeapon(String name){
        int counter = 0;
        boolean found = false;
        do {
            if(name.equals(weapons[counter])){
                System.out.println("Name: " + weapons[counter]);
                System.out.println("Type: " + types[counter]);
                System.out.println("Power: " + powers[counter]);
                found = true;
                break;
            }
            counter++;
        } while(counter != weapons.length);
        if(found == false){
            System.err.println("Element with such name doesn't exist!");
        }
    }

    public void carryWeapon(){

    }
}
