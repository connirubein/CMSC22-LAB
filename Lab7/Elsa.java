package Lab7;
import java.util.Scanner;
/**
 * Created by TalentFool
 */
public class Elsa extends Hero {
    
    public Elsa(String name, int level) {
        super(name, level);
    }
    
    public boolean coinToss(){
      if (randInt(1,2)==1){
          return true;
      }
      return false;
    }
   

    public int attack() {
      if (heroMove == 2) {
        System.out.println(getName() + " used Special ATK Swirling Storm");
        manna-=5;
        return 20;
      }
      else {
        System.out.println(getName() + " used Ice Shards");
        return BASE_ATTACK; 
      }
    }
    
    public void pickMove(){
      int x;
      Scanner sc = new Scanner(System.in);
      do{
        System.out.println("Available move/s:\n\n\t1 - Ice Shards");
        if (manna>=5){
          System.out.println("\t2 - Swirling Storm");
        }
        x = sc.nextInt();
      }while(x<1 || x>2 && (x==2 && manna<5) );
      heroMove = x;
    }
}
