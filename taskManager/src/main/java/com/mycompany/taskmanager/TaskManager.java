/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanager;


import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.database.CreateTables;
import com.mycompany.taskmanager.model.Task;
import java.sql.Connection;

/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class TaskManager {

    public static void main(String[] args) {
       Connection connection = ConnectionSQL.conectar();
        
        CreateTables.createTable(connection);
        
        
        //teste para ver se o método de registrar task esta funcionando
      Task newTask = new Task("Título de teste", "Descrição de teste", "2025-04-30", "pendente");
        // TaskDAO.registertask(newTask);
        
        // teste para ver se o método de remover esta funcionando
     //  TaskDAO.removeTask(newTask);
       
       
    }
}
