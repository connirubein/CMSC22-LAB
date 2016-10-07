package Abstract;

// created by Conni, Dianne, Joann

import java.lang.Math.*;

public abstract class Shape {
  protected String color;
  protected boolean filled;
  
  public Shape() {
    this("green", true);
  }
  
  public Shape(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }
  
  // implemented in subclass
  public abstract double getArea();
  
  //also implemented in subclass
  public abstract double getPerimeter();
  
  public String getColor() {
    return color;
  }
  
  public void setColor(String color) {
    this.color = color; 
  }
  
  public boolean isFilled() {
    return filled;
  }
  
  public void setFilled(boolean filled) {
    this.filled = filled; 
  }
  
  @Override
  public String toString() {
    return String.format ("A shape with color of " + color + " and " + filled);
  }
}
  