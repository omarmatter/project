/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class DB {
    public static Connection get_connection(){
         Connection connection=null;
         try {
            String url="jdbc:mysql://localhost:3306/dbforjava?serverTimezone=UTC";
                  Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,"root","");
             System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException ex) {
             System.out.println(ex.toString());
        }
        return connection;
    }
    
}
