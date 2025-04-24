/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class CreateTables {
 
    public static void createTable (Connection connection) { 
        
        String sql = "CREATE TABLE IF NOT EXISTS task("
                        +   "id INT AUTO_INCREMENT PRIMARY KEY,"
                        +  "title VARCHAR(255) NOT NULL,"
                        +   "description TEXT,"
                         +    "due_date VARCHAR(255),"
                          + " status ENUM('pendente', 'concluido') DEFAULT 'pendente') ";
        
        try(Statement stmt = connection.createStatement()) {
             stmt.execute(sql);
             System.out.println("Tables created.");
         }catch(SQLException error ){
             JOptionPane.showMessageDialog(null, "Error:" + error.getMessage());
                     
                  
         }
     
    }
    
}
