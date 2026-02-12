package com.student_management;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new  Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Main m=new Main();
        boolean running = true;
        
        while (running) 
        {
            int choice = m.menu();

            switch (choice) {
                case 1:
                    m.addStudent();
                    break;

                case 2:
                    m.viewStudents();
                    break;

                case 3:
                    m.deleteStudent();
                    break;

                case 4:
                    m.updateStudent();
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
}
