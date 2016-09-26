import java.util.*;
import java.util.Arrays;
import java.lang.NullPointerException;
import java.lang.ArrayIndexOutOfBoundsException;


public class StringQueue{
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE = 10;

public StringQueue(){
    elements = new String[DEFAULT_SIZE];
}

public int size(){
    return count;
}

public void queue(String item){  //push

    if (count >= elements.length) {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    elements[count++] = item;
    

 }

 public String dequeue(){ //pop
  if (count <= 0) {
            throw new ArrayIndexOutOfBoundsException("WAY LINYA");
        } else {
            return elements[--count];
        }
 }

public String dequeue(int pos){ //pop
  if (count <= 0) {
            throw new ArrayIndexOutOfBoundsException("WAY LINYA");
        } else {
            int i;
            for(i = pos-1; i<count; i++){
                elements[i] = elements[i+1];
            }
            count--;
            return elements[pos-1];

        }
 }

 public String peek(){
  return elements[count - 1];
 }

 public String toString(){
  if (size() == 0) {
            return "WAY LINYA";
        }

        String str = "";
        for (int i = 0; i < count - 1; i++) {
            str += elements[i] + ", ";
        }
        return str + elements[size() - 1];
 }

 public void singit(int position, String x){
    if (count == 0){
        queue(x);
    }
    
    count++;
    int i;
    
    for(i = count-1; i>position-1; i--){
        elements[i] = elements[i-1];
    }

    elements[i] = x;

}

public static void main (String args[]){
    StringQueue line = new StringQueue();
    line.queue("dianne");
    line.queue("conni");
    line.queue("joann");
    System.out.println(line);
    line.singit(2,"nico");
    System.out.println(line);
    System.out.println(line.size());
    line.dequeue(2);
    System.out.println(line);
    line.dequeue();
    line.dequeue();
    System.out.println(line);//1 left
    line.queue("conni");
    line.queue("joann");
    line.singit(2,"nico");
    line.queue("person");
    line.queue("tao");
    line.singit(3,"chuchu");
    line.queue("lala");
    line.queue("tae");
    line.singit(5,"lolo");
    System.out.println(line.size());
    line.queue("hiii");//11th
    System.out.println(line);
    System.out.println(line.size());


}

}
