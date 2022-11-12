/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Hanna
 */
public class ConnectionManager {
    public static Connection getConnection(){
        Connection con=null;
        String url="jdbc:derby://localhost:1527/bloodDonationDB;create=true";
        String username="app";
        String password ="app";
        
        try{
            try{
                Class.forName("com.apache.derby.jdbc.ClientDriver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Printing Connection object "+ con);
        }
        catch (Exception e) 
     {
        e.printStackTrace();
     }
     return con; 
    }
}
