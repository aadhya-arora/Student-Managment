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
        cfg.addAnnotatedClass(Library.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Main_Student m=new Main_Student();
        boolean running = true;
        
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
}
