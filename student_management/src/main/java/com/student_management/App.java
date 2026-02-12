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
        System.out.println("Hello");
        
    }
}
