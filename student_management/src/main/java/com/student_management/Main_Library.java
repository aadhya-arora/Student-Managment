package com.student_management;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
            String book_name=sc.nextLine();
            System.out.print("Author:");
            String author=sc.nextLine();
            System.out.print("Genre:");
            String genre=sc.nextLine();
            Library l=new Library();
            l.setBook_name(book_name);
            l.setAuthor(author);
            l.setGenre(genre);
            tx=session.beginTransaction();
            session.save(l);
            tx.commit();
            System.out.println("Book added successfully!");
            sc.close();
        } catch(Exception e){
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Error adding book");
        }
    }
    public static void viewBooks(Session session){
        try {
            System.out.println("Choose an option:");
            System.out.println("1. View all books");
            System.out.println("2. View books by genre");
            System.out.println("3. View a book by ID");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Fetching all books...");
                    Query q1=session.createQuery("from Library");
                    List<Library> books=q1.getResultList();
                    for(Library b:books)
                    {
                        System.out.print(b.getId());
                        System.out.print("Book Name: "+b.getBook_name());
                        System.out.println("Author: "+b.getAuthor());
                        System.out.println("Genre: "+b.getGenre());
                    }
                    break;
                case 2:
                    System.out.println("Fetching books by genre...");
                    System.out.print("Enter genre:");
                    String genre=sc.nextLine();
                    Query q2=session.createQuery("from Library where genre=:genre");
                    q2.setParameter("genre",genre);
                    List<Library> books2=q2.getResultList();
                    for(Library b:books2){
                        System.out.print(b.getId());
                        System.out.print("Book Name: "+b.getBook_name());
                        System.out.println("Author: "+b.getAuthor());
                        System.out.println("Genre: "+b.getGenre());
                    }
                    break;
                case 3:
                    System.out.println("Fetching book by ID...");
                    System.out.print("Enter book ID:");
                    int id=sc.nextInt();
                    Query q3=session.createQuery("from Library where id=:id");
                    q3.setParameter("id", id);
                    List<Library> book3=q3.getResultList();
                    for(Library b:book3)
                    {
                        System.out.print(b.getId());
                        System.out.print("Book Name: "+b.getBook_name());
                        System.out.println("Author: "+b.getAuthor());
                        System.out.println("Genre: "+b.getGenre());
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error viewing books");
            
        }
        
    }
    public static void deleteBook(Session session){
        Scanner sc=new Scanner(System.in);
        Transaction tx2=null;
        try
        {
            System.out.println("Enter book ID to delete:");
            int id=sc.nextInt();
            tx2=session.beginTransaction();
            Library b=session.get(Library.class,id);
            if(b!=null)
            {
                session.delete(b);
                System.out.println("Book deleted successfully!");
            }
            tx2.commit();
        }
         catch(Exception e){
            e.printStackTrace();
            if(tx2!=null)
            {
                tx2.rollback();
            }
            System.out.println("Error deleting book");
         }
    }
    public static void updateBook(Session session){
        Transaction tx4=null;
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter book ID to update:");
            int id=sc.nextInt();
            System.out.println("Enter new details of the book:");
            System.out.print("Book Name:");
            String book_name=sc.nextLine();
            System.out.print("Author:");
            String author=sc.nextLine();
            System.out.print("Genre:");
            String genre=sc.nextLine();
            tx4=session.beginTransaction();
            Library s4=session.get(Library.class,id);
            if(s4!=null)
            {
                s4.setBook_name(book_name);
                s4.setAuthor(author);
                s4.setGenre(genre);
                session.update(s4);
            }
            tx4.commit();
        } 
        catch(Exception e)
        {
             if(tx4!=null)
            {
                tx4.rollback();
            }
            e.printStackTrace();
           
        }
    }
}
