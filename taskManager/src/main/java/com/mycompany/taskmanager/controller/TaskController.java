/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.database.ConnectionSQL;

import com.mycompany.taskmanager.model.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class TaskController {
    
     private static TaskDAO taskDAO = new TaskDAO();
    
    public static boolean registerTask(String title, String description, String dueDate, String status) {
        Task task = new Task(title, description, dueDate, status);
        return taskDAO.registertask(task);
    }

    public static boolean updateTask(Task task) {
        return taskDAO.editTask(task);
    }

    public static boolean removeTask(Task task) { 
    String sql = "DELETE FROM task WHERE id = ?";
    
    try (Connection conn = ConnectionSQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, task.getId());
        return stmt.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public static boolean removeTask(int id) {
        Task task = new Task();
        task.setId(id);
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

    
}
