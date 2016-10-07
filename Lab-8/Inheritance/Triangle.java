package Inheritance;

// created by Conni, Dianne, Joann
import java.lang.IllegalArgumentException;

public class Triangle extends Shape {
  private double side1;
  private double side2;
  private double side3;
  
  public Triangle(){
    this(1.0, 1.0, 1.0, "green", true);
  }
  
  public Triangle(double side1, double side2, double side3){
    this(side1, side2, side3, "green", true);
    if(side1>side2+side3 || side2>side1+side3 || side3>side1+side2){
      throw new IllegalArgumentException("Invalid sides");
    }
    
  }
  
  public Triangle(double side1, double side2, double side3, String color, boolean filled){
    super(color, filled);
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    
  }
  
  public double getSide1(){
    return side1;
  }
  
  public double getSide2(){
    return side2;
  }
  
  public double getSide3(){
    return side3;
  }
  
  public void setSide1(double s){
    if(s > (getSide2() + getSide3()) ){
      throw new IllegalArgumentException("Invalid sides");
    }
    this.side1 = s;
  }
  
  public void setSide2(double s){
    if(s > (getSide1() + getSide3()) ){
      throw new IllegalArgumentException("Invalid sides");
    }
    this.side2 = s;
  }
  
  public void setSide3(double s){
    if(s > (getSide1() + getSide2()) ){
      throw new IllegalArgumentException("Invalid sides");
    }
    this.side3 = s;
  }
  
  // Overriden method
  public double getArea(){
    double per = getPerimeter() /2;
    double x = ( per-getSide1() ) * ( per-getSide2() ) * ( per-getSide3() );
    if(x<0){
      x*= -1;
    }
    return Math.sqrt(per*x);
  }
  
  //Overridden method
  public double getPerimeter(){ 
    return side1 + side2 + side3;
  }
  
  @Override
  public String toString() {
    return String.format ("A Triangle with side 1 = " + side1 + " , side 2 = " + side2 + " , and side 3 = " + side3 + ",which is a subclass of " + super.toString());
  }
  
}