package com.student_management;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class Main_Library {
    
    public static int menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        System.out.println("Please select an option:");
        System.out.println("1.Add Book");
        System.out.println("2.View Books");
        System.out.println("3.Delete Book");
        System.out.println("4.Update Book");
        System.out.println("5.Exit");
        int choice=sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void addBook(Session session){
        Transaction tx=null;
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter details of the book:");
            System.out.print("Book Name:");
            sc.nextLine();
            String book_name=sc.nextLine();
            System.out.print("Author:");
            String author=sc.nextLine();
            System.out.print("Genre:");
            int genre=sc.nextInt();
            Library l=new Library();
            l.setBook_name(book_name);
            l.setAuthor(author);
            l.setGenre(genre);
            tx=session.beginTransaction();
            session.save(l);
            tx.commit();
            System.out.println("Book added successfully!");
        } catch(Exception e){
            if(tx!=null)
            {
                tx.rollback();
            }
            System.out.println("Error adding book");
        }
    }
    public static void viewBooks(Session session){
        
    }
    public static void deleteBook(Session session){
        
    }
    public static void updateBook(Session session){
        
    }
}
