package com.student_management;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @Override
    public String toString(){
        return "Student [id=" + id + ", s_name=" + s_name + ", s_email=" + s_email + ", s_branch=" + s_branch
                + ", s_age=" + s_age + "]";
    }

}
