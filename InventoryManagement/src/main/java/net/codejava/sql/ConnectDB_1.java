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
 * @author HP
 */
public class ConnectDB_1 {
    
    public static Connection getCon() throws SQLException{
        String url = "jdbc:sqlserver://Rahat-Ashik\\SQLEXPRESS:1433;databaseName=Inventory Management";
        String user = "sa";
        String pass = "rahat073";
        
        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            return con;
                     
        }catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
    
}
