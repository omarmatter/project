/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DBconnection {
    public static Connection get_connection(){
         Connection connection=null;
         try {
            String url="jdbc:mysql://localhost:3306/finalproject?serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,"root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("connected");
        return connection;
    }
//    public static boolean CheckLoginUser(String uname, String pass) { //get input from login system module
//        Connection connection = get_connection();
////        String checkQuery = "select * from registeredUser where user = ' "+uname+" ' and pass = ' "+pass+" ' ";
//        String checkQuery = "select *from users where email = ? and password = ? "; // i don't use id from database table.
//        
//        PreparedStatement preparedStatement = null;
//        boolean status = false; //initially false
//
//        try {
//            preparedStatement = connection.prepareStatement(checkQuery);
//            preparedStatement.setString(1, uname); // dynamically sending username
//            preparedStatement.setString(2, pass); // sending password to checkquery statement
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            /* while (resultSet.next()) {
//                return status;
//            } */
//
//            status = resultSet.next();
//            preparedStatement.close();
//            return status;
//
//        } catch (SQLException e) {
////            e.getLocalizedMessage();
//            e.printStackTrace();
//        }
//        return status;
//    }

}

