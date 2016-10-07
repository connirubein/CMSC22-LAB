package Lab7;
import java.util.Scanner;
import java.util.Random;
/**
 * Created by TalentFool
 */
public class Merida extends Hero {

    public Merida(String name, int level) {
        super(name, level);
    }
    
    public boolean coinToss(){
      if(heroMove == 1) {
        if (randInt(1,10) <= 8) {
          return true;
        }
      }
      
      else{
        if (randInt(1,10) <= 9) {
          return true;
        }
      }
      return false;
    }

    public int attack() {
      if (heroMove == 2) {
        System.out.println(getName() + " used Special ATK Bull's Eye");
        manna-=5;
        return 22;
      }
      
      else {
        System.out.println(getName() + " used Bow and Arrow"); 
        return BASE_ATTACK;
      }
   }
    
    public void pickMove(){
      Scanner sc = new Scanner(System.in);
      int x;
      do{
        System.out.println("Available move/s:\n\n\t1 - Bow and Arrow");
        if (manna>=5){
          System.out.println("\t2 - Bull's eye");
        }
        x = sc.nextInt();
      }while(x<1 || x>2 && (x==2 && manna<5) );
      
      heroMove = x;
    }
}
