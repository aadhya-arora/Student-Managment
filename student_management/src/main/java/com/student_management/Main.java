package com.student_management;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        try{
            System.out.println("Choose an option:");
            System.out.println("1. View all students");
            System.out.println("2. View students by branch");
            System.out.println("3. View a particular student");
            System.out.print("Your choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Fetching all students...");
                    Query q1=session.createQuery("from Student");
                    List<Student> students1=q1.getResultList();
                    for(Student s:students1)
                    {
                        System.out.println("Name:"+s.get_name());
                        System.out.println("Email:"+s.get_email());
                        System.out.println("Branch:"+s.get_branch());
                        System.out.println("Age:"+s.get_age());
                    }
                    break;
                case 2:
                    System.out.print("Enter branch:");
                    String branch=sc.next();
                    System.out.println("Fetching students by branch...");
                    Query q= session.createQuery("from Student where s_branch=:branch");
                    q.setParameter("branch", branch);
                    List<Student> students=q.getResultList();
                    for(Student s:students)
                    {
                        System.out.println("Name:"+s.get_name());
                        System.out.println("Email:"+s.get_email());
                        System.out.println("Branch:"+s.get_branch());
                        System.out.println("Age:"+s.get_age());
                    }
                    break;
                case 3:
                    System.out.print("Enter student id:");
                    int id=sc.nextInt();
                    System.out.println("Fetching a particular student...");
                    Student s3=null;
                    s3=session.get(Student.class,id);
                    if(s3!=null)
                    {
                        System.out.print("Student details:");
                        System.out.println("Name:"+s3.get_name());
                        System.out.println("Email:"+s3.get_email());
                        System.out.println("Branch:"+s3.get_branch());
                        System.out.println("Age:"+s3.get_age());
                    }
                    else
                    {
                        System.out.println("Student not found!");
                    }
                    break;
                default:
                    System.out.println("Invlaid choice.");
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error fetching students");
        }
    }
    public void updateStudent(Session session){

    }
    public void deleteStudent(Session session){

    }
    
}
