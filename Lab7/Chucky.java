package Lab7;

/**
 * Created by TalentFool
 */
public class Chucky extends Monster{

    public Chucky(String name, int hp) {
        super(name, hp);
    }
    
    public int attack() {
        if(randInt(1,2)==2){
           System.out.println(getName() + " used Special ATK Play!");
            return randInt(20,25);
        } else {
           System.out.println(getName() + " used Ugly Face");
            return randInt(15,20);
        }

    }
    
}
