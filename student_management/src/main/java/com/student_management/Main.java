package com.student_management;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public void addStudent(Session session){
        Transaction tx=null;
        try{
        System.out.println("Enter details of the student:");
        System.out.print("Name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("Email:");
        String email=sc.next();
        System.out.print("Branch:");
        String branch=sc.next();
        System.out.print("Age:");
        int age=sc.nextInt();   
        Student s=new Student();
        s.set_name(name);
        s.set_email(email);
        s.set_branch(branch);
        s.set_age(age);
        tx=session.beginTransaction();
        session.save(s);
        tx.commit();
        System.out.println("Student added successfully!");  }
        catch(Exception e)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            System.out.println("Error adding student");
        } 
    }
    public void viewStudents(Session session){
        System.out.println("Fetching all Students...");
    }
    public void updateStudent(Session session){

    }
    public void deleteStudent(Session session){

    }
    
}
