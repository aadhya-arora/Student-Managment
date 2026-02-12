package com.student_management;
import java.util.Scanner;

public class Main {
    Scanner sc=new Scanner(System.in);
    public int menu(){
        System.out.println("Welcome to Student Managment System");
        System.out.println("Please select an option:");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Delete Student");
        System.out.println("4. Update Student");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
        int choice=sc.nextInt();
        return choice;
    }
    public void addStudent(){
    }
    public void viewStudents(){

    }
    public void updateStudent(){

    }
    public void deleteStudent(){

    }
    
}
