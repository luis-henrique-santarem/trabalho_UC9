/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author LUISHENRIQUEPEDROSOS
 */
public class ConnectionSQL {
    
    // Carrega as variáveis do arquivo .env
    private static final Dotenv dotenv = Dotenv.load();

    private static Connection connection;

    // Variáveis de conexão
    private static final String URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    // Conecta ao banco de dados
    public static Connection conectar() {
        try {
            // Se ainda não houver conexão, cria uma nova
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
                
                System.out.println("Conectado ao banco.");
            }
        } catch (SQLException error) {
            throw new RuntimeException("Erro na conexão com o banco de dados", error);
        }

        return connection;
    }

}
