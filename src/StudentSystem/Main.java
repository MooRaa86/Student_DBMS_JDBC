package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Select option to execute : ");
            System.out.println("1- Add new student");
            System.out.println("2- Show all students");
            System.out.println("3- Delete student by ID");
            System.out.println("4- Update student Info");
            System.out.println("5- Exit");
            char ch = in.next().charAt(0);
            switch(ch){
                case '1' :{
                    System.out.println("Student name : ");
                    String name = in.next();
                    System.out.println("Student city : ");
                    String city = in.next();
                    System.out.println("Student mark : ");
                    double mark = in.nextDouble();
                    boolean t = Utility.addStudent(name,city,mark);
                    if(t){
                        System.out.println("Student added successfully");
                    }else {
                        System.out.println("Error !!");
                    }
                    break;
                }
                case '2' :{
                    Utility.showStudents();
                    break;
                }
                case '3' : {
                    System.out.println("Enter Student ID you want to delete: ");
                    int id = in.nextInt();
                    boolean t = Utility.deleteStudent(id);
                    if(t){
                        System.out.println("Student deleted successfully");
                    }else{
                        System.out.println("Error !!");
                    }
                    break;
                }
                case '4' : {
                    System.out.print("Enter Student ID you want to update: ");
                    int id = in.nextInt();
                    System.out.print("Enter Student name : ");
                    String name = in.next();
                    System.out.print("Enter Student city : ");
                    String city = in.next();
                    System.out.print("Enter Student mark : ");
                    double mark = in.nextDouble();
                    boolean t = Utility.updateStudentById(id,name,city,mark);
                    if(t){
                        System.out.println("Student updated successfully");
                    }
                    else {
                        System.out.println("Error !!");
                    }
                    break;
                }
                case '5' : {
                    System.exit(0);
                }
                default : {
                    System.out.println("try again !!");
                }
            }
        }
    }
}