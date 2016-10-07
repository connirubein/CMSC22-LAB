package Inheritance;
// created by Conni, Dianne, Joann

public class Square extends Rectangle {
  public Square() {
    super(1.0, 1.0);
  }
  
  //call superclass Rectangle(double, double)
  public Square(double side) {
    super(side, side);
  }
  
  public Square(double side, String color, boolean filled) {
    super(side,side, color, filled);
  }
  
  public double getSide() {
    return super.getLength(); // we can choose either length or width to call because one way or another it will have the same value
  }
  
  public void setSide(double side) {
    super.setLength(side); // same here!
  }
  
  //Overridden method
  public void setWidth(double side) {
    super.setWidth(side);
  }
  
  //Overridden method
  public void setLength(double side) {
    super.setLength(side);
  }
  
  //Overriden getArea()
  public double getArea() {
    return Math.pow(getSide(), 2); 
  }
  
  //Overridden getPerimeter()
  public double getPerimeter(){
    return 4 * getSide();
  }

  public String toString() {
    return String.format ("A Square with side = " + getSide() + " which is a subclass of " + super.toString());
  }
}