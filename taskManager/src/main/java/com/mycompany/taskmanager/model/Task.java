/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class Task {
    
   
 private int id;
  private String description;
   private String title;
    private  String due_date ;
     private String  status;

    public Task(String title, String description, String due_date, String status) {
    this.title = title;
    this.description = description;
    this.due_date = due_date;
    this.status = status;
}

  
    public Task(int id, String title, String description, String due_date, String status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.due_date = due_date;
    this.status = status;
}

    
    public Task()  { 
        
    }
    
  
         

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}


