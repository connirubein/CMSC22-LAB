package Lab7;

/**
 * Created by TalentFool
 */
public class Carrie extends Monster{
    
    public Carrie(String name, int hp) {
        super(name, hp);
    }
    
    public int attack() {
        if(randInt(1,2)==2){
           System.out.println(getName() + " used Special ATK Telekinesis");
            return randInt(20,25);
        } else {
           System.out.println(getName() + " used Underwood");
            return randInt(15,20);
        }

    }
}