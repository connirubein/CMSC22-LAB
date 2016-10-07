package Inheritance;
// created by Conni, Dianne, Joann

public class ShapeTest {
  public static void main (String[] args) {
     Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
     System.out.println(s1);                    // which version?
    //System.out.println(s1.getArea());          // which version?  //cannot instantiate unless abstract method
     //System.out.println(s1.getPerimeter());     // which version?    //cannot instantiate unless bstract method
     System.out.print("Color:  ");
     System.out.println(s1.getColor());
     System.out.print("Filled:  ");
     System.out.println(s1.isFilled());
    // System.out.println(s1.getRadius()); //Shape has no getRadius() method, only in circle

     Circle c1 = (Circle)s1;                   // Downcast back to Circle
     System.out.println(c1);
     System.out.print("Area:  ");
     System.out.println(c1.getArea());
     System.out.print("Perimeter:  ");
     System.out.println(c1.getPerimeter());
     System.out.print("Color:  ");
     System.out.println(c1.getColor());
     System.out.print("Filled:  ");
     System.out.println(c1.isFilled());
     System.out.print("Radius:  ");
     System.out.println(c1.getRadius());

     Shape s2 = new Shape();

     Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
     System.out.println(s3);
    // System.out.println(s3.getArea()); //Shape is the "remote control" of s3. Shape doesn't have a getArea() method
    // System.out.println(s3.getPerimeter()); //Shape is the "remote control" of s3. Shape doesn't have a getPerimeter() method
     System.out.print("Color:  ");
     System.out.println(s3.getColor());
     //System.out.println(s3.getLength()); // Shape is the "remote control" of s3. Shape doesn't have a getLength() method

     Rectangle r1 = (Rectangle)s3;   // downcast
     System.out.println(r1);
     System.out.print("Area:  ");
     System.out.println(r1.getArea());
     System.out.print("Color:  ");
     System.out.println(r1.getColor());
     System.out.print("Length:  ");
     System.out.println(r1.getLength());

     Shape s4 = new Square(6.6);     // Upcast
     System.out.println(s4);
     //System.out.println(s4.getArea()); Shape is the "remote control" of s4 Shape doesn't have a getArea() method
     System.out.print("Color:  ");
     System.out.println(s4.getColor());
    // System.out.println(s4.getSide()); //Shape is the "remote control" of s4. Shape doesn't have a getSide() method

     // Take note that we downcast Shape s4 to Rectangle, 
     //  which is a superclass of Square, instead of Square
     
     Rectangle r2 = (Rectangle)s4;
     System.out.println(r2);
     System.out.print("Area:  ");
     System.out.println(r2.getArea());
     System.out.print("Color:  ");
     System.out.println(r2.getColor());
     //System.out.println(r2.getSide()); //Rectangle is the "remote control" of r2, which has components of s4. Rectangle doesn't have a getArea() method
     System.out.print("Length:  ");
     System.out.println(r2.getLength());

     // Downcast Rectangle r2 to Square
     Square sq1 = (Square)r2;
     System.out.println(sq1);
     System.out.print("Area:  ");
     System.out.println(sq1.getArea());
     System.out.print("Color:  ");
     System.out.println(sq1.getColor());
     System.out.print("Side:  ");
     System.out.println(sq1.getSide());
     System.out.print("Length:  ");
     System.out.println(sq1.getLength());
     
     
     Shape s5 = new Triangle(5.5, 6.0, 11.1, "BLACK", true);
     System.out.println(s5);
     //System.out.println(s5.getArea());    //error: getArea() is not inside Shape class
     System.out.println(s5.getColor());
     //System.out.println(s5.getSide1());  //error: getSide1() is not inside Shape class
     //System.out.println(s5.getSide2());  //error: getSide1() is not inside Shape class
     //System.out.println(s5.getSide3());  //error: getSide1() is not inside Shape class
     //System.out.println(s5.getPerimeter()); //error: getPerimeter() is not inside Shape class
     
     // Downcast Shape to Triangle
     Triangle t1 = (Triangle)s5;
     System.out.println(t1);
     System.out.println(t1.getArea());
     System.out.println(t1.getColor());
     System.out.println(t1.getSide1());
     System.out.println(t1.getSide2());
     System.out.println(t1.getSide3());
     System.out.println(t1.getPerimeter());

  }
}