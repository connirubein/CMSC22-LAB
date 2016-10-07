  package Lab7;

  import java.util.Scanner;
  import java.util.Random;
/**
 * Created by TalentFool
 */
public abstract class Hero extends RPGCharacter {
    public Random rand;
    public static final int BASE_ATTACK = 20;
    public int heroMove;
    
    public Hero(String name, int hp) {
        super(name, hp);
    }
    
    public int getHM(){
      return heroMove;
    }
    
    public abstract int attack();
    
    public abstract boolean coinToss();
    
    public abstract void pickMove();

}
