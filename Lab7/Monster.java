package Lab7;

import java.util.Random;
/**
 * Created by TalentFool
 */
public abstract class Monster extends RPGCharacter{
    public Random rand;
    public Monster(String name, int hp) {
        super(name, hp);   
    }
     
    public abstract int attack();
    
    public void pickMove(){
    }
    
    public boolean coinToss(){
      if ( randInt(1,2) == 1 ){
        return true;
      }
      return false;
    }

}
