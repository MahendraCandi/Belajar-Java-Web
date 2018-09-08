package com.mahendracandi.lazyload.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Department implements Serializable{
    private int idDepartment;
    private String nameDepartment;
    private List<Student> student;
    
    public Department(){
    
    }
    
    public Department(String name){
        this.nameDepartment=name;
    }
    
    public int getIdDepartment(){
        return idDepartment;
    }
    
    public void setIdDepartment(int idDepartment){
        this.idDepartment=idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String name) {
        this.nameDepartment = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}