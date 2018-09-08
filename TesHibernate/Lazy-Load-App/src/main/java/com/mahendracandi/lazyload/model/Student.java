package com.mahendracandi.lazyload.model;

import java.io.Serializable;

public class Student implements Serializable{
    private int idStudent;
    private String nameStudent;
    
    public Student(){
    
    }
    
    public Student(String name){
        this.nameStudent=name;
    }

    public int getIdStudent() {
        return idStudent;
    }
    
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    
    public void setNameStudent(String name){
        this.nameStudent=name;
    }
    
    public String getNameStudent(){
        return nameStudent;
    }


}
