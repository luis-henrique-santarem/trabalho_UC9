/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.Task;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class TaskController {
    
    private static TaskDAO taskDAO = new TaskDAO();
    
    public boolean registerTask(String title, String description, String dueDate, String status) {
        Task task = new Task(title, description, dueDate, status);
        return taskDAO.registertask(task);
    }
    
    public boolean removeTask(String title) {
        Task task = new Task(title, "", "", "");
        return taskDAO.removeTask(task);
    }

   
public static void listTask(DefaultTableModel model) {
        ArrayList<Task> tasks = taskDAO.listTask();

        model.setRowCount(0); 

        for (Task task : tasks) {
            model.addRow(new Object[] {
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDue_date(),
                task.getStatus()
            });
        }        

    }
    
    public boolean editTask(int id, String title, String description, String dueDate, String status) {
        Task task = new Task(title, description, dueDate, status);
        task.setId(id);
        TaskDAO dao = new TaskDAO();
        return dao.editTask(task);
    }
    
    public static Task searchTaskByTitle(String title) {
    TaskDAO dao = new TaskDAO();
    return dao.searchTaskByTitle(title);
}
    
}
