package Lab7;

import java.util.Random;

/**
 * Created by TalentFool
 */
public class Annabelle extends Monster{
    
    public Annabelle(String name, int hp) {
        super(name, hp);
    }
    
    public int attack() {
        
        if(randInt(1,2)==2){
           System.out.println(getName() + " used Kiss");
            return randInt(20,25);
        } else {
           System.out.println(getName() + " used Hug");
            return randInt(15,20);
        }
    }
    
    
}
