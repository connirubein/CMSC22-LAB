package studentdb2;
/**
 * Created by Conni on 11/3/2016.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Enroll {

    //private static final String FILE_NAME = "testing.txt";

    List<Student> lList = new ArrayList<Student>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    Student s = null;
    
    public static void main(String[] args) throws IOException {
        
        Enroll e = new Enroll();
        
        e.enrollment();
        
    }
    
    public void enrollment() throws IOException{
        
        try{
            
            //private static final String FILE_NAME = "input.txt";
            fis = new FileInputStream(input.txt);
            ois = new ObjectInputStream (fis);
            
            if(ois.read() == -1){
                
                lList = (List<Student>) ois.readObject();
            
            }
            
            ois.close();
        
        }//try
        
        catch(EOFException e){
            e.printStackTrace();
        }
        
        catch(ClassNotFoundException e){
            // this might be thrown by ois.readObject()
        }
        
        int choice;
        do{
            boolean studentExists = false;
            System.out.println("Menu\n\t1. Enroll a Student\n\t2. Search for a Student\n\t3. Unenroll a Student\n\t4. Save\n\t5. Exit");
            choice = new Scanner(System.in).nextInt();
            
            switch (choice) {

                case 1: {

                    System.out.println("Enter Student Number:");
                    String sNumber = new Scanner(System.in).nextLine();
                    errorCheck(lList, sNumber);
                    System.out.println("Enter First Name:");
                    String fName = new Scanner(System.in).nextLine();
                    System.out.println("Enter Middle Initial:");
                    char mInitial = new Scanner(System.in).next(".").charAt(0);
                    System.out.println("Enter Last Name:");
                    String lName = new Scanner(System.in).nextLine();
                    System.out.println("Enter Program:");
                    String program = new Scanner(System.in).nextLine();
                    System.out.println("Enter Year Level:");
                    int yrLevel = new Scanner(System.in).nextInt();
                    System.out.println("Crush's Name:");
                    String cName = new Scanner(System.in).nextLine();
                    System.out.println("Favorite Subject:");
                    System.out.print("\tCourse Code:");
                    String cCode = new Scanner(System.in).nextLine();
                    System.out.print("\n\tCourse Description:");
                    String cDescription = new Scanner(System.in).nextLine();
                    System.out.println();

                    s = new Student(sNumber, fName, mInitial, lName, program, yrLevel, cName, cCode, cDescription);
                    lList.add(s);
                    System.out.println("> Enrolled a student <");
                    break;
                }

                case 2: {

                    System.out.println("Look for a Student:");
                    String sNumber2 = new Scanner(System.in).nextLine();

                    for(Student ss: lList) {
                        
                        if(ss.getStudentNumber().equals(sNumber2)){
                            System.out.println("Student Number: " + ss.getStudentNumber() );
                            System.out.println("Name: " + ss.getLastName() + ", " + ss.getFirstName() + " " + ss.getMiddleInitial() + ".");
                            System.out.println("Program: " + ss.getCourse() );
                            System.out.println("Year Level: " + ss.getYearLevel() );
                            System.out.println("Crush's Name: " + ss.getCrushName() );
                            System.out.println("Favorite Subject:");
                            System.out.println("\tCourse Code: " + ss.getCourseCode() );
                            System.out.println("\tCourse Description: " + ss.getCourseDescription() );
                            studentExists = true;
                            break;
                        }
                        
                    }
                    
                    if(studentExists == false){
                        
                        System.out.println("> Student is not enrolled <");
                    
                    }

                    break;
                }   //case 2

                case 3: {
                
                    System.out.println("Unenroll a Student:");
                    String sNumber2 = new Scanner(System.in).nextLine();
                    for(Student ss: lList) {
                        if(ss.getStudentNumber().equals(sNumber2)){
                            lList.remove(ss);
                            System.out.println("Successful! Unenrolled Student with Student Number: " + s.getStudentNumber() );
                            studentExists = true;
                            break;
                        }
                    }
                
                    if(studentExists == false){
                
                        System.out.println("Error. Student wasn't enrolled in the first place :(");
                    
                    }
                    
                    break;

                }       //case 3

                case 4: {
                
                    try {
                        
                        //serialize
                        FileOutputStream fos = new FileOutputStream("input.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        
                        oos.writeObject(lList);
                        oos.close();
                        fos.close();
                        
                        System.out.println("> Save Successful <");
                        
                    }
                    
                    catch(IOException e){
                
                        e.printStackTrace();
                    
                    }
                
                    break;
                
                }       //end of case 4

                case 5: {
                    
                    System.out.println("Exit");
                    
                    break;
                
                }
                
                default:
                
                    throw new IllegalArgumentException("> Invalid <");
            
            }   //switch
            
        }while(choice != 5);
        
        finally {

            // make sure to close the files!
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   //finally
        
    }       //enrollment

       // FileOutputStream fos = null;
       // ObjectOutputStream oos = null;
        
    private static void errorCheck(List<Student> lList, String studentNumber){
        for (Student s: lList){
            if(s.getStudentNumber().equals(studentNumber)){
                throw new IllegalArgumentException("This student already exists!");
            }
        }
    }



}
