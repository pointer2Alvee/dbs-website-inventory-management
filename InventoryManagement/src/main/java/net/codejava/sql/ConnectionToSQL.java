/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rahat
 */
public class ConnectionToSQL {
        
    private static String url = "jdbc:sqlserver://Rahat-Ashik\\SQLEXPRESS:1433;databaseName=Inventory Management";
    private static String user = "sa";
    private static String password = "rahat073";
    private static Connection connection;
        
    public static Connection getConnection(){    
        
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Succsessful");
            
            
        }catch(SQLException e){
                    System.out.println("LOL");
                    e.printStackTrace();
        }            
        return connection;
        
    }
    
    public static void main(String[] args){
        getConnection();
        System.out.println(url);
    }
    
}
    

