package com.student_management;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String s_name;
    @Column(unique = true)
    private String s_email;
    private String s_branch;
    private int s_age;

    @OneToMany(mappedBy = "student",cascade=CascadeType.ALL)
    private List<Library> books_issued;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String get_name() {
        return s_name;
    }

    public void set_name(String s_name) {
        this.s_name = s_name;
    }

    public String get_email() {
        return s_email;
    }

    public void set_email(String s_email) {
        this.s_email = s_email;
    }

    public String get_branch() {
        return s_branch;
    }

    public void set_branch(String s_branch) {
        this.s_branch = s_branch;
    }

    public int get_age() {
        return s_age;
    }

    public void set_age(int s_age) {
        this.s_age = s_age;
    }

    public List<Library> getBooks_issued() {
        return books_issued;
    }

    public void setBooks_issued(List<Library> books_issued) {
        this.books_issued = books_issued;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("id=").append(id);
        sb.append(", s_name=").append(s_name);
        sb.append(", s_email=").append(s_email);
        sb.append(", s_branch=").append(s_branch);
        sb.append(", s_age=").append(s_age);
        sb.append(", books_issued=").append(books_issued);
        sb.append('}');
        return sb.toString();
    }

}
