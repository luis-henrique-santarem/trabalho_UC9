/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanager;


import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.database.CreateTables;
import com.mycompany.taskmanager.view.mainView;
import java.sql.Connection;


/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class TaskManager {

    public static void main(String[] args) {
       Connection connection = ConnectionSQL.conectar();
        
        CreateTables.createTable(connection);
        
    
        
        
         
        new mainView().setVisible(true);
         
         
         }
    }

