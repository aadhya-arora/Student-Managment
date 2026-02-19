package com.student_management;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Library.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Main_Student m = new Main_Student();
        Main_Library l=new Main_Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Student Management System!");
        System.out.println("Please select an option:");
        System.out.println("1.Student Management");
        System.out.println("2.Library Management");
        int mainChoice=sc.nextInt();
        sc.nextLine();


        if(mainChoice==1)
        {
            while (running) 
            {
                int choice = m.menu();

                switch (choice) {
                    case 1:
                        m.addStudent(session);
                        break;

                    case 2:
                        m.viewStudents(session);
                        break;

                    case 3:
                        m.deleteStudent(session);
                        break;

                    case 4:
                        m.updateStudent(session);
                        break;

                    case 5:
                        System.out.println("Exiting application...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        else if(mainChoice==2)
        {
            while(running)
            {
                int  choice=l.menu();
                switch(choice)
                {
                    case 1:
                        l.addBook(session);
                        break;
                    case 2:
                        l.viewBooks(session);
                        break;
                    case 3:
                        l.deleteBook(session);
                        break;
                    case 4:
                        l.updateBook(session);
                        break;
                    case 5:
                        System.out.println("Exiting Library Management System...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}