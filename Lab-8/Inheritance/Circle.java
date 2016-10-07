package Inheritance;
// created by Conni, Dianne, Joann

import java.lang.Math.*;

public class Circle extends Shape {
  private double radius;
  
  public Circle() {
    this(1.0);
  }
  
  public Circle(double radius){
    this(radius, "GREEN", true);
  }
  
  public Circle(double radius, String color, boolean filled){
    super(color, filled);
    this.radius = radius;
  }
  
  public double getRadius(){
    return radius;
  }
    
  public void setRadius(double radius){
    this.radius = radius;
  }
  
  public double getArea(){
    return Math.PI * Math.pow(radius, 2);
  }
  
  public double getPerimeter(){
    return 2 * Math.PI * radius;
  }
  
  public String toString() {
    return String.format ("A Circle with radius = " + radius + " which is a subclass of " + super.toString());
  }
 
}
