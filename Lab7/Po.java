package Lab7;
import java.util.Scanner;
/**
 * Created by TalentFool
 */
public class Po extends Hero {

    public Po(String name, int level) {
        super(name, level);
    }
    
    public boolean coinToss(){
      if(heroMove == 1) {
        if (randInt(1,2)==1){
          return true;
        }
      }
      
      else{
        if (randInt(1,5) <= 4){
          return true;
        }
      }
      return false;
    }

    public int attack() {
      if (heroMove == 2){
        System.out.println(getName() + " used Special ATK Wuxi Finger Hold");
        manna-=5;
        return 24;
      }
      
      else {
        System.out.println(getName() + " used Belly Gong");
        return BASE_ATTACK;
      }
    }
    
    public void pickMove(){
      Scanner sc = new Scanner(System.in);
      int x;
      do{
        System.out.println("Available move/s:\n\n\t1 - Belly Gong");
        if (manna>=5){
          System.out.println("\t2 - Wuxi Finger Hold");
        }
        x = sc.nextInt();
      }while(x<1 || x>2 && (x==2 && manna<5) );
      heroMove = x;
    }
}
