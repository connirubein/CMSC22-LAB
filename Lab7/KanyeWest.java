package Lab7;

/**
 * Created by TalentFool
 */
public class KanyeWest extends Monster{

    public KanyeWest(String name, int hp) {
        super(name, hp);
    }
    
    public int attack() {
        if(randInt(1,2)==1){
           System.out.println(getName() + " used Special ATK Major burn");
            return randInt(20,25);
        } else {
           System.out.println(getName() + " used Yeezy");
            return randInt(15,20);
        }
    }
}
