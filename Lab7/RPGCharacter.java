package Lab7;

import java.util.*;
import java.util.Random;

/**
 * Created by TalentFool
 */

public abstract class RPGCharacter {

    private String name;
    private int hp;
    
    public int manna = 10;

    public RPGCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    public static int randInt(int min, int max) {

      Random rand = new Random();
      int randomNum = rand.nextInt((max - min) + 1) + min;
      return randomNum;
    }
    
    // implement in subclass
    public abstract int attack();
    /*
    public int randInt(int num) {
        System.out.println("randinterr");
        int randomNum = rands.nextInt(num);
        return randomNum;
    }*/

    // checks to see if character is still alive
    public boolean isAlive() {
        return hp > 0 ? true : false;
    }
    
    // may be overriden in subclass, damage is dependent on hero type
    public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    // getters setters
    public String getName() {
        return name;
    }
    
    public abstract boolean coinToss();
    
    public abstract void pickMove();
    
    
   public int getManna(){
        return manna;
    }
    
    public void setManna(){
      if (manna<10){
        manna++;
        System.out.println("Mana: " + manna + "/10");
      }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
