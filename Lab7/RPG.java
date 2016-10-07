package Lab7;

import java.util.*;
import java.lang.Object;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by TalentFool
 */
public class RPG {
  
    private static final int BASE_HEALTH = 100;

    private static Random rand;

    public RPG() {
        this.rand = new Random();
    }

    public static String getRaMonName() {
        String[] monsters = {"Chucky", "Annabelle", "Carrie", "Kanye West", "Dr. Macintosh Java"};
        return monsters[rand.nextInt(5)];
    }
    
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean heroDuel(RPGCharacter attacker, RPGCharacter defender, String name) {
   
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        int damage = attacker.attack();
        System.out.println("DAMAGE: " + damage);
        sleep(2000);
        if (attacker.coinToss()) {
          System.out.println("--> HIT!");
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        } else {
            System.out.println("--> MISSED!");
        }
        
        return false;
    }
    
     public boolean monsterDuel(RPGCharacter attacker, RPGCharacter defender) {
        
       System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        int damage = attacker.attack();
        
        System.out.println("DAMAGE: " + damage);
        sleep(2000);
        
        if ( attacker.coinToss() ) {
            System.out.println("--> HIT!");
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName() );
                return true;
            }
        }
        else {
            System.out.println("--> MISSED!");
        }
        
        return false;
    }
    
    public static void display(int i){
    
        if(i==0||i==1)
        System.out.print("\n\t1 - Merida\n\t\t>Archer\n\t\t>Ability: 70% accuracy\n\t\t>Specialty: 90% hit accuracy and +10% attack damage");
        
        if(i==0||i==2)
        System.out.print("\n\t2 - Elsa\n\t\t>Ice Queen\n\t\t>Ability: 50% hit accuracy\n\t\t>Specialty: 50% hit accuracy and reduce damage taken by 30%");
        
        if(i==0||i==3)
        System.out.print("\n\t3 - Po\n\t\t>Dragon Warrior\n\t\t>Ability: 50% hit accuracy\n\t\t>Specialty: 80% hit accuracy and no damage taken");
    
    }
    
    public static String choose(){
        
        int i=0;
        
        System.out.println("\t\t\t>>  CHOOSE YOUR HERO  <<");
        display(i);
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("\n\tEnter choice: ");
            i = sc.nextInt();
        }while (i<1 || i>3);
        
        if(i==1){
          return "Merida";
        }
        else if(i==2){
          return "Elsa";
        }
        else{
          return "Po";
        }
    
    }  
    
    // game...
    public static void main(String[] args) {
      
        int stage = 1;
        RPG rpg = new RPG();
        String name = choose();
        RPGCharacter hero;
        String monsName = getRaMonName();
        RPGCharacter monster;     
        
        
        if (monsName.equals("Chucky")){
          monster = new Chucky(monsName, BASE_HEALTH);
        
        }
        
        else if (monsName.equals("Annabelle")){
          monster = new Annabelle(monsName, BASE_HEALTH);
        
        }
        
        else if (monsName.equals("Carrie")){
          monster = new Carrie(monsName, BASE_HEALTH);
        
        }
        
        else if (monsName.equals("Dr. Macintosh Java")){
          monster = new DrMacintoshJava(monsName, BASE_HEALTH);
        
        }
        
        else {
          monster = new KanyeWest(monsName, BASE_HEALTH);
        
        }
        
        if (name.equals("Merida")){
            hero = new Merida(name, BASE_HEALTH); 
        }
        else if(name.equals("Elsa")){
            hero = new Elsa(name, BASE_HEALTH);
        }
        else{
            hero = new Po(name, BASE_HEALTH);
        }

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        int count = 0;
        while (true) {
            hero.setManna();
            monster.setManna();
            System.out.println("== round " + ++count);
            hero.pickMove();
            boolean monsterIsDead = rpg.heroDuel(hero, monster,name);
            if (monsterIsDead) break;
            
            boolean heroIsDead = rpg.monsterDuel(monster, hero);
            if (heroIsDead) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
        System.out.println("GAME OVER!!!");
    }
}
