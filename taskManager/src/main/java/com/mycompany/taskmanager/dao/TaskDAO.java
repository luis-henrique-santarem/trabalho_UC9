/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;


import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class TaskDAO {
    
    public static boolean registertask (Task task) { 
        
        String sql = "INSERT INTO task (title, description, due_date, status) VALUES (?, ?, ?, ?)";
        
      
        try(Connection conn = ConnectionSQL.conectar()) { 
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDue_date());
            stmt.setString(4, task.getStatus());
            stmt.executeUpdate();
            return true;  
        }catch(SQLException e) { 
            e.printStackTrace();
            return false;
        }
    }
      
    public static boolean removeTask (Task task) { 
        
        String sql = "DELETE FROM task WHERE title  = ? ";
        
        try(Connection conn = ConnectionSQL.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql) ) { 
            
            stmt.setString(1, task.getTitle());
            return stmt.executeUpdate() > 0;
            
        }catch(SQLException e){ 
           e.printStackTrace();
           return false;
        }
    }
    
    public boolean editTask (Task task ) { 
        String sql = "UPDATE task SET title = ?, description = ?, due_date = ?, status = ?";
        
        try(Connection conn = ConnectionSQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) { 
            
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDue_date());
            stmt.setString(4, task.getStatus());
            return stmt.executeUpdate() > 0;
            
            
        }catch(SQLException e) { 
            e.printStackTrace();
        }
        return false;
    }
    
    public static Task searchTaskByTitle(String titulo) {
    String sql = "SELECT * FROM task WHERE title = ?";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Task task = new Task(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("due_date"),
                rs.getString("status")
            );
            task.setId(rs.getInt("id"));
            return task;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
    
    public ArrayList<Task> listTask() { 
    ArrayList<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM task ORDER BY id ASC";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Task task = new Task(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("due_date"),
                rs.getString("status")
            );
            task.setId(rs.getInt("id"));
            tasks.add(task);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tasks;
}
   
}
    

