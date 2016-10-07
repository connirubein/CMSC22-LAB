package Lab7;

/**
 * Created by TalentFool
 */
public class DrMacintoshJava extends Monster{

    public DrMacintoshJava(String name, int hp) {
        super(name, hp);
    }
 
    public int attack() {
        if(randInt(1,2)==2){
           System.out.println(getName() + " used Special ATK TALENT");
            return randInt(20,25);
        }
        else{
           System.out.println(getName() + " used Speech");
            return randInt(15,20);
        }
    }
}
