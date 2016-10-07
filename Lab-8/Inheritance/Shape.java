package Inheritance;
// created by Conni, Dianne, Joann

public class Shape {
  private String color;
  private boolean filled;
  
  public Shape() {
    this("GREEN", true);
  }
  
  public Shape(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }
  
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
  
  public String toString() {
    return String.format ("A shape with color of " + color + " and " + filled);
  }
}
  