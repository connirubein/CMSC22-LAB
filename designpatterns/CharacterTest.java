package designpatterns;
import java.util.*;

public class CharacterTest{

 public static void main(String[] args){

  Character hari = new King();   //whook
  Character reyna = new Queen();  //thwaack... thud
  Character gabii = new Knight();  //shickkk
  Character trolly = new Troll();  //chuggg

  System.out.println("> TEST 1");
  hari.fight();
  reyna.fight();
  gabii.fight();
  trolly.fight();

////

  Character king1 = new King(new BowAndArrowBehavior());  //t...t
  Character queen1 = new Queen(new KnifeBehavior());  //w
  Character knight1 = new Knight(new AxeBehavior());  //c
  Character troll1 = new Troll(new SwordBehavior());  //s

  System.out.println("> TEST 2");
  king1.fight();
  queen1.fight();
  knight1.fight();
  troll1.fight();

////

  Character king3Test = new King(new AxeBehavior());  //c
  Character queen3Test = new Queen(new SwordBehavior());  //s
  Character knight3Test = new Knight(new BowAndArrowBehavior());  //t...t
  Character troll3Test = new Troll(new KnifeBehavior());  //w
  
  System.out.println("> TEST 3");
  king3Test.fight();
  queen3Test.fight();
  knight3Test.fight();
  troll3Test.fight();

////

  Character kingTest = new King(new SwordBehavior());  //s
  Character queenTest = new Queen(new AxeBehavior());  //c
  Character knightTest = new Knight(new BowAndArrowBehavior());  //t..t
  Character trollTest = new Troll(new KnifeBehavior());  //w

  System.out.println("> TEST 4");
  kingTest.fight();
  queenTest.fight();
  knightTest.fight();
  trollTest.fight();

  
 } 
}
