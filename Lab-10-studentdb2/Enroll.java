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

    private static final String FILE_NAME = "testing.txt";

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> myList = new ArrayList<Student>();
        Student student = null;
        BufferedReader br = null;

        String studentNumber = null;
        String firstName = null;
        String lastName = null;
        String course = null;
        char middleInitial = 'a';
        int yearLevel = 0;
        int count = 0;

        try {

            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);

            String sCurrentLine;
            br = new BufferedReader(new FileReader("testing.txt"));
            int counter = 0;
            for(; ( sCurrentLine = br.readLine() ) != null; counter++);
            counter /=8;

            while (counter>0) {

                Student s = (Student) ois.readObject();

                myList.add(s);

                counter--;
            }

        } catch (IOException m) {
            m.printStackTrace();
        } catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } finally {

            // make sure to close the files!
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int choice;
        do{
            System.out.println("\t\tMenu\n\t1. Register Student\n\t2. Search Student\n\t3. Delete Student\n\t4. Save Student\n\t5. Exit\n");
            choice = new Scanner(System.in).nextInt();
            boolean b = false;

            switch (choice) {

                case 1: {

                    System.out.println("Student Number:");
                    String isStudentNumber = new Scanner(System.in).nextLine();
                    check(myList, isStudentNumber);

                    System.out.println("First Name:");
                    String isFirstName = new Scanner(System.in).nextLine();

                    System.out.println("Middle Initial:");
                    char isMiddleInitial = new Scanner(System.in).next(".").charAt(0);

                    System.out.println("Last Name:");
                    String isLastName = new Scanner(System.in).nextLine();

                    System.out.println("Degree Program:");
                    String isCourse = new Scanner(System.in).nextLine();

                    System.out.println("Year Level:");
                    int isYearLevel = new Scanner(System.in).nextInt();

                    System.out.println("Crush's Name:");
                    String isCrushName = new Scanner(System.in).nextLine();

                    System.out.println("Favorite Subject:");
                    System.out.print("Course Code:");
                    String isCourseCode = new Scanner(System.in).nextLine();
                    System.out.print("\nCourse Description:");
                    String isCourseDescription = new Scanner(System.in).nextLine();
                    System.out.println();


                    student = new Student(isStudentNumber, isFirstName, isMiddleInitial, isLastName, isCourse, isYearLevel, isCrushName, isCourseCode, isCourseDescription);
                    myList.add(student);
                    System.out.println("\nSTUDENT ADDED!");
                    break;
                }

                case 2: {

                    System.out.println("Search Student:");
                    String searchStudentNumber = new Scanner(System.in).nextLine();

                    for(Student s: myList) {
                        if(s.getStudentNumber().equals(searchStudentNumber)){
                            System.out.println("Student Number: " + s.getStudentNumber() + "\n"
                                    + "Name: " + s.getLastName() + ", " + s.getFirstName() + " " + s.getMiddleInitial() + "." + "\n"
                                    + "Program: " + s.getCourse() + "\n"
                                    + "Year Level: " + s.getYearLevel() + "\n");
                            b = true;
                            break;
                        }
                    }
                    if(b == false){
                        System.out.println("Student does not exist!\n");
                    }

                    break;
                }

                case 3: {
                    System.out.println("Delete Student:");
                    String deleteStudent = new Scanner(System.in).nextLine();
                    for(Student s: myList) {
                        if(s.getStudentNumber().equals(deleteStudent)){
                            myList.remove(s);
                            System.out.println("\nStudent " + s.getStudentNumber() + " deleted!\n");
                            b = true;
                            break;
                        }
                    }
                    if(b == false){
                        System.out.println("Cannot remove student. No such student found.\n");
                    }
                    break;

                }

                case 4: {
                    try {
                        File file = new File("testing.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        // serialize...
                        fos = new FileOutputStream(FILE_NAME);
                        oos = new ObjectOutputStream(fos);

                        //FileWriter fw = new FileWriter(file);
                        //BufferedWriter bw = new BufferedWriter(fw);
                        for(Student s: myList) {
                            oos.writeObject(s);
                            oos.writeObject("\n");
                        }
                        //bw.close();

                        oos.close();

                        System.out.println("Saved!\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                }       //end of case 4

                case 5: {
                    System.out.println("Exit!");
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid input!\n");
            }
        }while(choice != 5);

    }
    private static void check(List<Student> myList, String studentNumber){
        for (Student s: myList){
            if(s.getStudentNumber().equals(studentNumber)){
                throw new IllegalArgumentException("Student already exist!");
            }
        }
    }



}